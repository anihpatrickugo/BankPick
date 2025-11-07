package com.anihpatrickugo.bankpick.ui.screens.main.cards


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.anihpatrickugo.bankpick.R
import com.anihpatrickugo.bankpick.ui.components.common.CommonUI
import com.anihpatrickugo.bankpick.ui.components.main.DebitCard


@Composable
fun  NewCardScreen (navController: NavController) {

    var name by remember { mutableStateOf("") }
    var number by remember { mutableStateOf("") }

    CommonUI.Containner {
        Box(modifier =  Modifier.fillMaxSize()){
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {

                item{
                    CommonUI.Header(title = "Add New Card", onClickBack = { /*TODO*/ }, rightIcon = {
                        IconButton(
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                                .size(42.dp)
                                .background(MaterialTheme.colorScheme.surfaceVariant, CircleShape),
                            onClick = {}
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Add,
                                contentDescription = "add icon",
                                modifier = Modifier.size(22.dp),
                                tint = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    })
                }
                // card
                item{
                    DebitCard()
                }


                // Text inputs
                item{

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // card name
                        CommonUI.TextField(
                            value = name,
                            onValueChange = { name = it },
                            label = "Cardholder Name",
                            placeholder = "",
                            singleLine = true,
                            leadingIcon = R.drawable.ic_person
                        )

                        // row
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ){
                            Box(
                                modifier = Modifier.width(120.dp)
                            ){
                                CommonUI.TextField(
                                    value = number,
                                    onValueChange = { number = it },
                                    label = "Expiry Date",
                                    placeholder = "",
                                    singleLine = true,
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                                )
                            }

                            Box(
                                modifier = Modifier.width(120.dp)
                            ){
                                CommonUI.TextField(
                                    value = number,
                                    onValueChange = { number = it },
                                    label = "4-digit cvv",
                                    placeholder = "",
                                    singleLine = true,
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                                )
                            }
                        }

                        // card number
                        CommonUI.TextField(
                            value = number,
                            onValueChange = { number = it },
                            label = "Card Number",
                            placeholder = "",
                            singleLine = true,
                            leadingIcon = R.drawable.ic_credit_card_edit,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                        )

                    }


                }

            }

        }

    }
    //blur shadow
    Image(
        painter = painterResource(id = R.drawable.background_blur),
        contentDescription = "Blur",
        modifier = Modifier.offset(x=180.dp, y=115.dp)
    )
}




