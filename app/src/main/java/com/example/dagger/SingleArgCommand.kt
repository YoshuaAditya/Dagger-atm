package com.example.dagger

abstract class SingleArgCommand : Command {
  override fun handleInput(input: List<String>): Command.Status {
    return if (input.size == 1) handleArg(input[0]) else Command.Status.INVALID
  }

  /** Handles the single argument to the command.  */
  protected abstract fun handleArg(arg: String): Command.Status
}