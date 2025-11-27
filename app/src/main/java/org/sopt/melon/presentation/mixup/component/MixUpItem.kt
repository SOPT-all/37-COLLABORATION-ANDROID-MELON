package org.sopt.melon.presentation.mixup.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import org.sopt.melon.R
import org.sopt.melon.core.designsystem.theme.MELONTheme
import org.sopt.melon.presentation.mixup.model.MixUpMusicInfo

@Composable
fun MixUpItem(
    mixUpMusicInfo: MixUpMusicInfo,
    isSelected: Boolean,
    onSelectClick: () -> Unit,
    draggableModifier: Modifier = Modifier,
    modifier: Modifier = Modifier,
    isPlaying: Boolean = false,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
    ) {
        MixUpCheckBox(
            isSelected = isSelected,
            onSelectClick = onSelectClick,
            modifier = Modifier.size(24.dp),
        )

        Spacer(Modifier.width(10.dp))

        Music(
            mixUpMusicInfo = mixUpMusicInfo,
            isPlaying = isPlaying,
            modifier = Modifier.weight(1f),
        )

        Spacer(Modifier.width(27.dp))

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_menu),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = draggableModifier,
        )
    }
}

@Composable
private fun Music(
    mixUpMusicInfo: MixUpMusicInfo,
    isPlaying: Boolean,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier =
                Modifier
                    .wrapContentSize()
                    .clip(RoundedCornerShape(4.dp)),
        ) {
            AsyncImage(
                model = mixUpMusicInfo.imageUrl,
                error = painterResource(R.drawable.img_chart1_42),
                contentDescription = null,
                modifier =
                    Modifier
                        .size(42.dp),
                contentScale = ContentScale.Crop,
            )

            if (isPlaying) {
                Box(
                    modifier =
                        Modifier
                            .size(42.dp)
                            .background(MELONTheme.colors.opacity2),
                )
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_playing),
                    contentDescription = null,
                    tint = Color.Unspecified,
                )
            }
        }

        Spacer(Modifier.size(10.dp))

        Column(
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = mixUpMusicInfo.title,
                style = MELONTheme.typography.body.m_14,
                color = if (isPlaying) MELONTheme.colors.primary else MELONTheme.colors.white,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )

            Text(
                text = mixUpMusicInfo.artistName,
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
private fun MixUpItemPreview() {
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
            mixUpMusicInfo =
                MixUpMusicInfo(
                    id = 0,
                    imageUrl = "TODO()",
                    title = "Blue Valentine",
                    artistName = "NMIXX",
                    isPlaying = false,
                ),
            isPlaying = isPlaying,
            isSelected = isSelected,
            onSelectClick = { isSelected = !isSelected },
            modifier = Modifier.size(width = 320.dp, height = 42.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MusicPreview() {
    Music(
        mixUpMusicInfo =
            MixUpMusicInfo(
                id = 1,
                imageUrl = "TODO()",
                title = "Blue Valentine",
                artistName = "NMIXX",
                isPlaying = false,
            ),
        isPlaying = true,
        modifier = Modifier,
    )
}
