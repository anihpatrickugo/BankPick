package com.anihpatrickugo.bankpick.ui.components.common

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anihpatrickugo.bankpick.ui.theme.Grey100
import com.anihpatrickugo.bankpick.ui.theme.Grey80

@Composable
fun UITextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "",
    innerLabel: Boolean = false,
    isSearchField: Boolean = false,
    singleLine: Boolean = true,
    leadingIcon: Int? = null,
    trailingIcon: Int? = null,
    onTrailingIconClick: (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions? = KeyboardOptions(keyboardType = KeyboardType.Text),
    modifier: Modifier = Modifier
) {

    val unfocusedContainerColor = if (isSearchField) MaterialTheme.colorScheme.background else Color.Transparent
    val unfocusedIndicatorColor = if (isSearchField) Color.Transparent else Grey80.copy(alpha = 0.3f)

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        // Label above the field
        if(!innerLabel){
            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium.copy(
                    color = Grey100,
                    fontSize = 14.sp
                ),
                modifier = Modifier.padding(bottom = 0.dp)
            )
        }

        // Plain TextField (no borders)
        TextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = TextStyle(fontSize = 14.sp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = MaterialTheme.colorScheme.primary,   // bottom line color (active)
                unfocusedIndicatorColor = unfocusedIndicatorColor, // bottom line color (inactive)
                disabledIndicatorColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f),
                focusedContainerColor = MaterialTheme.colorScheme.background,
                unfocusedContainerColor = unfocusedContainerColor,

            ),
            label = {
                    if (innerLabel){
                        Text(
                            text = label,
                            style = MaterialTheme.typography.labelMedium.copy(
                                color = Grey100,
                                fontSize = 13.sp
                            ),
                            modifier = Modifier.padding(bottom = 0.dp)
                        )
                    }
            },
            singleLine = singleLine,
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = placeholder, fontSize = 14.sp) },
            leadingIcon = {
                leadingIcon?.let {
                    Icon(
                        painter = painterResource(id = it),
                        contentDescription = "Leading Icon",
                        tint = Grey100
                    )
                }
            },
            trailingIcon = {
                trailingIcon?.let {
                    IconButton(onClick = { onTrailingIconClick?.invoke() }) {
                        Icon(
                            painter = painterResource(id = it),
                            contentDescription = "Trailing Icon",
                            tint =  Grey100
                        )
                    }
                }
            },
            keyboardOptions = keyboardOptions!!
        )
        Spacer(modifier=Modifier.height(12.dp))
    }
}
