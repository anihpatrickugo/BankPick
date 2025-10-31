package com.anihpatrickugo.bankpick.ui.screens.authentication.login


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.anihpatrickugo.bankpick.R

import com.anihpatrickugo.bankpick.ui.components.common.CommonUI
import com.anihpatrickugo.bankpick.ui.navigation.NavRoutes
import com.anihpatrickugo.bankpick.ui.theme.Grey80


@Composable
fun LoginScreen(navController: NavController) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


    CommonUI.Containner {
        Column(
            modifier = Modifier.fillMaxSize(),

        ) {
          CommonUI.Header(onClickBack = { navController.navigateUp()})

            Text(
                text = "Sign In",
                fontWeight = FontWeight.SemiBold,
                fontSize = 32.sp
                )
            Spacer(modifier = Modifier.height(20.dp))

            // Text inputs
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Email address


                CommonUI.TextField(
                    value = email,
                    onValueChange = { email = it },
                    label = "Email Address",
                    placeholder = "youemail@domain.com",
                    singleLine = true,
                    leadingIcon = R.drawable.ic_email
                )

                CommonUI.PasswordField(
                    value = password,
                    onValueChange = { password = it },
                    label = "Password",
                    placeholder = "eg 123ABC@",
                    singleLine = true,
                    leadingIcon = R.drawable.ic_lock,
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                CommonUI.Button(text = "Sign In", onClick = {
                    navController.navigate(NavRoutes.Main.route) {
                        popUpTo(NavRoutes.Login.route) { inclusive = true }
                    }
                })

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = buildAnnotatedString {
                        // This part of the text will have the default style
                        append("I'm a new user ")

                        // This part of the text will be highlighted in PrimaryColor
                        withStyle(style = SpanStyle(
                            color = MaterialTheme.colorScheme.primary, // Use your custom primary color
                        )
                        ) {
                            append("Sign Up")
                        }
                    },
                    color = Grey80,
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    modifier = Modifier.clickable {
                        // Navigate to the signup screen when the text is clicked
                        navController.navigate(NavRoutes.Signup.route)
                    }
                )
            }
        }
    }
}

