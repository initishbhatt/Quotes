package com.quotes.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.quotes.ui.favourites.FavouriteQuotesScreen
import com.quotes.ui.favourites.FavouritesViewModel
import com.quotes.ui.quotes.QuoteScreen
import com.quotes.ui.quotes.QuotesViewModel
import com.quotes.ui.theme.QuotesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuotesTheme {
                ProvideWindowInsets {
                    Surface(color = MaterialTheme.colors.background) {
                        MainLayout()
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainLayout() {
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
                    }, label = { Text(text = item.title) })
                }
            }
        }) { paddingValues ->
            AnimatedNavHost(navController, startDestination = Screen.Quote.title) {
                composable(
                    route = Screen.Quote.title,
                    exitTransition = {
                        slideOutHorizontally() +
                            fadeOut(animationSpec = tween(1000))
                    },
                    popEnterTransition = {
                        slideInHorizontally()
                    }
                ) {
                    val viewModel = hiltViewModel<QuotesViewModel>()
                    QuoteScreen(viewModel = viewModel)
                }
                composable(Screen.FavouriteQuotes.title) {
                    val viewModel = hiltViewModel<FavouritesViewModel>()
                    FavouriteQuotesScreen(viewModel = viewModel, paddingValues = paddingValues)
                }
            }
        }
    }
}
