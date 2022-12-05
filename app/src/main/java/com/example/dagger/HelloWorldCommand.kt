package com.example.dagger

import javax.inject.Inject

class HelloWorldCommand @Inject constructor() : Command {
  override fun key(): String {
    return "hello"
  }

  override fun handleInput(input: List<String>): Command.Status {
    if (!input.isEmpty()) {
      return Command.Status.INVALID
    }
    println("world!")
    return Command.Status.HANDLED
  }
}
