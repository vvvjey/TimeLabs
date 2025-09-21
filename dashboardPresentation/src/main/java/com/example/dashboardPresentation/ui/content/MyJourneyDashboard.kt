package com.example.dashboardPresentation.ui.content

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.designcomponent.theme.TimeLabsColors
import com.example.designcomponent.theme.TimeLabsColors.Divider

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
    ),
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
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(text = "My Journey",fontSize = 30.sp,fontWeight = FontWeight.Bold)
                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(text = "See all", fontWeight = FontWeight.Bold, fontSize = 24.sp, color = TimeLabsColors.Primary)
                    Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "Add new collections")
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, start = 4.dp, end = 4.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                myJourneyDashboard.chunked(2).forEach { rowItems ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        rowItems.forEach { _ ->
                            Box(modifier = Modifier.weight(1f)) {
                                MyJourneyDashboardComponent()
                            }
                        }
                        // add spacer if odd count so layout stays balanced
                        if (rowItems.size == 1) {
                            Spacer(modifier = Modifier.weight(1f))
                        }
                    }
                }
            }
        }

    }
}

@Preview
@Composable
fun PreviewMyJourneyDashboard() {
    MyJourneyDashboard()
}

@Composable
fun MyJourneyDashboardComponent() {
    Column (
        modifier = Modifier.fillMaxWidth()
        .clip(RoundedCornerShape(12.dp))
        .border(
            width = 1.dp,
            color = Color.Gray,
            shape = RoundedCornerShape(12.dp)
        )

    ){
        // Journey Title
        Row(
            modifier = Modifier.fillMaxWidth()
            .padding(top = 10.dp, bottom = 10.dp),
            verticalAlignment = Alignment.CenterVertically,

        ){
            Box(
                modifier = Modifier.weight(0.2f),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Android,
                    contentDescription = "Add new collections",
                )
            }
            Text(
                modifier = Modifier.weight(0.7f),
                text = "Coding Certification")
        }
        // Journey Image
        Box(
            modifier = Modifier.fillMaxWidth()
                .height(100.dp)
        ) {
            AsyncImage(
                modifier = Modifier.
                fillMaxWidth()
                    ,
                model = "https://img.freepik.com/premium-vector/programming-code-coding-hacker-background-programming-code-icon-made-with-binary-code_127544-815.jpg",
                contentDescription = "Add new collections",
                contentScale = ContentScale.Crop

            )
            Text(
                modifier = Modifier
                    .align(Alignment.BottomStart),
                text = "Timer is a simple app that helps you to manage your time"
            )
        }

        // Journey progress
        MyJourneyDashboardComponentProgress()

        // Journey button
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 10.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFFFF4281),
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Add new entry",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp
            )
        }
    }
}

@Composable
fun MyJourneyDashboardComponentProgress() {
    Column(modifier = Modifier.fillMaxWidth()
        .padding(vertical = 10.dp, horizontal = 4.dp)
    ) {

        Divider(color = Color.Gray.copy(alpha = 0.5f), thickness = 1.dp)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(fontSize = 20.sp, color = Color(0xffff4281), text = "45")
                Text(fontSize = 12.sp,color = Color(0xff8c8d8b), text = "Entries")
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(fontSize = 20.sp, color = Color(0xffff4281), text = "60")
                Text(fontSize = 12.sp,color = Color(0xff8c8d8b), text = "Day active")
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(fontSize = 20.sp, color = Color(0xffff4281), text = "45%")
                Text(fontSize = 12.sp,color = Color(0xff8c8d8b), text = "Progress")
            }
        }

        Divider(color = Color.Gray.copy(alpha = 0.5f), thickness = 1.dp)
    }
}
