package org.sopt.melon.presentation.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import org.sopt.melon.R
import org.sopt.melon.core.designsystem.theme.MELONTheme
import org.sopt.melon.presentation.home.model.RecommendSongItemData

@Composable
fun HomeRecommendList(
    recommendSongList: List<RecommendSongItemData>,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        items(recommendSongList) {
            RecommendSongItem(
                data = it,
            )
        }
    }
}

@Composable
private fun RecommendSongItem(
    data: RecommendSongItemData,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.width(140.dp),
    ) {
        Box {
            AsyncImage(
                model = data.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier =
                    Modifier
                        .aspectRatio(1f)
                        .clip(shape = RoundedCornerShape(6.dp)),
            )
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_play_28),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier
                    .size(32.dp)
                    .padding(top = 4.dp)
                    .align(Alignment.TopEnd),
            )
        }
        Spacer(Modifier.height(4.dp))
        Text(
            data.description,
            style = MELONTheme.typography.body.m_14,
            color = MELONTheme.colors.white,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
private fun HomeRecommendListPreview() {
    MELONTheme {
        HomeRecommendList(
            recommendSongList = listOf(
                RecommendSongItemData(
                    imageUrl = "TODO()",
                    description = "내가 아끼는 최애곡 모음",
                ),
                RecommendSongItemData(
                    imageUrl = "TODO()",
                    description = "내가 아끼는 최애곡 모음",
                ),
                RecommendSongItemData(
                    imageUrl = "TODO()",
                    description = "내가 아끼는 최애곡 모음",
                ),
            ),
        )
    }
}
