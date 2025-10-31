package com.anihpatrickugo.bankpick.ui.components.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForwardIos
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anihpatrickugo.bankpick.ui.theme.Grey100
import com.anihpatrickugo.bankpick.ui.theme.Grey60

@Composable
fun UILink(
    linkTitle: String,
    linkLabel: String?,
    onClick : () -> Unit,
    leftIcon: (@Composable (() -> Unit))? = null,
    rightIcon: (@Composable (() -> Unit))? = null,
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick() }
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth().padding(bottom= 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){

                leftIcon?.let{
                    Box(modifier = Modifier.padding(end=12.dp)){
                        leftIcon()
                    }

                }

                Text(
                    text = linkTitle,
                    fontSize = 14.sp
                )
            }


            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                linkLabel?.let{
                    Text(
                        text = linkLabel,
                        color = Grey100,
                        fontSize = 14.sp
                    )
                }

                Box(modifier = Modifier.padding(start=12.dp)){

                    if (rightIcon != null){
                        rightIcon()
                    }else{
                        Icon(
                            imageVector = Icons.Outlined.ArrowForwardIos,
                            contentDescription = "Arrow-forward",
                            tint = Grey100
                        )
                    }

                }

            }

        }
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(MaterialTheme.colorScheme.surfaceVariant)
        )

    }

}