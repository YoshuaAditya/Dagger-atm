package com.example.dagger

import java.math.BigDecimal
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
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

  fun isUserLogin(): Account? {
    var account: Account? = null
    for(user in accounts){
      if(user.value.isLogin){
        account= user.value
      }
    }
    return account
  }

  class Account(private val username: String?) {
    private var balance: BigDecimal = BigDecimal.ZERO
    var isLogin = false
    fun username(): String? {
      return username
    }

    fun balance(): BigDecimal {
      return balance
    }
    fun deposit(value: BigDecimal) {
      balance+=value
    }
  }
}
