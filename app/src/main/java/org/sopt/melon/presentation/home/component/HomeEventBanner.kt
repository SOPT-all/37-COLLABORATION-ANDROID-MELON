package org.sopt.melon.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.melon.R
import org.sopt.melon.core.designsystem.theme.MELONTheme

@Composable
fun HomeEventBanner(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier =
            modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(4.dp))
                .background(MELONTheme.colors.gray500)
                .padding(horizontal = 8.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_bell),
            contentDescription = null,
            tint = MELONTheme.colors.primary,
            modifier =
                Modifier
                    .size(24.dp)
                    .clip(shape = CircleShape)
                    .background(MELONTheme.colors.gray700)
                    .padding(4.dp),
        )

        Spacer(Modifier.width(4.dp))

        Column {
            Text(
                text = stringResource(R.string.home_event_banner_title),
                style = MELONTheme.typography.caption.r_12,
                color = MELONTheme.colors.white,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )

            Text(
                text = stringResource(R.string.home_event_banner_description),
                style = MELONTheme.typography.caption.r_12,
                color = MELONTheme.colors.gray200,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }

        Spacer(Modifier.weight(1f))

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_x),
            contentDescription = null,
            tint = MELONTheme.colors.gray200,
            modifier = Modifier.size(24.dp),
        )
    }
}

@Preview
@Composable
private fun HomeEventBannerPreview() {
    MELONTheme {
        HomeEventBanner()
    }
}
