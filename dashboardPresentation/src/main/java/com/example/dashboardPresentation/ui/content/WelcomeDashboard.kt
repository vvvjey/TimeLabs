package com.example.dashboardPresentation.ui.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WelcomeDashboard(name :String = "Timer") {
    Column(){
        Text(
            modifier = Modifier.fillMaxWidth()
                .padding(bottom = 10.dp,top = 10.dp)
                ,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            text = "Welcome to TimeLabs!, ${name} "
        )
        LazyRow(
            contentPadding = PaddingValues(horizontal = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(5) {
                WelcomeDashboardComponent()
            }
        }
    }
}

@Composable
fun WelcomeDashboardComponent() {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(vertical = 8.dp)
            .clip(shape = RoundedCornerShape(12.dp))
            .background(Color(0xffff4281))
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically // align icon and text vertically


    ) {
        Icon (
            imageVector = Icons.Default.Add,
            contentDescription = "Add new collections",
            modifier = Modifier
                .padding(end = 4.dp, start = 4.dp)
                .size(24.dp)
        )
        Text(
            modifier = Modifier.padding(end = 8.dp),
            text = "New collection",
        )
    }
}

@Preview
@Composable
fun PreviewWelcomeDashboard() {
    WelcomeDashboard()
}
