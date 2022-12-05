package com.example.dagger

interface Command {
    fun key(): String

    /** Process the rest of the command's words and do something.  */
    fun handleInput(input: List<String>): Status

    enum class Status {
        INVALID, HANDLED
    }
}