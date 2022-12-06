package com.example.dagger.command

import com.example.dagger.Database
import com.example.dagger.Outputter
import javax.inject.Inject

class LoginCommand @Inject constructor(private val database: Database, private val outputter: Outputter) : SingleArgCommand() {
  override fun handleArg(arg: String): Pair<Command.Status,String> {
    val account: Database.Account = database.getAccount(arg)
    account.isLogin=true
    return Pair(Command.Status.HANDLED,outputter.output("$arg is logged in."))
  }
}
