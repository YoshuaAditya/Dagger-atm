package com.example.dagger.command

import com.example.dagger.Outputter
import javax.inject.Inject

class HelloWorldCommand @Inject constructor(private val outputter: Outputter) : SingleArgCommand() {
  override fun handleArg(arg: String): Pair<Command.Status, String> {
    return Pair(Command.Status.HANDLED,outputter.output("Hello World!!"))
  }
}
