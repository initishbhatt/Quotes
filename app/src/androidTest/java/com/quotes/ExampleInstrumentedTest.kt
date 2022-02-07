package com.quotes

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class ExampleInstrumentedTest {

    @get:Rule()
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun mainTextIsDisplayed() {
        composeTestRule.onNodeWithText("Hello Sample Template!").assertExists()
    }
}
