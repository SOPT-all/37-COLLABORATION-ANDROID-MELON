package org.sopt.melon.presentation.mixup.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.melon.R
import org.sopt.melon.core.common.util.noRippleClickable
import org.sopt.melon.core.designsystem.theme.MELONTheme
import org.sopt.melon.presentation.mixup.model.MusicInfo

@Composable
fun MixUpItem(
    musicInfo: MusicInfo,
    isPlaying: Boolean,
    isSelected: Boolean,
    onSelectClick: () -> Unit,
    onMenuClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            MixUpCheckBox(
                isSelected = isSelected,
                onSelectClick = onSelectClick,
                modifier = Modifier.size(24.dp),
            )

            Spacer(Modifier.size(10.dp))

            Music(
                musicInfo = musicInfo,
                isPlaying = isPlaying,
            )
        }

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_menu),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.noRippleClickable(onMenuClick),
        )
    }
}

@Composable
private fun Music(
    musicInfo: MusicInfo,
    isPlaying: Boolean,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier =
                Modifier
                    .size(42.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .paint(painterResource(musicInfo.image),
                        contentScale = ContentScale.Crop),
        ) {
            if (isPlaying) {
                Box(
                    modifier =
                        Modifier
                            .fillMaxSize()
                            .background(MELONTheme.colors.opacity2),
                )
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_playing),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
            }
        }

        Spacer(Modifier.size(10.dp))

        Column(
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = musicInfo.title,
                style = MELONTheme.typography.body.m_14,
                color = if (isPlaying) MELONTheme.colors.primary else MELONTheme.colors.white,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = musicInfo.singer,
                style = MELONTheme.typography.caption.r_12,
                color = MELONTheme.colors.gray200,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0x121212)
@Composable
fun MixUpItemPreview() {
    var isPlaying by remember { mutableStateOf(false) }
    var isSelected by remember { mutableStateOf(false) }

    Column {
        Button(
            onClick = { isPlaying = !isPlaying },
        ) {
            Text("playing")
        }

        Spacer(Modifier.size(20.dp))

        MixUpItem(
            musicInfo =
                MusicInfo(
                    image = R.drawable.img_chart1_42,
                    title = "Blue Valentine",
                    singer = "NMIXX",
                    isPlaying = false,
                    isSelected = true,
                ),
            isPlaying = isPlaying,
            isSelected = isSelected,
            onSelectClick = { isSelected = !isSelected },
            onMenuClick = {},
            modifier = Modifier.size(width = 320.dp, height = 42.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MusicPreview() {
    Music(
        musicInfo =
            MusicInfo(
                image = R.drawable.img_chart1_42,
                title = "Blue Valentine",
                singer = "NMIXX",
                isPlaying = false,
                isSelected = false,
            ),
        isPlaying = true,
        modifier = Modifier,
    )
}
