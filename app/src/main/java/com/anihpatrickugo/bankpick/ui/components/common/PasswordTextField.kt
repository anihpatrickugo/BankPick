package com.anihpatrickugo.bankpick.ui.components.common

import androidx.compose.foundation.layout.*
import com.anihpatrickugo.bankpick.R
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UIPasswordTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "",
    singleLine: Boolean = true,
    leadingIcon: Int? = null,
    modifier: Modifier = Modifier
) {
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        // Label above the field
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium.copy(
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
                fontSize = 14.sp
            ),
            modifier = Modifier.padding(bottom = 0.dp)
        )

        // Plain TextField (no borders)
        TextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = TextStyle(fontSize = 14.sp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = MaterialTheme.colorScheme.primary,   // bottom line color (active)
                unfocusedIndicatorColor = MaterialTheme.colorScheme.outline, // bottom line color (inactive)
                disabledIndicatorColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f),
                focusedContainerColor = MaterialTheme.colorScheme.background,
                unfocusedContainerColor = Color.Transparent,
            ),
            singleLine = singleLine,
            visualTransformation = if (passwordVisible)
                VisualTransformation.None else PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = placeholder, fontSize = 14.sp) },
            leadingIcon = {
                leadingIcon?.let {
                    Icon(
                        painter = painterResource(id = it),
                        contentDescription = "Leading Icon",
                        tint = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f)
                    )
                }
            },
            trailingIcon = {
                val eyeIcon =
                    if (passwordVisible) R.drawable.ic_eye_show else R.drawable.ic_eye_off
                val contentDesc =
                    if (passwordVisible) "Hide password" else "Show password"

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        painter = painterResource(id = eyeIcon),
                        contentDescription = contentDesc,
                        tint = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f)
                    )
                }
            },
        )
        Spacer(modifier = Modifier.height(18.dp))
    }
}
