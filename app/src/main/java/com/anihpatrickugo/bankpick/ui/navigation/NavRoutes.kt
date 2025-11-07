package com.anihpatrickugo.bankpick.ui.navigation

sealed class NavRoutes(val route: String) {
    object Splash : NavRoutes("splash")
    object Onboarding : NavRoutes("onboarding")
    object Login : NavRoutes("login")
    object Signup : NavRoutes("signup")
    object Main : NavRoutes("main")
    object Profile : NavRoutes("profile")
    object EditProfile : NavRoutes("edit-profile")
    object AllCards : NavRoutes("all-cards")
    object NewCard : NavRoutes("new-card")
    object TrasactionHistory : NavRoutes("transc-hist")
    object Search : NavRoutes("search")
    object SendMoney : NavRoutes("send-money")
    object ReceiveMoney : NavRoutes("receive-money")
    object ChangePassword : NavRoutes("change-password")
    object PrivacyPolicy : NavRoutes("privacy-policy")
}

