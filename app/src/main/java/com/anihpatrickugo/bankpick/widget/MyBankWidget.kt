package com.anihpatrickugo.bankpick.widget

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.Image
import androidx.glance.ImageProvider
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.*
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider
//import androidx.glance.unit.dp
//import androidx.glance.unit.sp
import com.anihpatrickugo.bankpick.R
import com.anihpatrickugo.bankpick.ui.theme.Blue
import com.anihpatrickugo.bankpick.ui.theme.DarkBlue40

class MyBankWidget : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            MyBankWidgetContent()
        }
    }

    @Composable
    private fun MyBankWidgetContent() {
        Column(
            modifier = GlanceModifier
                .fillMaxSize()
                .background(ColorProvider(DarkBlue40)),
//                .padding(16.dp),
            horizontalAlignment = Alignment.Horizontal.CenterHorizontally,
            verticalAlignment = Alignment.Vertical.CenterVertically
        ) {
            Image(
                provider = ImageProvider(R.drawable.ic_launcher_foreground),
                contentDescription = "Bank Widget"
            )

//            Spacer(modifier = GlanceModifier.height(8.dp))

            Text(
                text = "My Bank Widget",
                style = TextStyle(
//                    fontSize = 14.sp,
                    color = ColorProvider(Blue)
                )
            )
        }
    }
}
