package com.anihpatrickugo.bankpick.ui.screens.main.password


import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.anihpatrickugo.bankpick.R
import com.anihpatrickugo.bankpick.ui.components.common.CommonUI
import com.anihpatrickugo.bankpick.ui.navigation.NavRoutes



@Composable
fun ChangePasswordScreen (navController: NavController) {

    var password by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    var confirmNewPassword by remember { mutableStateOf("") }


    CommonUI.Containner {
        Column(
            modifier = Modifier.fillMaxSize(),

            ) {
            CommonUI.Header(title ="Change Password", onClickBack = { navController.navigateUp()})


            // Text inputs
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                CommonUI.PasswordField(
                    value = password,
                    onValueChange = { password = it },
                    label = "Current Password",
                    singleLine = true,
                    leadingIcon = R.drawable.ic_lock,
                )

                CommonUI.PasswordField(
                    value = newPassword,
                    onValueChange = { newPassword = it },
                    label = "New Password",
                    singleLine = true,
                    leadingIcon = R.drawable.ic_lock,
                )

                CommonUI.PasswordField(
                    value = confirmNewPassword,
                    onValueChange = { confirmNewPassword = it },
                    label = "Confirm Password",
                    singleLine = true,
                    leadingIcon = R.drawable.ic_lock,
                )

                Spacer(modifier = Modifier.height(18.dp))

                CommonUI.Button(text = "Change Password", onClick = {
                    navController.navigate(NavRoutes.Main.route) {
                        popUpTo(NavRoutes.Login.route) { inclusive = true }
                    }
                })

            }
        }
    }
}

