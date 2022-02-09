package com.quotes.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.quotes.data.model.Quotes
import com.quotes.ui.components.QuotesBox
import com.quotes.ui.favourites.FavouriteQuotesScreen
import com.quotes.ui.quotes.QuoteListScreen
import com.quotes.ui.theme.QuotesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuotesTheme {
                ProvideWindowInsets {
                    Surface(color = MaterialTheme.colors.background) {
                        MainLayout(viewModel)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainLayout(viewModel: MainViewModel) {
    val navController = rememberAnimatedNavController()
    QuotesTheme {
        Scaffold(bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                bottomNavigationItems.forEach { item ->
                    BottomNavigationItem(selected = currentRoute == item.route, onClick = {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.id)
                            launchSingleTop = true
                        }
                    }, icon = {
                        Icon(imageVector = item.icon, contentDescription = item.title)
                    })
                }
            }
        }) { paddingValues ->
            AnimatedNavHost(navController, startDestination = Screen.QuotesList.title) {
                composable(
                    route = Screen.QuotesList.title,
                    exitTransition = {
                        slideOutHorizontally() +
                                fadeOut(animationSpec = tween(1000))
                    },
                    popEnterTransition = {
                        slideInHorizontally()
                    }
                ) {
                    QuoteListScreen(
                        paddingValues = paddingValues,
                        quoteSelected = {
                            navController.navigate(Screen.QuoteDetails.title + "/$it")
                        },
                        viewModel = viewModel
                    )
                }
                composable(
                    route = Screen.QuoteDetails.title,
                    exitTransition = {
                        slideOutHorizontally() +
                                fadeOut(animationSpec = tween(1000))
                    },
                    popExitTransition = {
                        slideOutHorizontally()
                    }
                ) {
                    QuoteListScreen(
                        paddingValues = paddingValues,
                        quoteSelected = {
                            navController.navigate(Screen.QuoteDetails.title + "/$it")
                        },
                        viewModel = viewModel
                    )
                }
                composable(Screen.FavouriteQuotes.title) {
                    FavouriteQuotesScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    QuotesTheme {
        QuotesBox(
            quotes = Quotes(
                author = "Test Auth",
                en = "a quotes to test",
                id = "1"
            ),
            onClick = {  }
        )
    }
}
