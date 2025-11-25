package org.sopt.melon.presentation.foryou

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.sopt.melon.R.string.foryou
import org.sopt.melon.R.string.snackbar_mixup_add_message
import org.sopt.melon.R.string.snackbar_move_action_label
import org.sopt.melon.core.designsystem.component.snackbar.LocalMelonSnackbarTrigger
import org.sopt.melon.core.designsystem.component.snackbar.MelonSnackbarActionRequest
import org.sopt.melon.core.designsystem.theme.MELONTheme
import org.sopt.melon.presentation.foryou.component.ForYouCustomSongCard
import org.sopt.melon.presentation.foryou.component.ForYouMalangCard
import org.sopt.melon.presentation.foryou.component.ForYouNewestContent
import org.sopt.melon.presentation.foryou.component.ForYouPreferenceCard
import org.sopt.melon.presentation.foryou.component.ForYouTodayCard
import org.sopt.melon.presentation.foryou.model.ForYouRecommendationData

@Composable
fun ForYouRoute(
    innerPadding: PaddingValues,
    navigateToMixUp: () -> Unit,
    viewModel: ForYouViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val snackbarTrigger = LocalMelonSnackbarTrigger.current
    val snackbarRequest =
        MelonSnackbarActionRequest(
            message = stringResource(snackbar_mixup_add_message),
            actionLabel = stringResource(snackbar_move_action_label),
            onClick = navigateToMixUp,
        )

    LaunchedEffect(Unit) {
        viewModel.fetchCustomMusic()
        viewModel.fetchAlbum()
    }

    ForYouScreen(
        uiState = uiState,
        onMixUpClick = { snackbarTrigger(snackbarRequest) },
        modifier = Modifier.padding(innerPadding),
    )
}

@Composable
private fun ForYouScreen(
    uiState: ForYouUiState,
    onMixUpClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()

    Column(
        modifier =
            modifier
                .fillMaxSize()
                .verticalScroll(state = scrollState)
                .padding(
                    start = 20.dp,
                    top = 22.dp,
                    end = 20.dp,
                    bottom = 36.dp,
                ),
    ) {
        Text(
            text = stringResource(foryou),
            color = MELONTheme.colors.white,
            style = MELONTheme.typography.title.b_24,
            modifier =
                Modifier.padding(
                    bottom = 8.dp,
                ),
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(28.dp),
        ) {
            ForYouMalangCard(
                onMixUpClick = onMixUpClick,
            )

            ForYouPreferenceCard()

            ForYouTodayCard(
                myPreferenceList = ForYouRecommendationData.dummyMyPreferenceData,
                situationList = ForYouRecommendationData.dummySituationData,
            )

            ForYouCustomSongCard(
                onMixUpClick = onMixUpClick,
                customSongList = uiState.customSongList,
            )

            ForYouNewestContent(
                newestAlbum = uiState.newestAlbum,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ForYouScreenPreview() {
    MELONTheme {
        ForYouScreen(
            modifier = Modifier.background(MELONTheme.colors.background),
            onMixUpClick = {},
            uiState = ForYouUiState(),
        )
    }
}
