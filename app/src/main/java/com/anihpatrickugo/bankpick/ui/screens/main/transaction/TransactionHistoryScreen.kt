package com.anihpatrickugo.bankpick.ui.screens.main.transaction

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.History
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anihpatrickugo.bankpick.R
import com.anihpatrickugo.bankpick.ui.components.common.CommonUI
import com.anihpatrickugo.bankpick.ui.theme.Blue

@Composable
fun TransactionHistoryScreen() {

    CommonUI.Containner {
        Box(modifier =  Modifier.fillMaxSize()){
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item{
                    //header
                    CommonUI.Header(title = "Transaction History", onClickBack = { /*TODO*/ }, rightIcon = {
                        IconButton(
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                                .size(42.dp)
                                .background(MaterialTheme.colorScheme.background, CircleShape),
                            onClick = {
//                                navController.navigate(NavRoutes.EditProfile.route)
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.History,
                                contentDescription = "history icon",
                                modifier = Modifier.size(22.dp),
                                tint = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    })

                }

                item{

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(text = "Transaction", fontSize = 18.sp)
                        Text(text = "see all", fontSize=14.sp, color = Blue)
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

}
