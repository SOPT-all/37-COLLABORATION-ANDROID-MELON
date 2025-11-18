package org.sopt.melon.presentation.home.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import org.sopt.melon.core.designsystem.theme.MELONTheme
import org.sopt.melon.presentation.home.model.SelectionItemData

@Composable
fun SelectionItem(
    data: SelectionItemData,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.height(56.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = data.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .aspectRatio(1f)
                .clip(shape = RoundedCornerShape(6.dp))
        )
        Spacer(Modifier.width(12.dp))
        Column {
            Text(
                data.label,
                style = MELONTheme.typography.caption.r_12,
                color = MELONTheme.colors.gray200,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                data.songTitle,
                style = MELONTheme.typography.body.r_14,
                color = MELONTheme.colors.white,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                data.label,
                style = MELONTheme.typography.caption.r_12,
                color = MELONTheme.colors.gray200,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
private fun SelectionItemPreview() {
    MELONTheme {
        SelectionItem(
            data = SelectionItemData(
                imageUrl = "TODO()",
                label = "멜론DJ’s Pick",
                songTitle = "XOXZ",
                singer = "IVE (아이브)"
            )
        )
    }
}
