package com.quotes

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.quotes.ui.main.MainActivity
import com.quotes.ui.main.MainLayout
import com.quotes.ui.theme.QuotesTheme
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun bottom_tabs_are_displayed() {
        composeTestRule.setContent {
            QuotesTheme {
                MainLayout(darkTheme = false, toggleTheme = {})
            }
        }
        composeTestRule.onNodeWithText("Quote", useUnmergedTree = true).assertIsDisplayed()
        composeTestRule.onNodeWithText("Favourites", useUnmergedTree = true)
            .assertIsDisplayed()
    }

    @Test
    fun app_loads_with_quotes_by_default() {
        composeTestRule.setContent {
            QuotesTheme {
                MainLayout(darkTheme = false, toggleTheme = {})
            }
        }
        composeTestRule.onNodeWithText("Quote", useUnmergedTree = true).assertIsDisplayed()
    }

    @Test
    fun app_navigates_to_favourites_tab_when_selected() {
        composeTestRule.setContent {
            QuotesTheme {
                MainLayout(darkTheme = false, toggleTheme = {})
            }
        }
        composeTestRule.onNodeWithText("Favourites", useUnmergedTree = true)
            .assertIsDisplayed()
            .performClick()
        composeTestRule.onNodeWithTag("Fav", useUnmergedTree = true).assertIsDisplayed()
    }
}
