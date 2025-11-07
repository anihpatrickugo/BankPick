package com.anihpatrickugo.bankpick.ui.screens.main.cards

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.anihpatrickugo.bankpick.R
import com.anihpatrickugo.bankpick.ui.components.common.CommonUI
import com.anihpatrickugo.bankpick.ui.components.main.DebitCard
import com.anihpatrickugo.bankpick.ui.navigation.NavRoutes

@Composable
fun  AllCardsScreen(navController: NavController) {

    CommonUI.Containner {
        Box(modifier =  Modifier.fillMaxSize()){
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                item{
                    CommonUI.Header(title = "All Cards", onClickBack = { /*TODO*/ }, rightIcon = {
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
                items(2){_item ->
                    DebitCard()
                }


                // buttom
                item{
                    Spacer(modifier = Modifier.height(50.dp))
                    
                    CommonUI.Button(text = "Add Card +", onClick = {
                        navController.navigate(NavRoutes.NewCard.route)
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
}




