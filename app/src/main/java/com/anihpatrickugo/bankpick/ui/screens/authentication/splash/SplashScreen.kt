package com.anihpatrickugo.bankpick.ui.screens.authentication.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anihpatrickugo.bankpick.R
import com.anihpatrickugo.bankpick.ui.components.common.CommonUI
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onSplashFinished: () -> Unit) {
    var scale by remember { mutableStateOf(0f) }
    var textVisible by remember { mutableStateOf(false) }

    // Logo animation
    val animScale = animateFloatAsState(
        targetValue = if (scale == 0f) 1f else 1.2f,
        animationSpec = tween(
            durationMillis = 1000,
            easing = { OvershootInterpolator(4f).getInterpolation(it) }
        ),
        label = "Splash Scale Animation"
    )

    // Text fade-in animation
    val textAlpha by animateFloatAsState(
        targetValue = if (textVisible) 1f else 0f,
        animationSpec = tween(durationMillis = 1000),
        label = "Text Fade Animation"
    )

    val systemUiController = rememberSystemUiController()

    // Hide system bars during splash
    SideEffect {
        systemUiController.isStatusBarVisible = false
        systemUiController.isNavigationBarVisible = false
    }

    // Run animations sequentially
    LaunchedEffect(Unit) {
        scale = 1f
        delay(800) // wait a bit, then show text
        textVisible = true
        delay(1500)

        // Restore bars before exit
        systemUiController.isStatusBarVisible = true
        systemUiController.isNavigationBarVisible = true
        delay(300)
        onSplashFinished()
    }

    // Center content vertically
    CommonUI.Containner {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // Logo
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(150.dp)
                        .padding(bottom = 0.dp)
                        .scale(animScale.value)
                )

                Spacer(modifier = Modifier.size(0.dp))

                // Animated Text
                Text(
                    text = "BankPick",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = 0.dp)
                        .alpha(textAlpha)
                )
            }
        }
    }

}
