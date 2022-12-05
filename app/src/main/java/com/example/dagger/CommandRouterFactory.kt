package com.example.dagger

import dagger.Component

@Component(modules = [LoginCommandModule::class,SystemOutModule::class])
interface CommandRouterFactory {
    fun router(): CommandRouter
}
