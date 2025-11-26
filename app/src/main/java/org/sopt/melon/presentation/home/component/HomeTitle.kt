package org.sopt.melon.presentation.home.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.sopt.melon.core.designsystem.theme.MELONTheme

@Composable
fun HomeTitle(
    title: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = title,
        style = MELONTheme.typography.heading.b_20,
        color = MELONTheme.colors.white,
        modifier = modifier.padding(start = 20.dp),
    )
}
