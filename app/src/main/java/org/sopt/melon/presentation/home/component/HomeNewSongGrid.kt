package org.sopt.melon.presentation.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import org.sopt.melon.R
import org.sopt.melon.core.designsystem.theme.MELONTheme
import org.sopt.melon.presentation.home.model.NewSongItemData

@Composable
fun HomeNewSongGrid(
    newSongList: ImmutableList<NewSongItemData>,
    modifier: Modifier = Modifier,
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier.height(296.dp),
    ) {
        items(newSongList) {
            NewSongItem(
                data = it,
            )
        }
    }
}

@Composable
private fun NewSongItem(
    data: NewSongItemData,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.width(86.dp),
    ) {
        AsyncImage(
            model = data.imageUrl,
            contentDescription = null,
            error = painterResource(R.drawable.img_new1_90),
            contentScale = ContentScale.Crop,
            modifier =
                Modifier
                    .aspectRatio(1f)
                    .clip(shape = RoundedCornerShape(6.dp)),
        )

        Spacer(Modifier.height(4.dp))

        Text(
            text = data.songTitle,
            style = MELONTheme.typography.caption.r_12,
            color = MELONTheme.colors.white,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
        )

        Text(
            text = data.singer,
            style = MELONTheme.typography.caption.m_10,
            color = MELONTheme.colors.gray200,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
private fun NewSongItemPreview() {
    MELONTheme {
        NewSongItem(
            data =
                NewSongItemData(
                    imageUrl = "TODO()",
                    songTitle = "Back to Life",
                    singer = "&TEAM",
                ),
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
private fun HomeNewSongGridPreview() {
    MELONTheme {
        HomeNewSongGrid(
            newSongList =
                persistentListOf(
                    NewSongItemData(
                        imageUrl = "TODO()",
                        songTitle = "Back to Life",
                        singer = "&TEAM",
                    ),
                    NewSongItemData(
                        imageUrl = "TODO()",
                        songTitle = "Back to Life",
                        singer = "&TEAM",
                    ),
                    NewSongItemData(
                        imageUrl = "TODO()",
                        songTitle = "Back to Life",
                        singer = "&TEAM",
                    ),
                    NewSongItemData(
                        imageUrl = "TODO()",
                        songTitle = "Back to Life",
                        singer = "&TEAM",
                    ),
                    NewSongItemData(
                        imageUrl = "TODO()",
                        songTitle = "Back to Life",
                        singer = "&TEAM",
                    ),
                    NewSongItemData(
                        imageUrl = "TODO()",
                        songTitle = "Back to Life",
                        singer = "&TEAM",
                    ),
                    NewSongItemData(
                        imageUrl = "TODO()",
                        songTitle = "Back to Life",
                        singer = "&TEAM",
                    ),
                    NewSongItemData(
                        imageUrl = "TODO()",
                        songTitle = "Back to Life",
                        singer = "&TEAM",
                    ),
                    NewSongItemData(
                        imageUrl = "TODO()",
                        songTitle = "Back to Life",
                        singer = "&TEAM",
                    ),
                    NewSongItemData(
                        imageUrl = "TODO()",
                        songTitle = "Back to Life",
                        singer = "&TEAM",
                    ),
                    NewSongItemData(
                        imageUrl = "TODO()",
                        songTitle = "Back to Life",
                        singer = "&TEAM",
                    ),
                ),
        )
    }
}
