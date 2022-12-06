package com.example.dagger.command

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [HelloWorldModule::class, LoginCommandModule::class, UserCommandsModule::class, SystemOutModule::class])
interface CommandRouterFactory {
    fun router(): CommandRouter
}
