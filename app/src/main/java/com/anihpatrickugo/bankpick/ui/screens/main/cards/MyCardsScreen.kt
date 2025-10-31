package com.anihpatrickugo.bankpick.ui.screens.main.cards

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material.icons.outlined.ArrowDownward
import androidx.compose.material.icons.outlined.ArrowUpward
import androidx.compose.material.icons.outlined.Wifi
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anihpatrickugo.bankpick.R
import com.anihpatrickugo.bankpick.ui.components.common.CommonUI
import com.anihpatrickugo.bankpick.ui.components.main.DebitCard
import com.anihpatrickugo.bankpick.ui.theme.Blue
import kotlin.math.max
import kotlin.math.min


@Composable
fun CurvedProgressWithRange(
    value: Int,
    minValue: Int = 0,
    maxValue: Int = 10_000,
    modifier: Modifier = Modifier
) {
    val clampedValue = min(max(value, minValue), maxValue)
    val progress = (clampedValue - minValue).toFloat() / (maxValue - minValue).toFloat()

    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        label = "animatedProgress"
    )

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(32.dp), // increased height to fit the label
            contentAlignment = Alignment.BottomStart
        ) {
            // 🟦 Background Bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(12.dp)
                    .clip(RoundedCornerShape(50))
                    .background(MaterialTheme.colorScheme.surfaceVariant)
            )

            // 🟩 Progress Indicator
            LinearProgressIndicator(
                progress = { animatedProgress },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(7.dp),
                color = MaterialTheme.colorScheme.primary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant,
                strokeCap = StrokeCap.Round
            )

            // 💰 Dynamic value positioned under progress
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(animatedProgress) // positions based on progress
                        .wrapContentWidth(Alignment.End) // aligns text at the end of filled width
                ) {
                    Text(
                        text = "$$value",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.offset(x = 20.dp, y = 20.dp) // fine-tune offset
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // 💵 Range Labels (min and max)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "$${minValue}",
                fontSize = 11.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = "$${maxValue}",
                fontSize = 11.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyCardsScreen() {
    val animatedProgress by animateFloatAsState(
        targetValue = 0.8f,
        label = "animatedProgress"
    )

    CommonUI.Containner {
        Box(modifier =  Modifier.fillMaxSize()){
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
//                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                item{
                    CommonUI.Header(title = "My Cards", onClickBack = { /*TODO*/ }, rightIcon = {
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


                item{

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(text = "Transaction", fontSize = 18.sp)
                        Text(text = "see all", fontSize=14.sp, color = Blue)
                    }

                }
                
                items(3){item ->
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
                                contentDescription = "apple",
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

                // limit
                item{
                    Text(
                        text = "Monthly spending limit",
                        fontSize = 18.sp,
                        textAlign = TextAlign.Left
                    )

                    Spacer(modifier = Modifier.height(8.dp))

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
                            text = "Amount: \$8,545.00",
                            fontSize = 12.sp,
                        )

                        CurvedProgressWithRange(
                            value = 4800,
                            minValue = 0,
                            maxValue = 10_000
                        )


                    }
                    Spacer(modifier = Modifier.height(90.dp))
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




