
package com.anihpatrickugo.bankpick.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.anihpatrickugo.bankpick.ui.screens.authentication.splash.SplashScreen
import com.anihpatrickugo.bankpick.ui.screens.authentication.onboarding.OnboardingScreen
import com.anihpatrickugo.bankpick.ui.screens.authentication.login.LoginScreen
import com.anihpatrickugo.bankpick.ui.screens.authentication.signup.SignupScreen
import com.anihpatrickugo.bankpick.ui.screens.main.BottomTabScreen
import com.anihpatrickugo.bankpick.ui.screens.main.profile.ProfileScreen


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

        // Signuo Screen
        composable(NavRoutes.Signup.route) {
            SignupScreen(navController = navController)
        }

        //bottom tabs
        composable(NavRoutes.Main.route) {
            BottomTabScreen(navController = navController)
        }

        // profile
        composable(NavRoutes.Profile.route) {
            ProfileScreen()
        }


    }
}
