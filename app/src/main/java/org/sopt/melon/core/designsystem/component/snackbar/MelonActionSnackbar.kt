package org.sopt.melon.core.designsystem.component.snackbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.melon.core.common.util.noRippleClickable
import org.sopt.melon.core.designsystem.theme.MELONTheme

@Composable
fun MelonActionSnackbar(
    message: String,
    actionLabel: String,
    action: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier =
            modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(size = 4.dp))
                .background(color = MELONTheme.colors.neonPink)
                .padding(vertical = 14.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = message,
            style = MELONTheme.typography.body.m_14,
            color = MELONTheme.colors.white,
        )

        Text(
            text = actionLabel,
            style = MELONTheme.typography.body.r_14,
            color = MELONTheme.colors.white,
            modifier =
                Modifier
                    .noRippleClickable(onClick = action),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MelonActionSnackbarPreview() {
    MELONTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            MelonActionSnackbar(
                message = "믹스업에 추가되었어요",
                actionLabel = "이동",
                action = {},
                modifier = Modifier.padding(16.dp),
            )
        }
    }
}
