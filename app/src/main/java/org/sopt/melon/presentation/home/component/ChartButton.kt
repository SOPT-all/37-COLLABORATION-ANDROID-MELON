package org.sopt.melon.presentation.home.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.melon.R
import org.sopt.melon.core.designsystem.theme.MELONTheme

@Composable
fun ChartButton(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int = R.drawable.ic_play_24,
    content: String = "TOP 100 전체듣기",
) {
    Row(
        modifier =
            modifier
                .fillMaxWidth()
                .height(44.dp)
                .clip(shape = RoundedCornerShape(4.dp))
                .background(MELONTheme.colors.gray500)
                .padding(horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = icon),
            contentDescription = null,
            tint = Color.Unspecified,
        )
        Spacer(Modifier.width(4.dp))
        Text(
            content,
            style = MELONTheme.typography.body.m_14,
            color = MELONTheme.colors.white,
        )
    }
}

@Preview
@Composable
private fun ChartButtonPreview() {
    MELONTheme {
        ChartButton()
    }
}
