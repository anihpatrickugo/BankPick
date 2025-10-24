package com.anihpatrickugo.bankpick.ui.screens.authentication.signup

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.anihpatrickugo.bankpick.R

import com.anihpatrickugo.bankpick.ui.components.common.CommonUI
import com.anihpatrickugo.bankpick.ui.navigation.NavRoutes
import com.anihpatrickugo.bankpick.ui.theme.Grey80


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SignupScreen(navController: NavController) {

    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


    CommonUI.Containner {


        LazyColumn(
            modifier = Modifier.fillMaxSize(),

        ){
            stickyHeader{
            CommonUI.Header(onClickBack = { navController.navigateUp()})
            }

           item {
               Text(
                   text = "Sign Up",
                   fontWeight = FontWeight.SemiBold,
                   fontSize = 32.sp
               )
               Spacer(modifier = Modifier.height(20.dp))

               // Text inputs
               Column(
                   modifier = Modifier.fillMaxWidth(),
                   horizontalAlignment = Alignment.CenterHorizontally
               ) {


                   // full name
                   CommonUI.TextField(
                       value = name,
                       onValueChange = { name = it },
                       label = "Full Name",
                       placeholder = "eg Ugochukwu Patrick",
                       singleLine = true,
                       leadingIcon = R.drawable.ic_person
                   )

                   // phone number
                   CommonUI.TextField(
                       value = phone,
                       onValueChange = { phone = it },
                       label = "Phone Number",
                       placeholder = "+234",
                       singleLine = true,
                       leadingIcon = R.drawable.ic_phone,
                       keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                   )


                   // Email address

                   CommonUI.TextField(
                       value = email,
                       onValueChange = { email = it },
                       label = "Email Address",
                       placeholder = "youemail@domain.com",
                       singleLine = true,
                       leadingIcon = R.drawable.ic_email,
                       keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
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
                           popUpTo(NavRoutes.Signup.route) { inclusive = true }
                       }
                   })

                   Spacer(modifier = Modifier.height(16.dp))

                   Text(
                       text = buildAnnotatedString {
                           // This part of the text will have the default style
                           append("Already have an account? ")

                           // This part of the text will be highlighted in PrimaryColor
                           withStyle(style = SpanStyle(
                               color = MaterialTheme.colorScheme.primary, // Use your custom primary color
                           )
                           ) {
                               append("Sign In")
                           }
                       },
                       color = Grey80,
                       textAlign = TextAlign.Center,
                       fontSize = 14.sp,
                       modifier = Modifier.clickable {
                           // Navigate to the login screen when the text is clicked
                           navController.navigate(NavRoutes.Login.route)
                       }
                   )
               }
           }
        }

    }
}

