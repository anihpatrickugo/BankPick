package com.anihpatrickugo.bankpick.ui.components.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Wifi
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.anihpatrickugo.bankpick.R
import com.anihpatrickugo.bankpick.ui.theme.Blue40
import com.anihpatrickugo.bankpick.ui.theme.DarkBlue60
import com.anihpatrickugo.bankpick.ui.theme.Grey80


@Composable
fun DebitCard() {
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