package com.anihpatrickugo.bankpick.ui.screens.main.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.anihpatrickugo.bankpick.ui.components.common.CommonUI
import com.anihpatrickugo.bankpick.ui.theme.ThemeViewModel
import com.anihpatrickugo.bankpick.ui.theme.ThemeViewModelFactory

@Composable
fun SettingsScreen() {

    val context = LocalContext.current
    val themeViewModel: ThemeViewModel = viewModel(
        factory = ThemeViewModelFactory(context)
    )

    val isDarkTheme = themeViewModel.isDarkTheme.collectAsState()


    CommonUI.Containner {
        Text("Settings Screen" )


        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){


            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                onClick = { themeViewModel.toggleTheme() }
            ) {
                Text(text = if (isDarkTheme.value) "Switch to Light" else "Switch to Dark")
            }
        }
    }

}