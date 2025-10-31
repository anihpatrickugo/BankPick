package com.anihpatrickugo.bankpick.ui.screens.main

import android.annotation.SuppressLint
import com.anihpatrickugo.bankpick.ui.navigation.main.BottomBar
import com.anihpatrickugo.bankpick.ui.navigation.main.MainNavGraph
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomTabScreen(navController: NavController) {
    val bottomNavController = rememberNavController()

    Scaffold(
        bottomBar = { BottomBar(bottomNavController = bottomNavController) }
    ) { innerPadding ->
        MainNavGraph(
            navController = navController,
            bottomNavController = bottomNavController
            )
    }
}
