package com.example.splashscreenpresentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.designcomponent.TimeLabsDesignSystem
import com.example.designcomponent.components.button.PrimaryButton
import com.example.designcomponent.theme.TimeLabsTheme
import com.example.navigation.router.navigateToPath
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TimeLabsTheme {
                SplashScreenContent {
                    // Path-based navigation - no module dependency!
                    navigateToPath("dashboard")
                }
            }
        }
    }
}

@Composable
private fun SplashScreenContent(onNavigateToDashboard: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(TimeLabsDesignSystem.Dimens.spacing4),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Welcome to TimeLabs",
            style = TimeLabsDesignSystem.Typography.headlineLarge,
            color = TimeLabsDesignSystem.Colors.TextPrimary,
            modifier = Modifier.padding(bottom = TimeLabsDesignSystem.Dimens.spacing6)
        )

        PrimaryButton(
            text = "Go to Dashboard",
            onClick = onNavigateToDashboard
        )
    }
}
