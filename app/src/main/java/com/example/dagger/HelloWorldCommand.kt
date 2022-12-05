package com.example.dagger

import javax.inject.Inject

class HelloWorldCommand @Inject constructor(private val outputter: Outputter) : Command {

  override fun key(): String {
    return "hello"
  }

  override fun handleInput(input: List<String>): Command.Status {
    if (!input.isEmpty()) {
      return Command.Status.INVALID
    }
    outputter.output("world!")
    return Command.Status.HANDLED
  }
}
