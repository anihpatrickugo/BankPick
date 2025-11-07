package com.anihpatrickugo.bankpick.ui.screens.main.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.anihpatrickugo.bankpick.R
import com.anihpatrickugo.bankpick.ui.components.common.CommonUI
import com.anihpatrickugo.bankpick.ui.theme.Grey80
import java.util.*





@Composable
fun EditProfileScreen() {

    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    var selectedDate by remember { mutableStateOf(Calendar.getInstance()) }

    CommonUI.Containner {
        Box(modifier =  Modifier.fillMaxSize()){
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item{
                    //header
                    CommonUI.Header(title = "Edit Profile", onClickBack = { /*TODO*/ })

                }


                item{
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
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

                item{
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {


                        // full name
                        CommonUI.TextField(
                            value = name,
                            onValueChange = { name = it },
                            label = "Full Name",
                            placeholder = "eg Ugochukwu Patrick",
                            singleLine = true,
                            leadingIcon = R.drawable.ic_person
                        )

                        // Email address

                        CommonUI.TextField(
                            value = email,
                            onValueChange = { email = it },
                            label = "Email Address",
                            placeholder = "youemail@domain.com",
                            singleLine = true,
                            leadingIcon = R.drawable.ic_email,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                        )


                        // phone number
                        CommonUI.TextField(
                            value = phone,
                            onValueChange = { phone = it },
                            label = "Phone Number",
                            placeholder = "+234",
                            singleLine = true,
                            leadingIcon = R.drawable.ic_phone,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                        )

                        //date
                        CommonUI.DatePicker(
                            label = "Birth Date",
                            selectedDate = selectedDate,
                            onDateSelected = { selectedDate = it }
                        )

                    }
                }

                item{
                    Spacer(modifier = Modifier.height(40.dp))
                    Text(
                        text = "Joined 28 Jan 2021",
                        style = MaterialTheme.typography.labelMedium.copy(
                            color = Grey80,
                            fontSize = 12.sp,
                            textAlign = TextAlign.Center
                        )
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                }

            }

        }

    }

}
