
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
import com.anihpatrickugo.bankpick.ui.screens.main.cards.AllCardsScreen
import com.anihpatrickugo.bankpick.ui.screens.main.cards.NewCardScreen
import com.anihpatrickugo.bankpick.ui.screens.main.password.ChangePasswordScreen
import com.anihpatrickugo.bankpick.ui.screens.main.privacy.PrivacyPolicyScreen
import com.anihpatrickugo.bankpick.ui.screens.main.profile.EditProfileScreen
import com.anihpatrickugo.bankpick.ui.screens.main.profile.ProfileScreen
import com.anihpatrickugo.bankpick.ui.screens.main.receive.ReceiveMoneyScreen
import com.anihpatrickugo.bankpick.ui.screens.main.search.SearchScreen
import com.anihpatrickugo.bankpick.ui.screens.main.send.SendMoneyScreen
import com.anihpatrickugo.bankpick.ui.screens.main.transaction.TransactionHistoryScreen


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
            ProfileScreen(navController = navController)
        }

        // edit-profile
        composable(NavRoutes.EditProfile.route) {
            EditProfileScreen()
        }

        //all cards
        composable(NavRoutes.AllCards.route) {
            AllCardsScreen(navController = navController)
        }

        //new card
        composable(NavRoutes.NewCard.route) {
            NewCardScreen(navController = navController)
        }

        //transaction history
        composable(NavRoutes.TrasactionHistory.route) {
          TransactionHistoryScreen()
        }

        //search
        composable(NavRoutes.Search.route) {
            SearchScreen()
        }

        //send money
        composable(NavRoutes.SendMoney.route) {
            SendMoneyScreen(navController = navController)
        }

        // send money
        composable(NavRoutes.ReceiveMoney.route) {
                ReceiveMoneyScreen(navController = navController)
        }

        // change password
        composable(NavRoutes.ChangePassword.route) {
            ChangePasswordScreen(navController = navController)
        }

        // privacy policy
        composable(NavRoutes.PrivacyPolicy.route) {
            PrivacyPolicyScreen(navController = navController)
        }


    }
}
