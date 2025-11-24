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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.melon.R
import org.sopt.melon.core.common.util.noRippleClickable
import org.sopt.melon.core.designsystem.theme.MELONTheme
import org.sopt.melon.presentation.home.type.NewSongFilter

@Composable
fun HomeNewSongTitle(
    selectedNewSongFilter: NewSongFilter,
    onFilterClick: (NewSongFilter) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier =
            modifier
                .padding(horizontal = 20.dp),
    ) {
        Text(
            text = stringResource(R.string.home_new_song_title),
            style = MELONTheme.typography.heading.b_20,
            color = MELONTheme.colors.white,
        )

        Spacer(Modifier.width(8.dp))

        FilterTab(
            selectedNewSongFilter = selectedNewSongFilter,
            onFilterClick = onFilterClick,
        )

        Spacer(Modifier.weight(1f))

        Text(
            text = stringResource(R.string.home_title_all),
            style = MELONTheme.typography.body.m_14,
            color = MELONTheme.colors.gray200,
        )
    }
}

@Composable
private fun FilterTab(
    selectedNewSongFilter: NewSongFilter,
    onFilterClick: (NewSongFilter) -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        NewSongFilter.entries.forEachIndexed { index, filter ->
            val isSelected = filter == selectedNewSongFilter
            Text(
                text = filter.displayName,
                style = if (isSelected) MELONTheme.typography.body.sb_16 else MELONTheme.typography.body.m_14,
                color = if (isSelected) MELONTheme.colors.primary else MELONTheme.colors.gray200,
                modifier = Modifier.noRippleClickable { onFilterClick(filter) },
            )

            if (index != NewSongFilter.entries.lastIndex) {
                Text(
                    text = "|",
                    style = MELONTheme.typography.caption.r_12,
                    color = MELONTheme.colors.gray400,
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
private fun HomeNewSongTitlePreview() {
    MELONTheme {
        HomeNewSongTitle(
            selectedNewSongFilter = NewSongFilter.ALL,
            onFilterClick = {},
        )
    }
}
