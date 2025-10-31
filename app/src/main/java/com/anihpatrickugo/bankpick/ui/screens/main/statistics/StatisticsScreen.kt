package com.anihpatrickugo.bankpick.ui.screens.main.statistics

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NotificationsNone
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
import com.anihpatrickugo.bankpick.ui.components.main.LineChartView
import com.anihpatrickugo.bankpick.ui.theme.Blue


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StatisticsScreen() {
    CommonUI.Containner {
        Box(modifier =  Modifier.fillMaxSize()){

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item{
                    CommonUI.Header(title = "Statistics", onClickBack = { /*TODO*/ }, rightIcon = {
                        IconButton(
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                                .size(42.dp)
                                .background(MaterialTheme.colorScheme.surfaceVariant, CircleShape),
                            onClick = {}
                        ) {
                            Icon(
                                imageVector = Icons.Filled.NotificationsNone,
                                contentDescription = "notification icon",
                                modifier = Modifier.size(22.dp),
                                tint = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    })
                }
                item{

                    val xValues = listOf(0f, 1f, 2f, 3f, 4f, 5f)
                    val yValues = listOf(2f, 4f, 1f, 5f, 3f, 6f)

                    LineChartView(
                        xData = xValues,
                        yData = yValues,
                        )
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
                                    MaterialTheme.colorScheme.surfaceVariant,
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



