package com.example.dagger

import dagger.Component

@Component
interface CommandRouterFactory {
    fun router(): CommandRouter
}
