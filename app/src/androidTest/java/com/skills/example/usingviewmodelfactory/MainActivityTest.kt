package com.skills.example.usingviewmodelfactory

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @JvmField
    @Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun viewsIsDisplayed() {
        onView(withId(R.id.et_number)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_result)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_add)).check(matches(isDisplayed()))
    }

    @Test
    fun onEnteringNumber_andPressingButton_sumIsDisplayed() {

        onView(withId(R.id.et_number)).perform(typeText("150"), closeSoftKeyboard())
        onView(withId(R.id.btn_add)).perform(click())
        onView(withId(R.id.tv_result)).check(matches(withText("300")))

        onView(withId(R.id.et_number)).perform(typeText("50"), closeSoftKeyboard())
        onView(withId(R.id.btn_add)).perform(click())
        onView(withId(R.id.tv_result)).check(matches(withText("350")))
    }


}