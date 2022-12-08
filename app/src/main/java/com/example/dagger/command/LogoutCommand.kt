package com.example.dagger.command

import com.example.dagger.Database
import com.example.dagger.Outputter
import javax.inject.Inject

class LogoutCommand @Inject constructor(private val database: Database, private val outputter: Outputter) : SingleArgCommand() {
  override fun handleArg(arg: String): Pair<Command.Status,String> {
    val account: Database.Account = database.isUserLogin() ?: return Pair(Command.Status.INVALID,outputter.output("Please login first"))
    account.isLogin=false
    return Pair(Command.Status.HANDLED,outputter.output("${account.username()} log out successfully."))
  }
}
