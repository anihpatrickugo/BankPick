package com.anihpatrickugo.bankpick.ui.screens.main.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
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
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.anihpatrickugo.bankpick.R
import com.anihpatrickugo.bankpick.ui.components.common.CommonUI
import com.anihpatrickugo.bankpick.ui.theme.Grey80
import com.anihpatrickugo.bankpick.ui.theme.Red
import com.anihpatrickugo.bankpick.ui.theme.White


@Composable
fun ProfileScreen() {


    CommonUI.Containner {
        Box(modifier =  Modifier.fillMaxSize()){
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item{
                    //header
                    CommonUI.Header(title = "Profile", onClickBack = { /*TODO*/ }, rightIcon = {
                        IconButton(
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                                .size(42.dp)
                                .background(MaterialTheme.colorScheme.surfaceVariant, CircleShape),
                            onClick = {}
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_person_edit),
                                contentDescription = "add icon",
                                modifier = Modifier.size(22.dp),
                                tint = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    })

                }


                item{
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = Alignment.CenterVertically
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
                                text = "Tanya Myroniuk",
                                fontSize = 18.sp
                            )

                            Text(
                                text = "Senior Designer",
                                fontSize = 12.sp,
                                color = Grey80
                            )

                        }

                    }
                }

                item{
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                    ) {

                        CommonUI.Link(
                            linkTitle = "Personal Information",
                            onClick = {},
                            leftIcon = {
                                Icon(painter = painterResource(id = R.drawable.ic_person_circle),
                                    contentDescription = "person-circle"
                                )
                            }
                        )

                        CommonUI.Link(
                            linkTitle = "Payment Preferences",
                            onClick = {},
                            leftIcon = {
                                Icon(painter = painterResource(id = R.drawable.ic_credit_cards),
                                    contentDescription = "credit-cards"
                                )
                            }
                        )

                        CommonUI.Link(
                            linkTitle = "Banks and Cards",
                            onClick = {},
                            leftIcon = {
                                Icon(painter = painterResource(id = R.drawable.ic_credit_card_edit),
                                    contentDescription = "card-edit"
                                )
                            }
                        )

                        CommonUI.Link(
                            linkTitle = "Notifications",
                            onClick = {},
                            leftIcon = {
                                Icon(painter = painterResource(id = R.drawable.ic_bell_notification),
                                    contentDescription = "bell"
                                )
                            },
                            rightIcon = {
                                Box(
                                    modifier = Modifier
                                        .size(18.dp)
                                        .background(Red, CircleShape),
                                    contentAlignment = Alignment.Center

                                ){
                                    Text(text = "2", color= White, fontSize = 11.sp)
                                }
                            }
                        )

                        CommonUI.Link(
                            linkTitle = "Message Center",
                            onClick = {},
                            leftIcon = {
                                Icon(painter = painterResource(id = R.drawable.ic_chat),
                                    contentDescription = "chat"
                                )
                            }

                        )

                        CommonUI.Link(
                            linkTitle = "Address",
                            onClick = {},
                            leftIcon = {
                                Icon(painter = painterResource(id = R.drawable.ic_location),
                                    contentDescription = "location"
                                )
                            }
                        )

                        CommonUI.Link(
                            linkTitle = "Settings",
                            onClick = {},
                            leftIcon = {
                                Icon(painter = painterResource(id = R.drawable.ic_settings),
                                    contentDescription = "settings"
                                )
                            }
                        )

                    }
                }

            }

        }

    }

}
