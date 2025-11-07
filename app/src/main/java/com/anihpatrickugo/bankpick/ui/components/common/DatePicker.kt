package com.anihpatrickugo.bankpick.ui.components.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anihpatrickugo.bankpick.ui.theme.Grey80
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import java.util.Calendar

@Composable
fun UIDatePicker(
    label: String,
    selectedDate: Calendar,
    onDateSelected: (Calendar) -> Unit
) {
    val months = listOf(
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    )

    val days = (1..31).toList()
    val years = (1900..Calendar.getInstance().get(Calendar.YEAR)).toList().reversed()

    val selectedDay = selectedDate.get(Calendar.DAY_OF_MONTH)
    val selectedMonth = selectedDate.get(Calendar.MONTH)
    val selectedYear = selectedDate.get(Calendar.YEAR)

    // Outer container for the three vertical pickers
    Column(
        modifier = Modifier.fillMaxWidth()
    ){
        // Label above the field
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium.copy(
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
                fontSize = 14.sp
            ),
            modifier = Modifier.padding(bottom = 0.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(40.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // === Day Picker ===
            VerticalPicker(
                items = days.map { it.toString() },
                selectedItem = selectedDay.toString(),
                onItemSelected = { day ->
                    val newDate = selectedDate.clone() as Calendar
                    newDate.set(Calendar.DAY_OF_MONTH, day.toInt())
                    onDateSelected(newDate)
                },
                modifier = Modifier.weight(1f)
            )

            // === Month Picker ===
            VerticalPicker(
                items = months,
                selectedItem = months[selectedMonth],
                onItemSelected = { month ->
                    val newDate = selectedDate.clone() as Calendar
                    newDate.set(Calendar.MONTH, months.indexOf(month))
                    onDateSelected(newDate)
                },
                modifier = Modifier.weight(1.5f)
            )

            // === Year Picker ===
            VerticalPicker(
                items = years.map { it.toString() },
                selectedItem = selectedYear.toString(),
                onItemSelected = { year ->
                    val newDate = selectedDate.clone() as Calendar
                    newDate.set(Calendar.YEAR, year.toInt())
                    onDateSelected(newDate)
                },
                modifier = Modifier.weight(1f)
            )
        }
        Spacer(modifier = Modifier.height(18.dp))
    }
}


@Composable
fun VerticalPicker(
    items: List<String>,
    selectedItem: String,
    onItemSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    // Lazy list scroll state
    val listState = rememberLazyListState(
        initialFirstVisibleItemIndex = items.indexOf(selectedItem).coerceAtLeast(0)
    )

    val flingBehavior = rememberSnapFlingBehavior(listState)


    // Detect when the center item changes
    LaunchedEffect(listState) {
        snapshotFlow { listState.firstVisibleItemIndex }
            .map { index ->
                // Pick roughly the middle of visible items (center)
                val centerIndex = (index + 1).coerceIn(0, items.lastIndex)
                items[centerIndex]
            }
            .distinctUntilChanged()
            .collect { newSelected ->
                if (newSelected != selectedItem) onItemSelected(newSelected)
            }
    }

    Box(
        modifier = modifier
            .height(50.dp)
            .background(Color.Transparent),
        contentAlignment = Alignment.Center
    ) {
        // Scrollable column
        LazyColumn(
            state = listState,
            flingBehavior = flingBehavior,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            itemsIndexed(items) { _, item ->
                val isSelected = item == selectedItem

                Text(
                    text = item,
                    fontSize = if (isSelected) 18.sp else 16.sp,
                    color = if (isSelected) MaterialTheme.colorScheme.onSurface else Grey80,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
            }
        }

        // Bottom border
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(1.dp)
                .background(Grey80.copy(alpha = 0.3f))
        )

    }
}

