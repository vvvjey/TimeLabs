package com.example.designcomponent.components.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.example.designcomponent.theme.TimeLabsColors
import com.example.designcomponent.theme.TimeLabsDimens
import com.example.designcomponent.theme.TimeLabsTypography

data class ButtonStyle(
    val backgroundColor: Color,
    val contentColor: Color,
    val disabledBackgroundColor: Color = backgroundColor.copy(alpha = 0.6f),
    val disabledContentColor: Color = contentColor.copy(alpha = 0.6f),
    val textStyle: TextStyle = TimeLabsTypography.labelLarge,
    val shape: Shape = RoundedCornerShape(TimeLabsDimens.cornerRadiusBase),
    val height: Dp = TimeLabsDimens.buttonHeightLarge,
    val contentPadding: PaddingValues = PaddingValues(
        horizontal = TimeLabsDimens.spacing6,
        vertical = TimeLabsDimens.spacing3
    )
)

@Composable
fun BaseButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    style: ButtonStyle
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(style.height),
        enabled = enabled && !isLoading,
        shape = style.shape,
        colors = ButtonDefaults.buttonColors(
            containerColor = style.backgroundColor,
            contentColor = style.contentColor,
            disabledContainerColor = style.disabledBackgroundColor,
            disabledContentColor = style.disabledContentColor
        ),
        contentPadding = style.contentPadding,
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = TimeLabsDimens.elevationNone
        )
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.size(TimeLabsDimens.iconSizeMedium),
                color = style.contentColor,
                strokeWidth = TimeLabsDimens.borderWidthMedium
            )
        } else {
            Text(
                text = text,
                style = style.textStyle
            )
        }
    }
}
