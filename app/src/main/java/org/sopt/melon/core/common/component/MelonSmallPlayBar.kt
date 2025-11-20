package org.sopt.melon.core.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.melon.core.designsystem.theme.MELONTheme
import org.sopt.melon.core.designsystem.theme.PretendardFont
import org.sopt.melon.core.designsystem.theme.defaultMelonColors

@Composable
fun MelonSmallPlayBar(
    title: String,
    singer: String,
    progressRatio: Float,
    isPlaying: Boolean,
    onBackClick: () -> Unit,
    onPlayPauseClick: (Boolean) -> Unit,
    onFrontClick: () -> Unit,
    onPlayMenuClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier =
            modifier
                .background(color = defaultMelonColors.background2),
    ) {
        MelonProgressBar(
            progressRatio = progressRatio,
            modifier = Modifier.fillMaxWidth()
        )

        Row() {
            // title & singer



            // Control Bar
        }
    }
}

@Preview
@Composable
private fun SongInfoPreview() {
    SongInfo(
        title = "Blue Valentine",
        singer = "NMIXX",
        modifier = Modifier
    )
}
@Composable
private fun SongInfo(
    title: String,
    singer: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = title,
            style = MELONTheme.typography.body.m_14,
            color = MELONTheme.colors.white,
            modifier = Modifier,
        )
        Text(
            text = singer,
            style = MELONTheme.typography.caption.r_12,
            color = MELONTheme.colors.gray300,
            modifier = Modifier,
        )
    }
}
