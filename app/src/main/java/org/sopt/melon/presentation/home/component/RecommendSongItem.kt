package org.sopt.melon.presentation.home.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import org.sopt.melon.core.designsystem.theme.MELONTheme
import org.sopt.melon.presentation.home.model.RecommendSongItemData

@Composable
fun RecommendSongItem(
    data: RecommendSongItemData,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.width(140.dp),
    ) {
        AsyncImage(
            model = data.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .aspectRatio(1f)
                .clip(shape = RoundedCornerShape(6.dp)),
        )
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
private fun RecommendSongItemPreview() {
    RecommendSongItem(
        data = RecommendSongItemData(
            imageUrl = "TODO()",
            description = "내가 아끼는 최애곡 모아모아모아모아모아모아",
        ),
    )
}
