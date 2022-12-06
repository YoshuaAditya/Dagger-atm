package com.example.dagger.command

interface Command {
    /** Process the rest of the command's words and do something.  */
    fun handleInput(input: List<String>): Pair<Status,String>

    enum class Status {
        INVALID, HANDLED
    }
}