package com.anihpatrickugo.bankpick.ui.screens.authentication.login


import androidx.compose.foundation.layout.*
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.anihpatrickugo.bankpick.R

import com.anihpatrickugo.bankpick.ui.components.common.CommonUI
import com.anihpatrickugo.bankpick.ui.components.common.UIPasswordTextField
import com.anihpatrickugo.bankpick.ui.components.common.UITextField


@Composable
fun LoginScreen(navController: NavController) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


    CommonUI.Containner {
        Column(
            modifier = Modifier.fillMaxSize(),

        ) {
          CommonUI.Header(onClickBack = { navController.navigateUp()})
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Sign In",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 32.sp
                )
            Spacer(modifier = Modifier.height(20.dp))

            // Text inputs
            Column(
                modifier = Modifier.fillMaxWidth(),
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
                
                CommonUI.Button(text = "Sign In", onClick = { /*TODO*/ })
            }
        }
    }
}

