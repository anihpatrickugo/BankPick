package com.anihpatrickugo.bankpick.ui.navigation.bottomtabs


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.anihpatrickugo.bankpick.ui.navigation.BottomNavItem
import com.anihpatrickugo.bankpick.ui.screens.main.cards.MyCardsScreen
import com.anihpatrickugo.bankpick.ui.screens.main.home.HomeScreen
import com.anihpatrickugo.bankpick.ui.screens.main.settings.SettingsScreen
import com.anihpatrickugo.bankpick.ui.screens.main.statistics.StatisticsScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.route
    ) {
        composable(BottomNavItem.Home.route) { HomeScreen() }
        composable(BottomNavItem.MyCards.route) { MyCardsScreen() }
        composable(BottomNavItem.Statistics.route) { StatisticsScreen() }
        composable(BottomNavItem.Settings.route) { SettingsScreen()}
    }
}
