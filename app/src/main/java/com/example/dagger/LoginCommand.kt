package com.example.dagger

import javax.inject.Inject

class LoginCommand @Inject constructor(private val outputter: Outputter) : SingleArgCommand() {
  override fun handleArg(arg: String): Pair<Command.Status,String> {
    return Pair(Command.Status.HANDLED,outputter.output("$arg is logged in."))
  }
}
