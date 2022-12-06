package com.example.dagger

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey


@Module
internal abstract class HelloWorldModule {
    @Binds
    @IntoMap
    @StringKey("hello")
    abstract fun helloWorldCommand(command: HelloWorldCommand): Command
}
