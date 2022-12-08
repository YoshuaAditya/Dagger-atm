package com.example.dagger

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class ExampleInstrumentedTest {
    @Test
    fun runApp() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withText("Available Commands:")).check(matches(isDisplayed()))
        //Hello command
        onView(withText("HELLO")).perform(click())
        onView(withText("SUBMIT")).perform(click())
        onView(withText("Hello World!!")).check(matches(isDisplayed()))
        //Deposit command before login
        onView(withText("DEPOSIT")).perform(click())
        onView(withText("SUBMIT")).perform(click())
        onView(withText("Please login first")).check(matches(isDisplayed()))
        //Login command
        onView(withText("LOGIN")).perform(click())
        onView(withText("SUBMIT")).perform(click())
        onView(withText("user is logged in.")).check(matches(isDisplayed()))
        //Withdraw command before deposit
        onView(withText("WITHDRAW")).perform(click())
        onView(withText("SUBMIT")).perform(click())
        onView(withText("Balance is not enough")).check(matches(isDisplayed()))
        //Deposit command
        onView(withText("DEPOSIT")).perform(click())
        onView(withText("SUBMIT")).perform(click())
        onView(withText("user now has: 100")).check(matches(isDisplayed()))
        //Deposit command again
        onView(withText("DEPOSIT")).perform(click())
        onView(withText("SUBMIT")).perform(click())
        onView(withText("user now has: 200")).check(matches(isDisplayed()))
        //Withdraw command
        onView(withText("WITHDRAW")).perform(click())
        onView(withText("SUBMIT")).perform(click())
        onView(withText("user balance after withdraw: 160")).check(matches(isDisplayed()))
        //Logout command
        onView(withText("LOGOUT")).perform(click())
        onView(withText("SUBMIT")).perform(click())
        onView(withText("user log out successfully.")).check(matches(isDisplayed()))
    }
}