
package com.anihpatrickugo.bankpick.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.anihpatrickugo.bankpick.ui.screens.authentication.splash.SplashScreen
import com.anihpatrickugo.bankpick.ui.screens.authentication.onboarding.OnboardingScreen
import androidx.compose.material3.Text
import com.anihpatrickugo.bankpick.ui.screens.authentication.login.LoginScreen


@Composable
fun NavigationGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoutes.Splash.route
    ) {
        // 🌀 Splash Screen
        composable(NavRoutes.Splash.route) {
            SplashScreen(
                onSplashFinished = {
                    navController.navigate(NavRoutes.Onboarding.route) {
                        popUpTo(NavRoutes.Splash.route) { inclusive = true }
                    }
                }
            )
        }

        // 🎠 Onboarding Screen
        composable(NavRoutes.Onboarding.route) {
            OnboardingScreen(
                navController = navController
            )
        }

        // Login Screen
        composable(NavRoutes.Login.route) {
           LoginScreen(navController = navController)
        }
    }
}
