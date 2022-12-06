package com.example.dagger.command

import com.example.dagger.Outputter
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
