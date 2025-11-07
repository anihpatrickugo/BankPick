package com.anihpatrickugo.bankpick.ui.screens.main.privacy

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.anihpatrickugo.bankpick.R
import com.anihpatrickugo.bankpick.ui.components.common.CommonUI
import com.anihpatrickugo.bankpick.ui.navigation.NavRoutes
import com.anihpatrickugo.bankpick.ui.theme.Grey100


@Composable
fun  PrivacyPolicyScreen  (navController: NavController) {



    CommonUI.Containner {
        Column(
            modifier = Modifier.fillMaxSize(),

            ) {
            CommonUI.Header(title ="Privacy Policy", onClickBack = { navController.navigateUp()})


            // Text inputs
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
               item {
                   Text(
                       text = "L15.1 Thank you for visiting our Application Doctor 24×7 and enrolling as a member.",
                       fontSize = 14.sp
                   )

                   Text(
                       text = "\n" +
                               "15.2 Your privacy is important to us. To better protect your privacy, we are providing this notice explaining our policy with regards to the information you share with us. This privacy policy related to the information we collect, online from Application, received through the email, by fax or telephone, or in person or in any other way and retain and use for the purpose of providing you services. If you do not agree to the terms in this Policy, we kindly ask you not to use these portals and/or sign the contract document.",
                       fontSize = 14.sp
                   )
                   Text(
                       text = "\n" +
                               "15.3 In order to use the services of this Application, You are required to register yourself by verifying the authorised device. This Privacy Policy applies to your information that we collect and receive on and through Doctor 24×7; it does not apply to practices of businesses that we do not own or control or people we do not employ.",
                       fontSize = 14.sp
                   )

                   Text(
                       text = "15.4 By using this Application, you agree to the terms of this Privacy Policy.",
                       fontSize = 14.sp
                   )

               }
            }
        }
    }
}

