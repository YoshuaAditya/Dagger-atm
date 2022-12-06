package com.example.dagger

import android.widget.TextView
import java.util.*
import javax.inject.Inject

//To inject Map, need the @JvmSuppressWildcards to workaround error provides
//More info: https://stackoverflow.com/questions/55669810/dagger-missingbinding-java-util-mapjava-lang-class-extends-viewmodel-provide/62260147#62260147
class CommandRouter @Inject constructor(private val commands: @JvmSuppressWildcards Map<String, Command>) {

    lateinit var output: TextView
    fun route(input: String): Command.Status {
        val splitInput = split(input)
        if (splitInput.isEmpty()) {
            return invalidCommand(input)
        }
        val commandKey = splitInput[0]
        val command = commands[commandKey] ?: return invalidCommand(input)
        val status: Command.Status = command.handleInput(splitInput.subList(1, splitInput.size))
        val textOutput=commandKey+ " command recognized"
        output.text=textOutput
        return status
    }

    private fun invalidCommand(input: String): Command.Status {
        output.text=(String.format("couldn't understand \"%s\". please try again.", input))
        return Command.Status.INVALID
    }

    companion object {
        // Split on whitespace
        private fun split(string: String): List<String> = string.split(" ")
    }
}