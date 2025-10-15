package com.anihpatrickugo.bankpick.ui.screens.authentication.onboarding

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.anihpatrickugo.bankpick.R
import com.anihpatrickugo.bankpick.ui.components.common.CommonUI
import com.anihpatrickugo.bankpick.ui.navigation.NavRoutes
import com.anihpatrickugo.bankpick.ui.theme.Grey40
import com.anihpatrickugo.bankpick.ui.theme.Grey80
import kotlinx.coroutines.launch

data class OnboardingPage(
    val image: Int,
    val title: String,
    val description: String
)

@Composable
fun OnboardingScreen(navController: NavController) {
    val pages = listOf(
        OnboardingPage(
            image = R.drawable.onboarding1,
            title = "Fastest Payment in the world",
            description = "Integrate multiple payment methods to help you up the process quickly."
        ),
        OnboardingPage(
            image = R.drawable.onboarding2,
            title = "The most Secure Platform for Customer",
            description = "Built-in Fingerprint, face recognition and more, keeping you completely safe."
        ),
        OnboardingPage(
            image = R.drawable.onboarding3,
            title = "Paying for Everything is Easy and Convenient",
            description = "Built-in Fingerprint, face recognition and more, keeping you completely safe."
        )
    )

    val pagerState = rememberPagerState(initialPage = 0) { pages.size }
    val coroutineScope = rememberCoroutineScope()


    CommonUI.Containner {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            HorizontalPager(
                state = pagerState,
                modifier = Modifier.weight(1f)
            ) { page ->
                OnboardingPageContent(pages[page])
            }

            // Dots indicator
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(16.dp)
            ) {
                repeat(pages.size) { index ->
                    val color =
                        if (pagerState.currentPage == index) MaterialTheme.colorScheme.primary
                        else Grey40

                    val animatedWidth by animateDpAsState(
                        targetValue = if (pagerState.currentPage == index) 19.dp else 6.dp,
                        animationSpec = tween(300),
                        label = "dotWidth"
                    )

                    Box(
                        modifier = Modifier
                            .padding(4.dp)
                            .height(6.dp)
                            .width(animatedWidth)
                            .clip(CircleShape)
                            .background(color)
                    )
                }
            }

            // Button
            CommonUI.Button(
                text = if (pagerState.currentPage == pages.size - 1)
                    "Get Started" else "Next",

                onClick = {
                    if (pagerState.currentPage == pages.size - 1) {
                        navController.navigate(NavRoutes.Login.route) {
                            popUpTo(NavRoutes.Onboarding.route) { inclusive = true }
                        }
                    } else {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    }
                },
            )
        }
    }
}

@Composable
fun OnboardingPageContent(page: OnboardingPage) {
    var isVisible by remember { mutableStateOf(false) }

    // Trigger animation when this composable enters
    LaunchedEffect(Unit) {
        isVisible = true
    }

    // Animate fade and slide
    val alpha by animateFloatAsState(
        targetValue = if (isVisible) 1f else 0f,
        animationSpec = tween(durationMillis = 700),
        label = "fade"
    )

    val offsetY by animateDpAsState(
        targetValue = if (isVisible) 0.dp else 40.dp,
        animationSpec = tween(durationMillis = 700),
        label = "slide"
    )

    val scale by animateFloatAsState(
        targetValue = if (isVisible) 1f else 0.8f,
        animationSpec = tween(durationMillis = 800),
        label = "scale"
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .alpha(alpha)
            .offset(y = offsetY)
            .scale(scale)
    ) {
        Image(
            painter = painterResource(id = page.image),
            contentDescription = page.title,
            modifier = Modifier
                .size(300.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = page.title,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            modifier = Modifier.padding(horizontal = 18.dp),
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = page.description,
            fontSize = 14.sp,
            color = Grey80,
            modifier = Modifier.padding(horizontal = 18.dp),
            textAlign = TextAlign.Center
        )
    }
}
