package org.sopt.melon.presentation.foryou.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.melon.R.drawable.img_malang_card
import org.sopt.melon.R.drawable.img_mixup_24
import org.sopt.melon.R.string.foryou_recommend_button
import org.sopt.melon.core.common.util.noRippleClickable
import org.sopt.melon.core.designsystem.theme.MELONTheme

@Composable
fun ForYouMalangCard(
    onMixUpClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(
                shape = RoundedCornerShape(8.dp),
            ),
    ) {
        Image(
            painter = painterResource(img_malang_card),
            contentDescription = null,
            modifier = Modifier
                .aspectRatio(1f),
        )

        Row(
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 12.dp,
                    bottom = 14.dp,
                )
                .fillMaxWidth()
                .background(
                    color = MELONTheme.colors.white,
                    shape = RoundedCornerShape(8.dp),
                )
                .padding(
                    vertical = 4.dp,
                )
                .noRippleClickable(onClick = onMixUpClick)
                .align(alignment = Alignment.BottomCenter),
            horizontalArrangement = Arrangement
                .spacedBy(
                    space = 2.dp,
                    alignment = Alignment.CenterHorizontally,
                ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(img_mixup_24),
                contentDescription = null,
                modifier = Modifier
                    .padding(vertical = 4.dp)
                    .size(32.dp),
            )

            Text(
                text = stringResource(foryou_recommend_button),
                color = MELONTheme.colors.background,
                style = MELONTheme.typography.body.b_14,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ForYouMalangPreview() {
    MELONTheme {
        ForYouMalangCard(
            onMixUpClick = {},
        )
    }
}
