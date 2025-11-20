package org.sopt.melon.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import org.sopt.melon.R.string.snackbar_mixup_add_message
import org.sopt.melon.R.string.snackbar_move_action_label
import org.sopt.melon.core.common.util.noRippleClickable
import org.sopt.melon.core.designsystem.component.snackbar.LocalMelonSnackbarTrigger
import org.sopt.melon.core.designsystem.component.snackbar.MelonSnackbarRequest

@Composable
fun HomeRoute(
    innerPadding: PaddingValues,
    navigateToMixUp: () -> Unit,
) {
    val snackbarTrigger = LocalMelonSnackbarTrigger.current
    val snackbarRequest = MelonSnackbarRequest(
        message = stringResource(snackbar_mixup_add_message),
        actionLabel = stringResource(snackbar_move_action_label),
        onClick = navigateToMixUp,
    )

    HomeScreen(
        onMixUpClick = { snackbarTrigger(snackbarRequest) },
        modifier =
            Modifier
                .padding(innerPadding),
    )
}

@Composable
private fun HomeScreen(
    onMixUpClick: () -> Unit = {},
    modifier: Modifier = Modifier,
) {
    Column(
        modifier =
            modifier
                .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            "HOME",
            color = Color.White,
            modifier = Modifier
                .noRippleClickable(
                    onClick = onMixUpClick,
                ),
        )
    }
}
