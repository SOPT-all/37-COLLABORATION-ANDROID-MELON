package org.sopt.melon.presentation.mixup.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import org.sopt.melon.presentation.mixup.data.MusicInfo

@Composable
fun MixUpPlayingMusic(
    musicInfo: MusicInfo,
    onAddAllClick: () -> Unit,
    isAllSelected: Boolean,
    onAllSelectClick: () -> Unit,
    isCurrentMusicSelected: Boolean,
    onSelectClick: () -> Unit,
    onMenuClick: () -> Unit,
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
        Row {
            MixUpCheckBox(
                isSelected = isAllSelected,
                onSelectClick = onAllSelectClick,
            )

            Text(
                text = "전체선택",
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
            onMenuClick = onMenuClick,
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
            text = "재생 중인 곡",
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
fun AllSelectButton(
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
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.ic_plus),
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
fun MixUpPlayingMusicPreview() {
    MixUpPlayingMusic(
        musicInfo =
            MusicInfo(
                image = R.drawable.img_chart1_42,
                title = "Blue Valentine",
                singer = "NMIXX",
                isPlaying = false,
                isSelected = true,
            ),
        onAddAllClick = {},
        isAllSelected = true,
        onAllSelectClick = {},
        isCurrentMusicSelected = false,
        onSelectClick = {},
        onMenuClick = {},
        modifier = Modifier.size(width = 320.dp, height = 120.dp),
    )
}
