package com.example.dagger

import java.math.BigDecimal
import javax.inject.Inject

internal class DepositCommand @Inject constructor(private val database: Database, private val outputter: Outputter) :
    SingleArgCommand() {
    override fun handleArg(arg: String): Pair<Command.Status, String> {
        val account: Database.Account? = database.isUserLogin() ?: return Pair(Command.Status.INVALID,outputter.output("Please login first"))
        val integerChars = '0'..'9'
        return if(arg.all { it in integerChars }){
            val number=BigDecimal(arg)
            account!!.deposit(number)
            Pair(Command.Status.HANDLED,outputter.output(account.username() + " now has: " + account.balance()))
        } else Pair(Command.Status.INVALID,outputter.output("$arg is not a number"))
    }

}