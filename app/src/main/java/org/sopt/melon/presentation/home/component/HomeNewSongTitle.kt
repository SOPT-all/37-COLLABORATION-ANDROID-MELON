package org.sopt.melon.presentation.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.melon.core.designsystem.theme.MELONTheme

@Composable
fun HomeNewSongTitle(
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier =
            modifier
                .padding(horizontal = 20.dp),
    ) {
        Text(
            text = "최신음악",
            style = MELONTheme.typography.heading.b_20,
            color = MELONTheme.colors.white,
        )

        Spacer(Modifier.width(8.dp))

        FilterTab()

        Spacer(Modifier.weight(1f))

        Text(
            text = "전체보기",
            style = MELONTheme.typography.body.m_14,
            color = MELONTheme.colors.gray200,
        )
    }
}

@Composable
private fun FilterTab() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        Text(
            text = "전체",
            style = MELONTheme.typography.body.sb_16,
            color = MELONTheme.colors.primary,
        )

        Text(
            text = "|",
            style = MELONTheme.typography.caption.r_12,
            color = MELONTheme.colors.gray400,
        )

        Text(
            text = "국내",
            style = MELONTheme.typography.body.m_14,
            color = MELONTheme.colors.gray200,
        )

        Text(
            text = "|",
            style = MELONTheme.typography.caption.r_12,
            color = MELONTheme.colors.gray400,
        )

        Text(
            text = "해외",
            style = MELONTheme.typography.body.m_14,
            color = MELONTheme.colors.gray200,
        )
    }
}

@Preview
@Composable
private fun HomeNewSongTitlePreview() {
    MELONTheme {
        HomeNewSongTitle()
    }
}
