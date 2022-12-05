package com.example.dagger

import javax.inject.Inject


class LoginCommand @Inject constructor(private val outputter: Outputter) : SingleArgCommand() {
  override fun key(): String {
    return "login"
  }

  override fun handleArg(arg: String): Command.Status {
    outputter.output("$arg is logged in.");
    return Command.Status.HANDLED;
  }
}
