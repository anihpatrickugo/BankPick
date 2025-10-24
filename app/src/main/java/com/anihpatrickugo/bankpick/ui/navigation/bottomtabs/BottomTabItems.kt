package com.anihpatrickugo.bankpick.ui.navigation

import androidx.annotation.DrawableRes
import com.anihpatrickugo.bankpick.R

sealed class BottomNavItem(
    val route: String,
    val title: String,
    @DrawableRes val icon: Int
) {
    object Home : BottomNavItem("home", "Home", R.drawable.ic_home)
    object MyCards : BottomNavItem("my-cards", "My Cards", R.drawable.ic_wallet)
    object Statistics : BottomNavItem("statistics", "Statistics", R.drawable.ic_statistics)
    object Settings : BottomNavItem("settings", "Settings", R.drawable.ic_settings)
}
