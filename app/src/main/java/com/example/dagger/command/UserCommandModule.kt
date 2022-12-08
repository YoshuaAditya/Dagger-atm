package com.example.dagger.command

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey


@Module
internal abstract class UserCommandsModule {
    @Binds
    @IntoMap
    @StringKey("deposit")
    abstract fun depositCommand(command: DepositCommand): Command
    @Binds
    @IntoMap
    @StringKey("withdraw")
    abstract fun withdrawCommand(command: WithdrawCommand): Command
    @Binds
    @IntoMap
    @StringKey("logout")
    abstract fun logoutCommand(command: LogoutCommand): Command
}
