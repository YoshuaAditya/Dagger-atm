package com.example.dagger

import java.math.BigDecimal
import javax.inject.Inject

class Database @Inject constructor() {
  private val accounts: MutableMap<String, Account> = HashMap()
  fun getAccount(username: String): Account {
    return accounts.computeIfAbsent(
      username
    ) { uname: String? ->
      Account(
        uname
      )
    }
  }

  class Account(private val username: String?) {
    private val balance: BigDecimal = BigDecimal.ZERO
    fun username(): String? {
      return username
    }

    fun balance(): BigDecimal {
      return balance
    }
  }
}
