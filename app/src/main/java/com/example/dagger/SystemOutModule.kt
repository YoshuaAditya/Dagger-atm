package com.example.dagger

import dagger.Module
import dagger.Provides

@Module
class SystemOutModule {
  @Provides
  fun textOutputter(): Outputter {
    return object : Outputter {
      override fun output(output: String) :String{
        //println(output)
        return output
      }
    }
  }
}
