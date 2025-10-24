package com.anihpatrickugo.bankpick.ui.screens.main

import android.annotation.SuppressLint
import com.anihpatrickugo.bankpick.ui.navigation.bottomtabs.BottomBar
import com.anihpatrickugo.bankpick.ui.navigation.bottomtabs.BottomNavGraph

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomTabScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) { innerPadding ->
        BottomNavGraph(navController = navController, )
    }
}
