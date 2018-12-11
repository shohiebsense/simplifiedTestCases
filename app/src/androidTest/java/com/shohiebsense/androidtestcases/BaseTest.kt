package com.shohiebsense.androidtestcases

import androidx.test.espresso.DataInteraction
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.Matchers
import org.hamcrest.Matchers.*


/**
 * Created by Shohiebsense on 10/12/2018
 */

fun test(func : BaseTest.() -> Unit) = BaseTest().apply{func()}

open class BaseTest {

    fun fillEditText(resId: Int, text : String) : ViewInteraction =
            onView(withId(resId)).perform(
                ViewActions.typeText(text),
                ViewActions.closeSoftKeyboard()
            )


    fun clickButton(resId : Int) : ViewInteraction =
            onView((withId(resId))).perform(ViewActions.click())

    fun textView(resId: Int) : ViewInteraction = onView(withId(resId))

    fun matchText(viewInteraction: ViewInteraction, text: String) : ViewInteraction =
            viewInteraction.check(ViewAssertions.matches(ViewMatchers.withText(text)))

    fun matchText(resId : Int, text : String) : ViewInteraction = matchText(textView(resId), text)

    fun checkLastItemOnList(text : String) : ViewInteraction =
            onView(withText(text)).check(doesNotExist())

    fun checkScroll(idStr : String, strToMatch: String) : ViewInteraction =
            checkOnRow(idStr, strToMatch).check(matches(isCompletelyDisplayed()))

    fun clickOnRow(idStr: String, strToMatch: String, resId: Int) : ViewInteraction =
            checkOnRow(idStr, strToMatch).onChildView(withId(resId)).perform(click())

    fun checkIsButtonChecked(idStr : String){

    }


    fun checkOnRow(idStr : String, strToMatch : String) : DataInteraction =
            onData(hasEntry(equalTo(idStr), `is`(strToMatch)))

    fun clickListItem(listRes : Int, position : Int){
        onData(anything())
            .inAdapterView(allOf(withId(listRes)))
            .atPosition(position).perform(ViewActions.click())
    }

    fun sleep() = apply {
        Thread.sleep(5000)
    }

    fun sleep(seconds : Long) = apply {
        Thread.sleep(seconds*1000)
    }




}