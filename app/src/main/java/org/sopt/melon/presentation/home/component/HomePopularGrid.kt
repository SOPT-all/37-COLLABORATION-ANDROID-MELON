package org.sopt.melon.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import org.sopt.melon.R.drawable.img_home2_56
import org.sopt.melon.R.drawable.img_mixup_36
import org.sopt.melon.core.designsystem.theme.MELONTheme
import org.sopt.melon.presentation.home.model.PopularSongData

@Composable
fun HomePopularGrid(
    popularSongList: ImmutableList<PopularSongData>,
    gridState: LazyGridState,
    modifier: Modifier = Modifier,
    cellCount: Int = 3,
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(cellCount),
        modifier =
            modifier
                .height(203.dp),
        state = gridState,
        contentPadding = PaddingValues(horizontal = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(popularSongList) { song ->
            PopularSongItem(
                imgUrl = song.imgUrl,
                subtitle = song.subtitle,
                title = song.title,
                artistName = song.artistName,
            )
        }
    }
}

@Composable
private fun PopularSongItem(
    imgUrl: String,
    subtitle: String,
    title: String,
    artistName: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AsyncImage(
            model = imgUrl,
            contentScale = ContentScale.Crop,
            contentDescription = null,
            error = painterResource(img_home2_56),
            modifier =
                Modifier
                    .size(size = 56.dp)
                    .clip(RoundedCornerShape(6.dp)),
        )

        Column(
            modifier =
                Modifier
                    .padding(
                        start = 12.dp,
                        end = 24.dp,
                    ).width(138.dp),
        ) {
            Text(
                text = subtitle,
                style = MELONTheme.typography.caption.r_12,
                color = MELONTheme.colors.gray200,
            )

            Text(
                text = title,
                style = MELONTheme.typography.body.r_14,
                color = MELONTheme.colors.white,
            )

            Text(
                text = artistName,
                style = MELONTheme.typography.caption.r_12,
                color = MELONTheme.colors.gray200,
            )
        }

        Image(
            painter = painterResource(id = img_mixup_36),
            contentDescription = null,
            modifier =
                Modifier
                    .size(36.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HomePopularGridPreview() {
    MELONTheme {
        val list =
            persistentListOf(
                PopularSongData(
                    imgUrl = "",
                    subtitle = "멜론DJ's Pick",
                    title = "1XOXZ",
                    artistName = "IVE (아이브)",
                ),
                PopularSongData(
                    imgUrl = "",
                    subtitle = "멜론DJ's Pick",
                    title = "2XOXZ",
                    artistName = "IVE (아이브)",
                ),
                PopularSongData(
                    imgUrl = "",
                    subtitle = "멜론DJ's Pick",
                    title = "3XOXZ",
                    artistName = "Hearts2Hearts(하츠투하츠)",
                ),
                PopularSongData(
                    imgUrl = "",
                    subtitle = "멜론DJ's Pick",
                    title = "4XOXZ",
                    artistName = "IVE (아이브)",
                ),
                PopularSongData(
                    imgUrl = "",
                    subtitle = "멜론DJ's Pick",
                    title = "5XOXZ",
                    artistName = "IVE (아이브)",
                ),
                PopularSongData(
                    imgUrl = "",
                    subtitle = "멜론DJ's Pick",
                    title = "6XOXZ",
                    artistName = "IVE (아이브)",
                ),
            )
        Column(
            modifier =
                Modifier
                    .background(color = MELONTheme.colors.background)
                    .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            HomePopularGrid(
                popularSongList = list,
                gridState = rememberLazyGridState(),
            )
        }
    }
}
