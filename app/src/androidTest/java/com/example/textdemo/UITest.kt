package com.example.textdemo

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class UITest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkListViewDisplayed() {
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()))
    }

    @Test
    fun checkEditTextDisplayed() {
        onView(withId(R.id.editText)).check(matches(isDisplayed()))
    }
    @Test
    fun checkButtonDisplayed() {
        onView(withId(R.id.button)).check(matches(isDisplayed()))
    }

//    @Test
//    fun checkListViewText() {
//        onView(withId(R.id.editText)).perform(typeText("Steve"))
//        onView(withId(R.id.button)).perform(click())
//        onView(withId(R.id.listview)).check(matches(withText("Steve")));
//    }

}