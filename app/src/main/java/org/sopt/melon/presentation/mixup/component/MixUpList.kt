package org.sopt.melon.presentation.mixup.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.melon.R
import org.sopt.melon.core.designsystem.theme.MELONTheme
import org.sopt.melon.presentation.mixup.data.MusicInfo

@Composable
fun MixUpList(
    musicInfos: List<MusicInfo>,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
    ) {
        Text(
            text = "믹스업 목록",
            style = MELONTheme.typography.body.sb_16,
            color = MELONTheme.colors.white,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        LazyColumn(
            contentPadding = PaddingValues(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
        ) {
            items(8) { index ->
                MixUpItem(
                    musicInfo = musicInfos[index],
                    isPlaying = musicInfos[index].isPlaying,
                    isSelected = musicInfos[index].isSelected,
                    onSelectClick = {},
                    onMenuClick = {},
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0x121212)
@Composable
fun MixUpListPreview() {
    MixUpList(
        musicInfos = listOf(
            MusicInfo(
                image = R.drawable.img_chart1_42,
                title = "Blue Valentine",
                singer = "NMIXX",
                isPlaying = true,
                isSelected = false,
            ),
            MusicInfo(
                image = R.drawable.img_chart1_42,
                title = "Blue Valentine",
                singer = "NMIXX",
                isPlaying = false,
                isSelected = true
            ),
            MusicInfo(
                image = R.drawable.img_chart1_42,
                title = "Blue Valentine",
                singer = "NMIXX",
                isPlaying = true,
                isSelected = true,
            ),
            MusicInfo(
                image = R.drawable.img_chart1_42,
                title = "Blue Valentine",
                singer = "NMIXX",
                isPlaying = true,
                isSelected = false,
            ),
            MusicInfo(
                image = R.drawable.img_chart1_42,
                title = "Blue Valentine",
                singer = "NMIXX",
                isPlaying = false,
                isSelected = true,
            ),
            MusicInfo(
                image = R.drawable.img_chart1_42,
                title = "Blue Valentine",
                singer = "NMIXX",
                isPlaying = true,
                isSelected = true
            ),
            MusicInfo(
                image = R.drawable.img_chart1_42,
                title = "Blue Valentine",
                singer = "NMIXX",
                isPlaying = false,
                isSelected = true
            ),
            MusicInfo(
                image = R.drawable.img_chart1_42,
                title = "Blue Valentine",
                singer = "NMIXX",
                isPlaying = false,
                isSelected = false,
            ),
            MusicInfo(
                image = R.drawable.img_chart1_42,
                title = "Blue Valentine",
                singer = "NMIXX",
                isPlaying = true,
                isSelected = true
            ),
        ),
        modifier = Modifier.size(width = 320.dp, height = 372.dp)
    )
}
