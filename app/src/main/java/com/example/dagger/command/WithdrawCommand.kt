package com.example.dagger.command

import com.example.dagger.Database
import com.example.dagger.Outputter
import java.math.BigDecimal
import javax.inject.Inject

class WithdrawCommand @Inject constructor(private val outputter: Outputter, private val database: Database) :
    SingleArgCommand() {
    override fun handleArg(arg: String): Pair<Command.Status, String> {
        val account: Database.Account? = database.isUserLogin() ?: return Pair(Command.Status.INVALID,outputter.output("Please login first"))
        return if(isArgNumber(arg)){
            val number= BigDecimal(arg)
            val isWithdrawValid=account!!.withdraw(number)
            if(isWithdrawValid)
                Pair(Command.Status.HANDLED,outputter.output(account.username() + " balance after withdraw: " + account.balance()))
            else
                Pair(Command.Status.INVALID,outputter.output("Balance is not enough"))
        } else Pair(Command.Status.INVALID,outputter.output("$arg is not a valid number"))
    }
}