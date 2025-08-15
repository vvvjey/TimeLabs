package com.example.designcomponent.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val TimeLabsColorScheme = lightColorScheme(
    primary = TimeLabsColors.Primary,
    onPrimary = TimeLabsColors.TextOnPrimary,
    secondary = TimeLabsColors.Secondary,
    onSecondary = TimeLabsColors.TextOnSecondary,
    background = TimeLabsColors.BackgroundPrimary,
    onBackground = TimeLabsColors.TextPrimary,
    surface = TimeLabsColors.Surface,
    onSurface = TimeLabsColors.TextPrimary,
    error = TimeLabsColors.Error
)

@Composable
fun TimeLabsTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = TimeLabsColorScheme,
        typography = timeLabsTypography,
        content = content
    )
}
