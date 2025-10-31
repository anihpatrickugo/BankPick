package com.anihpatrickugo.bankpick.ui.screens.main.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.anihpatrickugo.bankpick.R
import com.anihpatrickugo.bankpick.ui.components.common.CommonUI
import com.anihpatrickugo.bankpick.ui.navigation.NavRoutes
import com.anihpatrickugo.bankpick.ui.theme.Grey100
import com.anihpatrickugo.bankpick.ui.theme.ThemeViewModel
import com.anihpatrickugo.bankpick.ui.theme.ThemeViewModelFactory



@Composable
fun SettingsScreen(navController: NavController ) {

    val context = LocalContext.current
    val themeViewModel: ThemeViewModel = viewModel(
        factory = ThemeViewModelFactory(context)
    )

    val isDarkTheme = themeViewModel.isDarkTheme.collectAsState()

    CommonUI.Containner {
        Box(modifier =  Modifier.fillMaxSize()){
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
               item{
                //header
                  CommonUI.Header(title = "Settings", onClickBack = { /*TODO*/ }, rightIcon = {
                    IconButton(
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .size(42.dp)
                            .background(MaterialTheme.colorScheme.surfaceVariant, CircleShape),
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_export),
                            contentDescription = "add icon",
                            modifier = Modifier.size(22.dp),
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                  })

               }

                item{
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Text(
                            text = "General",
                            color = Grey100,
                            fontSize = 14.sp
                        )
                        Spacer(modifier = Modifier.height(16.dp))

                        CommonUI.Link(
                            linkTitle = "Language",
                            linkLabel = "English",
                            onClick = {}
                        )

                        CommonUI.Link(
                            linkTitle = "My Profile",
                            onClick = {
                                navController.navigate(NavRoutes.Profile.route)}
                        )

                        CommonUI.Link(
                            linkTitle = "Contact Us",
                            onClick = {}
                        )


                    }
                }


                item{
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Text(
                            text = "Security",
                            color = Grey100,
                            fontSize = 14.sp
                        )
                        Spacer(modifier = Modifier.height(16.dp))

                        CommonUI.Link(
                            linkTitle = "Change Password",
                            onClick = {}
                        )

                        CommonUI.Link(
                            linkTitle = "Privacy Policy",
                            onClick = {}
                        )
                    }
                }

                item{
                    Column (
                        modifier = Modifier.fillMaxWidth()
                    ){
                        Text(
                            text = "Choose what data you share with us",
                            color = Grey100,
                            fontSize = 12.sp
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Dark Mode",
                                modifier = Modifier.weight(1f),
                                fontSize = 14.sp
                            )

                            Switch(
                                checked = isDarkTheme.value,
                                onCheckedChange = { themeViewModel.toggleTheme()},
                                modifier = Modifier.scale(0.7f)
                            )
                        }

                    }
                }

            }

        }

    }

}