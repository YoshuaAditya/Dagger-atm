package com.example.dagger

import android.widget.TextView
import java.util.*
import javax.inject.Inject


class CommandRouter{
    private val commands = mutableMapOf<String, Command>()

    @Inject
    constructor(command: Command) {
        commands[command.key()] = command
    }
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