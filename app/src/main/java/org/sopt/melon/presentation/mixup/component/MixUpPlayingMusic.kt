package org.sopt.melon.presentation.mixup.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.melon.R
import org.sopt.melon.core.common.util.noRippleClickable
import org.sopt.melon.core.designsystem.theme.MELONTheme
import org.sopt.melon.presentation.mixup.model.MusicInfo

@Composable
fun MixUpPlayingMusic(
    musicInfo: MusicInfo,
    onAddAllClick: () -> Unit,
    isAllSelected: Boolean,
    onAllSelectClick: () -> Unit,
    isCurrentMusicSelected: Boolean,
    onSelectClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        // top
        MixUpPlayingMusicTopBar(
            onAddAllClick = onAddAllClick,
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(Modifier.size(16.dp))

        // select all
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            MixUpCheckBox(
                isSelected = isAllSelected,
                onSelectClick = onAllSelectClick,
            )

            Spacer(Modifier.size(4.dp))

            Text(
                text = stringResource(R.string.mix_up_select_all),
                style = MELONTheme.typography.caption.r_12,
                color = MELONTheme.colors.white,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }

        Spacer(Modifier.size(12.dp))

        // current music
        MixUpItem(
            musicInfo = musicInfo,
            isPlaying = true,
            isSelected = isCurrentMusicSelected,
            onSelectClick = onSelectClick,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Composable
private fun MixUpPlayingMusicTopBar(
    onAddAllClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
    ) {
        Text(
            text = stringResource(R.string.mix_up_current_sing),
            style = MELONTheme.typography.body.sb_16,
            color = MELONTheme.colors.white,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )

        AllSelectButton(
            onAllSelectClick = onAddAllClick,
            modifier = Modifier,
        )
    }
}

@Composable
private fun AllSelectButton(
    onAllSelectClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier =
            modifier
                .noRippleClickable(onAllSelectClick)
                .border(
                    width = 0.5.dp,
                    color = MELONTheme.colors.gray300,
                    shape = RoundedCornerShape(4.dp),
                ).padding(start = 6.dp, end = 6.dp, top = 4.dp, bottom = 4.dp),
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_plus),
            tint = Color.Unspecified,
            contentDescription = null,
            modifier =
                Modifier
                    .size(16.dp),
        )

        Spacer(Modifier.size(4.dp))

        Text(
            text = "전체담기",
            style = MELONTheme.typography.caption.r_12,
            color = MELONTheme.colors.gray100,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier,
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0x121212)
@Composable
private fun MixUpPlayingMusicPreview() {
    MixUpPlayingMusic(
        musicInfo =
            MusicInfo(
                id = 0,
                imageUrl = "TODO()",
                title = "Blue Valentine",
                singer = "NMIXX",
                isPlaying = false,
            ),
        onAddAllClick = {},
        isAllSelected = true,
        onAllSelectClick = {},
        isCurrentMusicSelected = false,
        onSelectClick = {},
        modifier = Modifier.size(width = 320.dp, height = 120.dp),
    )
}
