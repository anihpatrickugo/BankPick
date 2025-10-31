package com.anihpatrickugo.bankpick.ui.navigation.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.anihpatrickugo.bankpick.ui.navigation.BottomTabRoutes
import com.anihpatrickugo.bankpick.ui.screens.main.cards.MyCardsScreen
import com.anihpatrickugo.bankpick.ui.screens.main.home.HomeScreen
import com.anihpatrickugo.bankpick.ui.screens.main.settings.SettingsScreen
import com.anihpatrickugo.bankpick.ui.screens.main.statistics.StatisticsScreen

@Composable
fun MainNavGraph(
    navController: NavController,
    bottomNavController: NavHostController,
    ) {
    NavHost(
        navController = bottomNavController,
        startDestination = BottomTabRoutes.Home.route
    ) {
        composable(BottomTabRoutes.Home.route) { HomeScreen() }
        composable(BottomTabRoutes.MyCards.route) { MyCardsScreen() }
        composable(BottomTabRoutes.Statistics.route) { StatisticsScreen() }
        composable(BottomTabRoutes.Settings.route) { SettingsScreen(
            navController = navController
        )}

    }
}
