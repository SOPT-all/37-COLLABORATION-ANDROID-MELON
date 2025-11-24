package org.sopt.melon.presentation.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import org.sopt.melon.R
import org.sopt.melon.core.designsystem.theme.MELONTheme
import org.sopt.melon.presentation.home.model.MelonChartItemData

@Composable
fun HomeMelonChartGrid(
    melonChartList: ImmutableList<MelonChartItemData>,
    gridState: LazyGridState,
    modifier: Modifier = Modifier,
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(4),
        modifier = modifier.height(216.dp),
        state = gridState,
        contentPadding = PaddingValues(horizontal = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(27.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        itemsIndexed(melonChartList) { index, song ->
            MelonChartItem(
                ranking = index + 1,
                imgUrl = song.imgUrl,
                title = song.title,
                singer = song.singer,
                modifier = Modifier.width(262.dp),
            )
        }
    }
}

@Composable
private fun MelonChartItem(
    ranking: Int,
    imgUrl: String,
    title: String,
    singer: String,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
    ) {
        AsyncImage(
            model = imgUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            error = painterResource(R.drawable.img_chart1_42),
            modifier =
                Modifier
                    .size(42.dp)
                    .clip(shape = RoundedCornerShape(4.dp)),
        )

        Spacer(Modifier.width(16.dp))

        Column {
            Text(
                text = ranking.toString(),
                style = MELONTheme.typography.body.r_14,
                color = MELONTheme.colors.white,
            )

            Text(
                text = "-",
                style = MELONTheme.typography.caption.r_12,
                color = MELONTheme.colors.gray300,
            )
        }

        Spacer(Modifier.width(12.dp))

        Column(
            modifier = Modifier.weight(1f),
        ) {
            Text(
                text = title,
                style = MELONTheme.typography.body.r_14,
                color = MELONTheme.colors.white,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )

            Text(
                text = singer,
                style = MELONTheme.typography.caption.r_12,
                color = MELONTheme.colors.gray300,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }

        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_play_20),
            contentDescription = null,
            tint = Color.Unspecified,
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
private fun HomeMelonChartGridPreview() {
    HomeMelonChartGrid(
        melonChartList = persistentListOf(
            MelonChartItemData(
                imgUrl = "TODO()",
                title = "Blue Valentine",
                singer = "NMIXX",
            ),
            MelonChartItemData(
                imgUrl = "TODO()",
                title = "Blue Valentine",
                singer = "NMIXX",
            ),
            MelonChartItemData(
                imgUrl = "TODO()",
                title = "Blue Valentine",
                singer = "NMIXX",
            ),
            MelonChartItemData(
                imgUrl = "TODO()",
                title = "Blue Valentine",
                singer = "NMIXX",
            ),
            MelonChartItemData(
                imgUrl = "TODO()",
                title = "Blue Valentine",
                singer = "NMIXX",
            ),
            MelonChartItemData(
                imgUrl = "TODO()",
                title = "Blue Valentine",
                singer = "NMIXX",
            ),
            MelonChartItemData(
                imgUrl = "TODO()",
                title = "Blue Valentine",
                singer = "NMIXX",
            ),
            MelonChartItemData(
                imgUrl = "TODO()",
                title = "Blue Valentine",
                singer = "NMIXX",
            ),
            ),
        gridState = rememberLazyGridState(),
    )
}
