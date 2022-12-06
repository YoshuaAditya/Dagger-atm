package com.example.dagger.command

abstract class SingleArgCommand : Command {
  override fun handleInput(input: List<String>): Pair<Command.Status,String> {
    return if (input.size == 1) handleArg(input[0]) else Pair(Command.Status.INVALID,"Hello World!")
  }

  fun isArgNumber(arg:String): Boolean{
    val integerChars = '0'..'9'
    return arg.all { it in integerChars }
  }

  /** Handles the single argument to the command.  */
  protected abstract fun handleArg(arg: String): Pair<Command.Status,String>
}