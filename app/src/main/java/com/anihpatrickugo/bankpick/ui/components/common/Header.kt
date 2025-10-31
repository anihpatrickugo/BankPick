package com.anihpatrickugo.bankpick.ui.components.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anihpatrickugo.bankpick.R

@Composable
fun UIHeader(
    modifier: Modifier = Modifier,
    title: String? = null,
    onClickBack: (() -> Unit)? = null,
    rightIcon: (@Composable (() -> Unit))? = null,

) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(46.dp), // standard app bar height
        contentAlignment = Alignment.Center
    ) {
        // 🔙 Back button (optional)
        if (onClickBack != null) {
            IconButton(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .size(42.dp)
                    .background(MaterialTheme.colorScheme.surfaceVariant, CircleShape),
                onClick = {onClickBack()}
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.arrowbackicon),
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        }

        // 🏷️ Center title (optional)
        if (!title.isNullOrEmpty()) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 18.sp
                ),
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        // ⚙️ Right icon (optional)
        if (rightIcon != null ) {
           rightIcon()
        }
    }
    Spacer(modifier = Modifier.height(20.dp))
}
