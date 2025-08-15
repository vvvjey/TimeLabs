package com.example.designcomponent.components.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.designcomponent.theme.TimeLabsColors

@Composable
fun SecondaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    isLoading: Boolean = false
) {
    val secondaryButtonStyle = ButtonStyle(
        backgroundColor = TimeLabsColors.BackgroundSecondary,
        contentColor = TimeLabsColors.TextPrimary
    )
    
    BaseButton(
        text = text,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        isLoading = isLoading,
        style = secondaryButtonStyle
    )
}
