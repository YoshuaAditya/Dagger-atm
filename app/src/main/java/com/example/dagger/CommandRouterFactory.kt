package com.example.dagger

import dagger.Component

@Component(modules = [HelloWorldModule::class,LoginCommandModule::class,SystemOutModule::class])
interface CommandRouterFactory {
    fun router(): CommandRouter
}
