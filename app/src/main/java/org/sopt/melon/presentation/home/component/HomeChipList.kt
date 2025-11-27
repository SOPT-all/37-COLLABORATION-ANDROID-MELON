package org.sopt.melon.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import org.sopt.melon.core.designsystem.theme.MELONTheme

@Composable
fun HomeChipList(
    chipContentList: ImmutableList<String>,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier =
            modifier
                .horizontalScroll(rememberScrollState())
                .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        chipContentList.forEachIndexed { index, content ->
            HomeChip(
                content = content,
                status = if (index == 0) ChipStatus.SELECTED else ChipStatus.DEFAULT,
            )
        }
    }
}

@Composable
private fun HomeChip(
    content: String,
    status: ChipStatus,
    modifier: Modifier = Modifier,
) {
    val style = status.getStyle()

    Text(
        text = content,
        style = MELONTheme.typography.body.r_14,
        color = style.contentColor,
        modifier =
            modifier
                .clip(shape = RoundedCornerShape(32.dp))
                .background(style.backgroundColor)
                .border(
                    width = 0.5.dp,
                    color = style.borderColor,
                    shape = RoundedCornerShape(32.dp),
                )
                .padding(horizontal = 20.dp, vertical = 8.dp),
    )
}

data class ChipStyle(
    val contentColor: Color,
    val backgroundColor: Color,
    val borderColor: Color,
)

enum class ChipStatus {
    SELECTED,
    DEFAULT,
    ;

    @Composable
    fun getStyle(): ChipStyle =
        when (this) {
            DEFAULT ->
                ChipStyle(
                    contentColor = MELONTheme.colors.gray100,
                    backgroundColor = Color.Transparent,
                    borderColor = MELONTheme.colors.gray400,
                )

            SELECTED ->
                ChipStyle(
                    contentColor = MELONTheme.colors.gray100,
                    backgroundColor = MELONTheme.colors.primary,
                    borderColor = MELONTheme.colors.primary,
                )
        }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
private fun DefaultHomeChipPreview() {
    MELONTheme {
        HomeChip(
            content = "우하핳하",
            status = ChipStatus.DEFAULT,
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
private fun SelectedHomeChipPreview() {
    MELONTheme {
        HomeChip(
            content = "chip",
            status = ChipStatus.SELECTED,
        )
    }
}

@Preview
@Composable
private fun HomeChipListPreview() {
    MELONTheme {
        HomeChipList(
            chipContentList =
                persistentListOf(
                    "안녕",
                    "하이하이",
                ),
        )
    }
}
