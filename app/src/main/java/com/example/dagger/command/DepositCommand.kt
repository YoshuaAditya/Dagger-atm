package com.example.dagger.command

import com.example.dagger.Database
import com.example.dagger.Outputter
import java.math.BigDecimal
import javax.inject.Inject

internal class DepositCommand @Inject constructor(private val database: Database, private val outputter: Outputter) :
    SingleArgCommand() {
    override fun handleArg(arg: String): Pair<Command.Status, String> {
        val account: Database.Account? = database.isUserLogin() ?: return Pair(Command.Status.INVALID,outputter.output("Please login first"))
        return if(isArgNumber(arg)){
            val number=BigDecimal(arg)
            account!!.deposit(number)
            Pair(Command.Status.HANDLED,outputter.output(account.username() + " now has: " + account.balance()))
        } else Pair(Command.Status.INVALID,outputter.output("$arg is not a valid number"))
    }

}