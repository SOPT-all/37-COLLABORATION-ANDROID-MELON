package org.sopt.melon.presentation.home.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import org.sopt.melon.R
import org.sopt.melon.core.designsystem.theme.MELONTheme

@Composable
fun HomeChartTitle(
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier =
            modifier
                .padding(
                    horizontal = 20.dp,
                ),
    ) {
        Column {
            Text(
                text = stringResource(R.string.home_melon_chart_description),
                style = MELONTheme.typography.body.r_14,
                color = MELONTheme.colors.gray200,
            )

            Spacer(Modifier.height(2.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = stringResource(R.string.home_melon_chart_title),
                    style = MELONTheme.typography.heading.b_20,
                    color = MELONTheme.colors.white,
                )

                Spacer(Modifier.width(4.dp))

                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_bar),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier =
                        Modifier
                            .size(24.dp),
                )
            }
        }

        Spacer(Modifier.weight(1f))

        Text(
            text = stringResource(R.string.home_title_all),
            style = MELONTheme.typography.body.m_14,
            color = MELONTheme.colors.gray200,
        )
    }
}
