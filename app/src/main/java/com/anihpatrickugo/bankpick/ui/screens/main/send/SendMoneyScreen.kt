package com.anihpatrickugo.bankpick.ui.screens.main.send

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.anihpatrickugo.bankpick.R
import com.anihpatrickugo.bankpick.ui.components.common.CommonUI
import com.anihpatrickugo.bankpick.ui.components.main.DebitCard
import com.anihpatrickugo.bankpick.ui.theme.Grey20
import com.anihpatrickugo.bankpick.ui.theme.Grey80
import com.anihpatrickugo.bankpick.ui.theme.Red20


@Composable
fun  SendMoneyScreen(navController: NavController) {

    var amount by remember { mutableStateOf("") }

    CommonUI.Containner {
        Box(modifier =  Modifier.fillMaxSize()){
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                item{
                    CommonUI.Header(title = "Send Money", onClickBack = { /*TODO*/ })
                }


                // card
                item {
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        items(10) {
                            DebitCard()
                        }
                    }
                }

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

                        Text(
                            text = "Send to",
                            fontSize = 12.sp
                        )

                        Row (
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){

                            //add button
                            Column (
                                horizontalAlignment = Alignment.CenterHorizontally
                            ){
                                Box(
                                    modifier = Modifier
                                        .size(47.dp)
                                        .background(Color.Transparent, CircleShape)
                                        .border(
                                            width = 1.dp,
                                            color = MaterialTheme.colorScheme.primary,
                                            shape = CircleShape
                                        )
                                        .clickable {

                                        }
                                    ,
                                    contentAlignment = Alignment.Center

                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.Add,
                                        contentDescription = "add icon",
                                        modifier = Modifier.size(22.dp),
                                        tint = MaterialTheme.colorScheme.primary
                                    )
                                }

                                Text(
                                    text = "Add",
                                    fontSize = 10.sp,
                                )
                            }


                            // circular image list
                            LazyRow(
                                modifier = Modifier
                                    .weight(1f),
                                horizontalArrangement = Arrangement.spacedBy(16.dp),
                            ) {
                                items(10) {
                                    Column (
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ){
                                        AsyncImage(
                                            model = ImageRequest.Builder(LocalContext.current)
                                                .data("https://avatars.githubusercontent.com/u/89598494?v=4")
                                                .crossfade(true)
                                                .build(),
                                            contentDescription = "Profile picture",
                                            placeholder = painterResource(R.drawable.ic_person),
                                            error = painterResource(R.drawable.ic_person),
                                            modifier = Modifier
                                                .size(47.dp)
                                                .clip(CircleShape),
                                            contentScale = ContentScale.Crop
                                        )
                                        Text(
                                            text = "Alexa",
                                            fontSize = 10.sp,
                                        )
                                    }
                                }
                            }

                        }

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

                    CommonUI.Button(text = "Send Money", onClick = {
//                        navController.navigate(NavRoutes.NewCard.route)
                    })

                    Spacer(modifier = Modifier.height(8.dp))

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
    Image(
        painter = painterResource(id = R.drawable.background_blur_2),
        contentDescription = "Blur",
        modifier = Modifier.offset(x=-20.dp, y=115.dp)
    )
}






