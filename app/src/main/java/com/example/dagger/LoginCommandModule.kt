package com.example.dagger

import dagger.Binds
import dagger.Module

@Module
abstract class LoginCommandModule {
    @Binds
    abstract fun loginCommand(command: LoginCommand): Command
}
