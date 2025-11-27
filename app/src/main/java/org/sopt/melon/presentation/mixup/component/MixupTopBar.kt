package org.sopt.melon.presentation.mixup.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.melon.R
import org.sopt.melon.core.common.util.noRippleClickable
import org.sopt.melon.core.designsystem.theme.MELONTheme
import org.sopt.melon.presentation.mixup.type.MixUpTopBar

@Composable
fun MixUpTopBar(
    onSearchClick: () -> Unit,
    onChevronClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth(),
    ) {
        MixUpTopbarTab()

        MixUpTopbarIcons(
            onSearchClick = onSearchClick,
            onChevronClick = onChevronClick,
        )
    }
}

@Composable
private fun MixUpTopbarTab(
    modifier: Modifier = Modifier,
) {
    var current by remember { mutableStateOf(MixUpTopBar.MIXUP) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier,
    ) {
        MixUpTopBar.entries.forEach {
            Text(
                text = stringResource(it.displayName),
                style = MELONTheme.typography.heading.b_20,
                color =
                    if (current == it) {
                        MELONTheme.colors.white
                    } else {
                        MELONTheme.colors.gray200
                    },
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier =
                    Modifier.noRippleClickable { current = it },
            )
        }
    }
}

@Composable
private fun MixUpTopbarIcons(
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
            modifier =
                Modifier
                    .noRippleClickable(onChevronClick),
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0x12121212)
@Composable
private fun MixUpBarPreview() {
    MixUpTopBar(
        onSearchClick = {},
        onChevronClick = {},
        modifier = Modifier.size(width = 320.dp, height = 30.dp),
    )
}
