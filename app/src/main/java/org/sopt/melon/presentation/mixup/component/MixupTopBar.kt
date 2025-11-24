package org.sopt.melon.presentation.mixup.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.melon.R
import org.sopt.melon.core.common.util.noRippleClickable
import org.sopt.melon.core.designsystem.theme.MELONTheme

@Composable
fun MixUpTopBar(
    onSearchClick: () -> Unit,
    onChevronClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth(),
    ) {
        MixUpTopbarTexts()

        Spacer(Modifier.size(37.dp))

        MixUpTopbarIcons(
            onSearchClick = onSearchClick,
            onChevronClick = onChevronClick,
        )
    }
}

@Composable
fun MixUpTopbarTexts(
    modifier: Modifier = Modifier,
) {
    var current by remember { mutableStateOf(MixUpTopBarActivated.MIXUP) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier,
    ) {
        Text(
            text = "재생목록",
            style = MELONTheme.typography.heading.b_20,
            color =
                if (current == MixUpTopBarActivated.PLAYLIST) {
                    MELONTheme.colors.white
                } else {
                    MELONTheme.colors.gray200
                },
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier =
                Modifier.noRippleClickable(
                    { current = MixUpTopBarActivated.PLAYLIST },
                ),
        )
        Text(
            text = "음악서랍",
            style = MELONTheme.typography.heading.b_20,
            color =
                if (current == MixUpTopBarActivated.MUSIC_SHELF) {
                    MELONTheme.colors.white
                } else {
                    MELONTheme.colors.gray200
                },
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier =
                Modifier.noRippleClickable(
                    { current = MixUpTopBarActivated.MUSIC_SHELF },
                ),
        )
        Text(
            text = "믹스업",
            style = MELONTheme.typography.heading.b_20,
            color =
                if (current == MixUpTopBarActivated.MIXUP) {
                    MELONTheme.colors.white
                } else {
                    MELONTheme.colors.gray200
                },
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier =
                Modifier.noRippleClickable(
                    { current = MixUpTopBarActivated.MIXUP },
                ),
        )
    }
}

private enum class MixUpTopBarActivated {
    PLAYLIST,
    MUSIC_SHELF,
    MIXUP,
}

@Composable
fun MixUpTopbarIcons(
    onSearchClick: () -> Unit,
    onChevronClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier,
    ) {
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.ic_search),
            contentDescription = null,
            modifier = Modifier.noRippleClickable(onSearchClick),
        )
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.ic_chevron_down),
            contentDescription = null,
            modifier = Modifier.noRippleClickable(onChevronClick),
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0x12121212)
@Composable
fun MixUpBarPreview() {
    MixUpTopBar(
        onSearchClick = {},
        onChevronClick = {},
        modifier = Modifier.size(width = 320.dp, height = 30.dp),
    )
}
