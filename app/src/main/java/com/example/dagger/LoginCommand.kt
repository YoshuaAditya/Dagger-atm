package com.example.dagger

import javax.inject.Inject

class LoginCommand @Inject constructor(private val database:Database,private val outputter: Outputter) : SingleArgCommand() {
  override fun handleArg(username: String): Pair<Command.Status,String> {
    val account: Database.Account = database.getAccount(username)
    return Pair(Command.Status.HANDLED,outputter.output("$username is logged in."))
  }
}
