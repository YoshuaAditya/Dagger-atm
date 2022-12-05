package com.example.dagger

import dagger.Binds
import dagger.Module


@Module
internal abstract class HelloWorldModule {
    @Binds
    abstract fun helloWorldCommand(command: HelloWorldCommand): Command
}
