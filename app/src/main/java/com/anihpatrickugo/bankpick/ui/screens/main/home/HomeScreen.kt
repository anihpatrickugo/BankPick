package com.anihpatrickugo.bankpick.ui.screens.main.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDownward
import androidx.compose.material.icons.outlined.ArrowUpward
import androidx.compose.material.icons.outlined.Wifi
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.anihpatrickugo.bankpick.R
import com.anihpatrickugo.bankpick.ui.components.common.CommonUI
import com.anihpatrickugo.bankpick.ui.theme.Blue40
import com.anihpatrickugo.bankpick.ui.theme.DarkBlue60
import com.anihpatrickugo.bankpick.ui.theme.DarkBlue80
import com.anihpatrickugo.bankpick.ui.theme.Grey80


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen() {
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
                            error = painterResource(R.drawable.ic_launcher_foreground),
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
                        Box(
                            modifier = Modifier
                                .size(42.dp)
                                .background(MaterialTheme.colorScheme.surfaceVariant, CircleShape)
                                .clickable { },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_search), // Use your back icon
                                contentDescription = "Back",
                                tint = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                    }
                }

                // card
                item{
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = DarkBlue60, // Blue color
                                shape = RoundedCornerShape(25.dp) // 👈 Rounded corners
                            )
                            .padding(16.dp)
                    ){
                        Row (
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ){
                            Icon(
                                painter = painterResource(id = R.drawable.ic_simcard), // Use your back icon
                                contentDescription = "simcard",
                                tint = Blue40
                            )

                            Icon(
                                imageVector = Icons.Outlined.Wifi,
                                contentDescription = "Back",
                                tint = Blue40,
                                modifier = Modifier.rotate(90f)
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "4562 1122 4595 7852",
                            fontSize = 20.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = "AR Jonson",
                            fontSize = 13.sp,
                            color = Color.White
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.Bottom
                        ){

                            Row(
                                horizontalArrangement = Arrangement.spacedBy(16.dp)
                            ){
                                Column {

                                    Text(
                                        text = "Expiry Date",
                                        fontSize = 9.sp,
                                        color = Grey80
                                    )
                                    Text(
                                        text = "12/2000",
                                        fontSize = 12.sp,
                                        color = Color.White
                                    )
                                }
                                Column {

                                    Text(
                                        text = "cvv",
                                        fontSize = 9.sp,
                                        color = Grey80
                                    )
                                    Text(
                                        text = "123",
                                        fontSize = 12.sp,
                                        color = Color.White
                                    )
                                }
                            }

                            Column (
                                horizontalAlignment = Alignment.CenterHorizontally
                            ){
                                Image(
                                    painter = rememberAsyncImagePainter("file:///android_asset/master.png"),
                                    contentDescription = "Mastercard",
                                    modifier = Modifier.size(width=36.dp, height = 20.dp)
                                )
                                Text(
                                    text = "Mastercard",
                                    fontSize = 12.sp,
                                    color = Color.White
                                )
                            }

                        }

                    }
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

                            Box(
                                modifier = Modifier
                                    .size(54.dp)
                                    .background(MaterialTheme.colorScheme.surfaceVariant, CircleShape)
                                    .clickable { },
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.ArrowUpward, // Use your back icon
                                    contentDescription = "sent",
                                    tint = MaterialTheme.colorScheme.onSurface
                                )
                            }
                            Text(
                                text = "Sent",
                                fontSize = 11.sp,

                            )
                        }

                        //receive
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Box(
                                modifier = Modifier
                                    .size(54.dp)
                                    .background(MaterialTheme.colorScheme.surfaceVariant, CircleShape)
                                    .clickable { },
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.ArrowDownward, // Use your back icon
                                    contentDescription = "receive",
                                    tint = MaterialTheme.colorScheme.onSurfaceVariant
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

                            Box(
                                modifier = Modifier
                                    .size(54.dp)
                                    .background(MaterialTheme.colorScheme.surfaceVariant, CircleShape)
                                    .clickable { },
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.ArrowDownward, // Use your back icon
                                    contentDescription = "loan",
                                    tint = MaterialTheme.colorScheme.onSurfaceVariant
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

                            Box(
                                modifier = Modifier
                                    .size(54.dp)
                                    .background(MaterialTheme.colorScheme.surfaceVariant, CircleShape)
                                    .clickable { },
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.ArrowDownward, // Use your back icon
                                    contentDescription = "topup",
                                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                            Text(
                                text = "Topup",
                                fontSize = 11.sp
                            )
                        }
                    }
                }

            }

            //blur shadow
            Image(
                painter = painterResource(id = R.drawable.background_blur),
                contentDescription = "Blur",
                modifier = Modifier.offset(x=140.dp, y=115.dp)
            )
        }
    }
}


