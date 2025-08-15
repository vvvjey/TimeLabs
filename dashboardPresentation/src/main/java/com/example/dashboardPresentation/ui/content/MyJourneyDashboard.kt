package com.example.dashboardPresentation.ui.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.designcomponent.theme.TimeLabsColors

data class JourneyItem(
    val name: String,
    val description: String,
    val image: String
)


val myJourneyDashboard: List<JourneyItem> = listOf(
    JourneyItem(
        name = "Timer",
        description = "Timer is a simple app that helps you to manage your time",
        image = "https://cdn-icons-png.flaticon.com/512/25/25694.png"
    ),
    JourneyItem(
        name = "Timer",
        description = "Timer is a simple app that helps you to manage your time",
        image = "https://cdn-icons-png.flaticon.com/512/25/25694.png"
    )
)

@Composable
fun MyJourneyDashboard() {
    Row( modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "My Journey",fontSize = 30.sp,fontWeight = FontWeight.Bold)
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = "See all", fontWeight = FontWeight.Bold, fontSize = 24.sp, color = TimeLabsColors.Primary)
            Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "Add new collections")
        }
    }
}

@Preview
@Composable
fun PreviewMyJourneyDashboard() {
    MyJourneyDashboard()
}