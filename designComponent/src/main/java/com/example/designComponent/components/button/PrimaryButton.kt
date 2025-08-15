package com.example.designcomponent.components.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.designcomponent.theme.TimeLabsColors

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    isLoading: Boolean = false
) {
    val primaryButtonStyle = ButtonStyle(
        backgroundColor = TimeLabsColors.Primary,
        contentColor = TimeLabsColors.TextOnPrimary
    )
    
    BaseButton(
        text = text,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        isLoading = isLoading,
        style = primaryButtonStyle
    )
}
