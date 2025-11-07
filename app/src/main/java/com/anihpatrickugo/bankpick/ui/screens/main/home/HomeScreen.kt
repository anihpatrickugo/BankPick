package com.anihpatrickugo.bankpick.ui.screens.main.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDownward
import androidx.compose.material.icons.outlined.ArrowUpward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.anihpatrickugo.bankpick.R
import com.anihpatrickugo.bankpick.ui.components.common.CommonUI
import com.anihpatrickugo.bankpick.ui.components.main.DebitCard
import com.anihpatrickugo.bankpick.ui.navigation.NavRoutes
import com.anihpatrickugo.bankpick.ui.theme.Blue
import com.anihpatrickugo.bankpick.ui.theme.Grey80



@Composable
fun HomeScreen(navController: NavController) {
    CommonUI.Containner {
        Box(modifier =  Modifier.fillMaxSize()){
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                item{
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = Alignment.Top
                    ) {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data("https://avatars.githubusercontent.com/u/89598494?v=4")
                                .crossfade(true)
                                .build(),
                            contentDescription = "Profile picture",
                            placeholder = painterResource(R.drawable.ic_person),
                            error = painterResource(R.drawable.ic_person),
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )

                        Column (
                            modifier = Modifier.weight(1f),
                        ){

                            Text(
                                text = "Welcome back",
                                fontSize = 12.sp,
                                color = Grey80
                            )

                            Text(
                                text = "Tanya Myroniuk",
                                fontSize = 18.sp
                            )
                        }
                        IconButton(
                            modifier = Modifier
                                .size(42.dp)
                                .background(MaterialTheme.colorScheme.background, CircleShape),
                            onClick = {
                                navController.navigate(NavRoutes.Search.route)
                            }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_search), // Use your back icon
                                contentDescription = "search",
                                tint = MaterialTheme.colorScheme.onSurface
                            )
                        }

                    }
                }

                // card
                item{
                    DebitCard()
                }


                //call to action
                item{
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        //sent
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            IconButton(
                                modifier = Modifier
                                    .size(54.dp)
                                    .background(
                                        MaterialTheme.colorScheme.background,
                                        CircleShape
                                    ),
                                onClick = {
                                    navController.navigate(NavRoutes.SendMoney.route)
                                }

                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.ArrowUpward, // Use your back icon
                                    contentDescription = "send",
                                    tint = MaterialTheme.colorScheme.onSurface
                                )
                            }
                            Text(
                                text = "Send",
                                fontSize = 11.sp,

                            )
                        }

                        //receive
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            IconButton(
                                modifier = Modifier
                                    .size(54.dp)
                                    .background(
                                        MaterialTheme.colorScheme.background,
                                        CircleShape
                                    ),
                                onClick = {
                                    navController.navigate(NavRoutes.ReceiveMoney.route)
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.ArrowDownward, // Use your back icon
                                    contentDescription = "receive",
                                    tint = MaterialTheme.colorScheme.onSurface
                                )
                            }
                            Text(
                                text = "Receive",
                                fontSize = 11.sp
                            )
                        }

                        //loan
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            IconButton(
                                modifier = Modifier
                                    .size(54.dp)
                                    .background(
                                        MaterialTheme.colorScheme.background,
                                        CircleShape
                                    ),
                                onClick = {}
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_dollar_circle),
                                    contentDescription = "loan",
                                    tint = MaterialTheme.colorScheme.onSurface
                                )
                            }
                            Text(
                                text = "Loan",
                                fontSize = 11.sp
                            )
                        }

                        //topup
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            IconButton(
                                modifier = Modifier
                                    .size(54.dp)
                                    .background(
                                        MaterialTheme.colorScheme.background,
                                        CircleShape
                                    ),
                                onClick = {}
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_upload),
                                    contentDescription = "topup",
                                    tint = MaterialTheme.colorScheme.onSurface
                                )
                            }
                            Text(
                                text = "Loan",
                                fontSize = 11.sp
                            )
                        }
                    }
                }


                item{

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(text = "Transaction", fontSize = 18.sp)
                        Text(text = "see all", fontSize=14.sp, color = Blue, modifier = Modifier.clickable {
                            navController.navigate(NavRoutes.TrasactionHistory.route)
                        })
                    }

                }



                items(10){item ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(42.dp)
                                .background(
                                    MaterialTheme.colorScheme.background,
                                    CircleShape
                                )
                                .clickable { },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_apple),
                                contentDescription = "topup",
                                tint = MaterialTheme.colorScheme.onSurface
                            )
                        }


                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 16.dp)
                        ){
                            Text(
                                text = "Apple Store",
                                modifier = Modifier.padding(vertical = 0.dp),
                                fontSize = 16.sp
                            )
                            Text(
                                text = "Entertainment",
                                modifier = Modifier.padding(vertical = 0.dp),
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.surfaceVariant

                            )
                        }

                        Text(
                            text = "- \$5,99",
                            modifier = Modifier.padding(vertical = 4.dp),
                            fontSize = 16.sp

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


