package com.example.dashboardPresentation.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Text
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Photo
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.dashboardPresentation.ui.content.MyJourneyDashboard
import com.example.dashboardPresentation.ui.content.WelcomeDashboard

class DashboardActivity : AppCompatActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            MaterialTheme(colorScheme = WhiteColorScheme) {
                DashboardScreen()
            }
        }
    }
}
private val WhiteColorScheme = lightColorScheme(
    primary = Color.Black,
    onPrimary = Color.White,
    primaryContainer = Color.White,
    onPrimaryContainer = Color.Black,
    background = Color.White,
    surface = Color.White,
    onSurface = Color.Black
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen() {
    var currentIcon by remember { mutableStateOf(BottomNavScreen.HOME) }

    Scaffold(
        modifier = Modifier.background(Color.White),
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier.shadow(4.dp),
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black,
                ),
                title = {
                    Text(
                        "TimeLab",
                        maxLines = 1
                    )
                },
                actions = {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = "Notification",
                        tint = Color.Black,
                        modifier = Modifier
                            .clickable {
                                Log.d("DashboardScreen", "Clicked: Notification")
                            }
                            .padding(8.dp)
                    )

                    AsyncImage(
                        model = "https://static.wikia.nocookie.net/mcleodgaming/images/9/95/Charizard.png/revision/latest?cb=20240515184357",
                        contentDescription = "Profile Picture",
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .clickable {
                                Log.d("DashboardScreen", "Clicked: Profile Picture")
                            }
                    )

                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* Handle click */ }) {
                Icon(Icons.Default.Add, contentDescription = "Thêm")
            }
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.shadow(8.dp),
                containerColor = Color.White,
                contentColor = Color.Gray,
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BottomNavScreen.values().forEach { screen ->
                        val iconColor by animateColorAsState(
                            targetValue = if (currentIcon == screen) Color.Blue else Color.Gray,
                            label = "Icon color animation"
                        )

                        Icon(
                            imageVector = screen.icon,
                            contentDescription = screen.description,
                            tint = iconColor,
                            modifier = Modifier
                                .clickable {
                                    currentIcon = screen
                                    Log.d("DashboardScreen", "Clicked: ${screen.description}")
                                }
                                .padding(8.dp)
                        )

                    }
                }
            }
        },
        content = { paddingValues ->
            LazyColumn(modifier = Modifier.padding(paddingValues)
                .padding(horizontal = 16.dp)
            ) {
                items(1) {
                    WelcomeDashboard()
                    MyJourneyDashboard()

                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewDashboardScreen() {
    DashboardScreen()
}



enum class BottomNavScreen(val id: String, val icon: ImageVector, val description: String) {
    HOME("home", Icons.Default.Home, "Home"),
    ADD("add", Icons.Default.Add, "Thêm"),
    GALLERY("gallery", Icons.Default.Photo, "Gallery")
}