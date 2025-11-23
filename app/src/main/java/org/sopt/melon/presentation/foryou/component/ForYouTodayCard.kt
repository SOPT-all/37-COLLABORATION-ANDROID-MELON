package org.sopt.melon.presentation.foryou.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.ImmutableList
import org.sopt.melon.R.drawable.ic_refresh
import org.sopt.melon.R.string.foryou_my_preference_label
import org.sopt.melon.R.string.foryou_reload_label
import org.sopt.melon.R.string.foryou_situation_label
import org.sopt.melon.R.string.foryou_today_recommend_title
import org.sopt.melon.core.designsystem.theme.MELONTheme
import org.sopt.melon.presentation.foryou.model.ForYouRecommendationData

@Composable
fun ForYouTodayCard(
    myPreferenceList: ImmutableList<ForYouRecommendationData>,
    situationList: ImmutableList<ForYouRecommendationData>,
    modifier: Modifier = Modifier,
) {
    val colors = MELONTheme.colors

    Column(
        modifier =
            modifier
                .fillMaxWidth()
                .drawWithCache {
                    onDrawBehind {
                        val borderWidth = 1.dp.toPx()
                        val radius = 8.dp.toPx()

                        drawRoundRect(
                            brush = colors.gradient3,
                            cornerRadius = CornerRadius(radius, radius),
                        )

                        drawRoundRect(
                            brush = colors.gradientLine,
                            cornerRadius = CornerRadius(radius, radius),
                            topLeft = Offset(borderWidth / 2, borderWidth / 2),
                            size =
                                Size(
                                    width = size.width - borderWidth,
                                    height = size.height - borderWidth,
                                ),
                            style = Stroke(borderWidth),
                        )
                    }
                },
    ) {
        Row(
            modifier =
                Modifier
                    .padding(
                        top = 17.5.dp,
                        start = 12.dp,
                        end = 12.dp,
                        bottom = 22.5.dp,
                    ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.SpaceBetween,
        ) {
            Text(
                text = stringResource(foryou_today_recommend_title),
                style = MELONTheme.typography.heading.b_20,
                color = MELONTheme.colors.white,
            )

            Spacer(modifier = Modifier.weight(1f))

            Image(
                imageVector = ImageVector.vectorResource(ic_refresh),
                contentDescription = null,
                modifier =
                    Modifier
                        .padding(
                            end = 4.dp,
                        ).size(16.dp),
            )

            Text(
                text = stringResource(foryou_reload_label),
                style = MELONTheme.typography.caption.r_12,
                color = MELONTheme.colors.gray200,
            )
        }

        ForYouTodayChipContent(
            title = stringResource(foryou_my_preference_label),
            recommendationList = myPreferenceList,
            modifier =
                Modifier
                    .padding(
                        start = 12.dp,
                        bottom = 16.dp,
                    ),
        )

        ForYouTodayChipContent(
            title = stringResource(foryou_situation_label),
            recommendationList = situationList,
            modifier =
                Modifier
                    .padding(
                        start = 12.dp,
                        bottom = 19.dp,
                    ),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ForYouTodayCardPreview() {
    MELONTheme {
        Box(
            modifier =
                Modifier
                    .background(MELONTheme.colors.background)
                    .padding(horizontal = 20.dp)
                    .fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            ForYouTodayCard(
                myPreferenceList = ForYouRecommendationData.dummyMyPreferenceData,
                situationList = ForYouRecommendationData.dummySituationData,
            )
        }
    }
}
