package com.shohiebsense.androidtestcases.case1_basic

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.shohiebsense.androidtestcases.R
import com.shohiebsense.androidtestcases.test
import kotlinx.android.synthetic.main.activity_main.view.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Created by Shohiebsense on 10/12/2018
 */

@LargeTest
@RunWith(AndroidJUnit4::class)
class ChangeBehaviorTestKotlin {

    companion object {
        val STRING_TO_BE_TYPED = "Espresso"
    }

    @Before
    fun launchActivity() {
        ActivityScenario.launch(Case1BasicActivity::class.java)
    }

    @Test
    fun changeTextSameActivity() {
        test {
            sleep(10)
            fillEditText(R.id.editTextUserInput, STRING_TO_BE_TYPED)
            sleep()
            clickButton(R.id.changeTextBt)
            matchText(R.id.textToBeChanged, STRING_TO_BE_TYPED)
        }
    }

    @Test
    fun changeTextDifferentActivity(){
        test {
            fillEditText(R.id.editTextUserInput, STRING_TO_BE_TYPED)
            sleep()
            clickButton(R.id.activityChangeTextBtn)
            matchText(R.id.show_text_view, STRING_TO_BE_TYPED)
        }
    }


}