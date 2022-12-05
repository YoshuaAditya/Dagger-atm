package com.example.dagger

import android.widget.TextView
import java.util.*
import javax.inject.Inject


class CommandRouter @Inject constructor(){
    lateinit var output: TextView
    private val commands: Map<String, Command> = Collections.emptyMap()
    fun route(input: String): Command.Status {
        val splitInput = split(input)
        if (splitInput.isEmpty()) {
            return invalidCommand(input)
        }
        val commandKey = splitInput[0]
        val command = commands[commandKey] ?: return invalidCommand(input)
        val status: Command.Status = command.handleInput(splitInput.subList(1, splitInput.size))
        if (status === Command.Status.INVALID) {
            val textOutput=commandKey+ ": invalid arguments"
            output.text=textOutput
        }
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