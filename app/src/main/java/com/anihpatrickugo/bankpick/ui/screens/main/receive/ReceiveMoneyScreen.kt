package com.anihpatrickugo.bankpick.ui.screens.main.receive

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.anihpatrickugo.bankpick.R
import com.anihpatrickugo.bankpick.ui.components.common.CommonUI
import com.anihpatrickugo.bankpick.ui.theme.Grey20
import com.anihpatrickugo.bankpick.ui.theme.Grey80
import com.anihpatrickugo.bankpick.ui.theme.Red20
import java.util.Calendar


@Composable
fun   ReceiveMoneyScreen (navController: NavController) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    var selectedDate by remember { mutableStateOf(Calendar.getInstance()) }

    var amount by remember { mutableStateOf("") }

    CommonUI.Containner {
        Box(modifier =  Modifier.fillMaxSize()){
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                item{
                    CommonUI.Header(title = "Receive Money", onClickBack = { /*TODO*/ })
                }


                // form
                item{
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {


                        // full name
                        CommonUI.TextField(
                            value = name,
                            onValueChange = { name = it },
                            label = "Payer Name",
                            placeholder = "Ugochukwu Patrick",
                            singleLine = true,
                            leadingIcon = R.drawable.ic_person_circle
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


                        // description
                        CommonUI.TextField(
                            value = description,
                            onValueChange = { description = it },
                            label = "Description",
                            singleLine = true,
                            leadingIcon = R.drawable.ic_person_circle
                        )

                        //date
                        CommonUI.DatePicker(
                            label = "Monthly Due By",
                            selectedDate = selectedDate,
                            onDateSelected = { selectedDate = it }
                        )

                    }
                }



                //amount containner
                item{

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = MaterialTheme.colorScheme.inverseOnSurface, // Blue color
                                shape = RoundedCornerShape(25.dp) // 👈 Rounded corners
                            )
                            .padding(16.dp)
                    ){


                        Row (
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ){
                            Text(
                                text = "Enter Your Amount",
                                fontSize = 11.sp,
                                color = Grey80
                            )
                            Text(
                                text = "Change Currency?",
                                fontSize = 11.sp,
                                color = Red20
                            )

                        }

                        Row (
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){

                            Text(
                                text = "USD",
                                fontSize = 24.sp,
                                color = Grey20,
                                fontWeight = FontWeight.SemiBold
                            )

                            TextField(
                                value = amount,
                                onValueChange = { amount = it },
                                textStyle = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.SemiBold),
                                colors = TextFieldDefaults.colors(
                                    focusedIndicatorColor = Color.Transparent,   // bottom line color (active)
                                    unfocusedIndicatorColor =Color.Transparent, // bottom line color (inactive)
                                    disabledIndicatorColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f),
                                    focusedContainerColor = Color.Transparent,
                                    unfocusedContainerColor = Color.Transparent,

                                    ),
                                singleLine = true,
                                modifier = Modifier.weight(1f),
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Number
                                ),
                                )

                        }

                    }

                }



                // buttom
                item{
                    Spacer(modifier = Modifier.height(50.dp))

                    CommonUI.Button(text = "Receive Money", onClick = {
//                        navController.navigate(NavRoutes.NewCard.route)
                    })

                    Spacer(modifier = Modifier.height(8.dp))

                }

            }

        }

    }

}






