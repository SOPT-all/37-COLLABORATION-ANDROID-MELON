package org.sopt.melon.presentation.foryou.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.ImmutableList
import org.sopt.melon.core.common.util.noRippleClickable
import org.sopt.melon.core.designsystem.theme.MELONTheme
import org.sopt.melon.presentation.foryou.model.ForYouRecommendationData

@Composable
fun ForYouTodayChipContent(
    title: String,
    recommendationList: ImmutableList<ForYouRecommendationData>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        Text(
            text = title,
            style = MELONTheme.typography.caption.r_12,
            color = MELONTheme.colors.gray300,
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            recommendationList.forEach { data ->
                ForYouChip(
                    label = data.label,
                    isChipSelected = data.isSelected,
                    imageRes = data.imageRes,
                )
            }
        }
    }
}

@Composable
private fun ForYouChip(
    label: String,
    isChipSelected: Boolean,
    modifier: Modifier = Modifier,
    @DrawableRes imageRes: Int? = null,
) {
    var isSelected by rememberSaveable { mutableStateOf(isChipSelected) }

    val (backgroundColor, borderColor) = if (isSelected)
        MELONTheme.colors.secondary to MELONTheme.colors.primary
    else Color.Transparent to MELONTheme.colors.gray400

    val horizontalPadding = if (imageRes == null) PaddingValues(
        horizontal = 16.dp,
    ) else PaddingValues(
        start = 4.dp,
        end = 12.dp,
    )

    Row(
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(24.dp),
            )
            .border(
                width = 0.3.dp,
                color = borderColor,
                shape = RoundedCornerShape(24.dp),
            )
            .padding(horizontalPadding)
            .noRippleClickable({ isSelected = !isSelected }),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement
            .spacedBy(
                space = 8.dp,
                alignment = Alignment.CenterHorizontally,
            ),
    ) {
        imageRes?.let {
            Image(
                painter = painterResource(it),
                contentDescription = null,
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape),
            )
        }

        Text(
            text = label,
            style = MELONTheme.typography.body.m_14,
            color = MELONTheme.colors.white,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(
                    vertical = 11.5.dp,
                ),
        )
    }
}
