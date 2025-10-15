package com.anihpatrickugo.bankpick

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.anihpatrickugo.bankpick.ui.theme.BankPickTheme
import com.anihpatrickugo.bankpick.ui.theme.ThemeViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import com.anihpatrickugo.bankpick.ui.navigation.NavigationGraph
import com.anihpatrickugo.bankpick.ui.screens.authentication.onboarding.OnboardingScreen
import com.anihpatrickugo.bankpick.ui.theme.ThemeViewModelFactory
import com.anihpatrickugo.bankpick.ui.screens.authentication.splash.SplashScreen

class MainActivity : ComponentActivity() {

    private val themeViewModel: ThemeViewModel by viewModels {
        ThemeViewModelFactory(applicationContext)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val isDarkTheme = themeViewModel.isDarkTheme.collectAsState()
            val systemUiController = rememberSystemUiController()
            val backgroundColor = MaterialTheme.colorScheme.background

            // Update status bar color whenever theme changes (works from android 10 - 14)
            SideEffect {
                systemUiController.setStatusBarColor(
                    color = backgroundColor,
                    darkIcons = !isDarkTheme.value
                )
            }

            BankPickTheme(darkTheme = isDarkTheme.value) {
                NavigationGraph()
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier, themeViewModel: ThemeViewModel = viewModel()) {
//
//
//    val isDarkTheme = themeViewModel.isDarkTheme.collectAsState()
//
//    Column (
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(12.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ){
//
//        Text(
//            text = "Hello $name!",
//            modifier = modifier
//        )
//
//        Button(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(50.dp),
//            onClick = { themeViewModel.toggleTheme() }
//        ) {
//            Text(text = if (isDarkTheme.value) "Switch to Light" else "Switch to Dark")
//        }
//    }
//
//}
