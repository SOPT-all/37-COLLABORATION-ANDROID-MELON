package org.sopt.melon.presentation.foryou.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.melon.R.drawable.img_mixup_card
import org.sopt.melon.R.string.foryou_preference_button
import org.sopt.melon.core.designsystem.theme.MELONTheme

@Composable
fun ForYouPreferenceCard(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
    ) {
        Image(
            painter = painterResource(img_mixup_card),
            contentDescription = null,
            modifier = Modifier
                .aspectRatio(320 / 204f),
        )

        Box(
            modifier = Modifier
                .padding(
                    start = 15.dp,
                    end = 15.dp,
                    bottom = 15.dp,
                )
                .fillMaxWidth()
                .border(
                    width = 0.3.dp,
                    color = MELONTheme.colors.gray200,
                    shape = RoundedCornerShape(4.dp),
                )
                .padding(
                    top = 10.dp,
                    bottom = 9.dp,
                )
                .align(alignment = Alignment.BottomCenter),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = stringResource(foryou_preference_button),
                color = MELONTheme.colors.white,
                style = MELONTheme.typography.body.r_14,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ForYouPreferenceCardPreview() {
    MELONTheme {
        ForYouPreferenceCard()
    }
}
