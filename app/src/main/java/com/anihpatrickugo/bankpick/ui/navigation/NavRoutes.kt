package com.anihpatrickugo.bankpick.ui.navigation

sealed class NavRoutes(val route: String) {
    object Splash : NavRoutes("splash")
    object Onboarding : NavRoutes("onboarding")
    object Login : NavRoutes("login")
}

