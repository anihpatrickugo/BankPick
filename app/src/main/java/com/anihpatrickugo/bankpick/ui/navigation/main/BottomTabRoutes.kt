package com.anihpatrickugo.bankpick.ui.navigation

import androidx.annotation.DrawableRes
import com.anihpatrickugo.bankpick.R

sealed class BottomTabRoutes(
    val route: String,
    val title: String,
    @DrawableRes val icon: Int
) {
    object Home : BottomTabRoutes("home", "Home", R.drawable.ic_home)
    object MyCards : BottomTabRoutes("my-cards", "My Cards", R.drawable.ic_wallet)
    object Statistics : BottomTabRoutes("statistics", "Statistics", R.drawable.ic_statistics)
    object Settings : BottomTabRoutes("settings", "Settings", R.drawable.ic_settings)

}
