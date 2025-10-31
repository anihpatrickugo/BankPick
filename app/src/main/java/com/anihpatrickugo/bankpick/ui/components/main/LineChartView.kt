package com.anihpatrickugo.bankpick.ui.components.main

import android.graphics.drawable.GradientDrawable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.anihpatrickugo.bankpick.ui.theme.Blue
import com.anihpatrickugo.bankpick.ui.theme.Grey100
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

@Composable
fun LineChartView(
    xData: List<Float>,
    yData: List<Float>,
    title: String = "Current Balance",
    amount: String = "\$8,545.00",
    modifier: Modifier = Modifier,
    gradientStartColor: Color = Blue,
    gradientEndColor: Color = Color.Transparent
) {
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                fontSize = 18.sp,
                color = Grey100,
                textAlign = TextAlign.Center
            )
            Text(
                text = amount,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )
        }


        // ✅ Chart itself
        AndroidView(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            factory = { context ->
                LineChart(context).apply {
                    description.isEnabled = false
                    setTouchEnabled(true)
                    isDragEnabled = true
                    setScaleEnabled(true)
                    setPinchZoom(true)
                    animateX(1200)

                    // ✅ Customize X-axis
                    xAxis.apply {
                        position = XAxis.XAxisPosition.BOTTOM
                        setDrawGridLines(false)
                        textColor = android.graphics.Color.DKGRAY
                        setDrawAxisLine(false)
                    }

                    // ✅ Customize Y-axis
//                    axisLeft.apply {
//                        setDrawGridLines(false)
//                        textColor = android.graphics.Color.DKGRAY
//                    }
                    axisLeft.isEnabled = false
                    axisRight.isEnabled = false
                    legend.isEnabled = false
                }
            },
            update = { chart ->
                val entries = xData.zip(yData) { x, y -> Entry(x, y) }

                val dataSet = LineDataSet(entries, "").apply { // 👈 empty label removes text
                    color = Blue.toArgb()
                    setDrawCircles(false)
                    mode = LineDataSet.Mode.CUBIC_BEZIER
                    lineWidth = 2.5f
                    setDrawValues(false)

                    // ✅ Enable gradient fill
                    setDrawFilled(true)
                    fillAlpha = 255
                    fillDrawable = GradientDrawable(
                        GradientDrawable.Orientation.TOP_BOTTOM,
                        intArrayOf(
                            gradientStartColor.copy(alpha = 0.7f).toArgb(),
                            gradientEndColor.toArgb()
                        )
                    )
                }

                chart.data = LineData(dataSet)
                chart.invalidate()
            }
        )
    }
}
