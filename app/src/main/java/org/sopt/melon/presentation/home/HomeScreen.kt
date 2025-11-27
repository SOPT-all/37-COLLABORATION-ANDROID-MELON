package org.sopt.melon.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.collections.immutable.persistentListOf
import org.sopt.melon.R
import org.sopt.melon.R.string.snackbar_mixup_add_message
import org.sopt.melon.R.string.snackbar_move_action_label
import org.sopt.melon.core.designsystem.component.snackbar.LocalMelonSnackbarTrigger
import org.sopt.melon.core.designsystem.component.snackbar.MelonSnackbarActionRequest
import org.sopt.melon.core.designsystem.theme.MELONTheme
import org.sopt.melon.presentation.home.component.HomeBannerList
import org.sopt.melon.presentation.home.component.HomeChartButton
import org.sopt.melon.presentation.home.component.HomeChartTitle
import org.sopt.melon.presentation.home.component.HomeChipList
import org.sopt.melon.presentation.home.component.HomeEventBanner
import org.sopt.melon.presentation.home.component.HomeMelonChartGrid
import org.sopt.melon.presentation.home.component.HomeNewSongGrid
import org.sopt.melon.presentation.home.component.HomeNewSongTitle
import org.sopt.melon.presentation.home.component.HomePopularGrid
import org.sopt.melon.presentation.home.component.HomePreferenceSongCard
import org.sopt.melon.presentation.home.component.HomeRecommendList
import org.sopt.melon.presentation.home.component.HomeTitle
import org.sopt.melon.presentation.home.component.HomeTopBar
import org.sopt.melon.presentation.home.model.BannerData
import org.sopt.melon.presentation.home.model.MelonChartItemData
import org.sopt.melon.presentation.home.model.NewSongItemData
import org.sopt.melon.presentation.home.model.PopularSongData
import org.sopt.melon.presentation.home.model.PreferenceSongCardData
import org.sopt.melon.presentation.home.model.RecommendSongItemData
import org.sopt.melon.presentation.home.type.NewSongFilter

@Composable
fun HomeRoute(
    innerPadding: PaddingValues,
    navigateToMixUp: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val snackbarTrigger = LocalMelonSnackbarTrigger.current
    val snackbarRequest =
        MelonSnackbarActionRequest(
            message = stringResource(snackbar_mixup_add_message),
            actionLabel = stringResource(snackbar_move_action_label),
            onClick = navigateToMixUp,
        )

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val popularGridState = rememberLazyGridState()
    val melonChartGridState = rememberLazyGridState()

    HomeScreen(
        uiState = uiState,
        onMixUpClick = { snackbarTrigger(snackbarRequest) },
        popularGridState = popularGridState,
        melonChartGridState = melonChartGridState,
        onNewSongFilterClick = viewModel::onNewSongFilterClick,
        modifier =
            Modifier
                .padding(innerPadding),
    )
}

@Composable
private fun HomeScreen(
    uiState: HomeUiState,
    onMixUpClick: () -> Unit,
    popularGridState: LazyGridState,
    melonChartGridState: LazyGridState,
    onNewSongFilterClick: (NewSongFilter) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
    ) {
        item {
            HomeTopBar(
                modifier =
                    Modifier
                        .padding(
                            top = 12.dp,
                            bottom = 8.dp,
                        ),
            )

            HomeEventBanner(
                modifier =
                    Modifier
                        .padding(
                            start = 20.dp,
                            end = 20.dp,
                            bottom = 20.dp,
                        ),
            )

            HomePreferenceSongCard(
                data = uiState.preferenceSong,
                modifier =
                    Modifier
                        .padding(
                            start = 20.dp,
                            end = 20.dp,
                            bottom = 28.dp,
                        ),
            )
        }

        item {
            HomeTitle(
                title = "${uiState.userName}님을 위한 추천",
                modifier =
                    Modifier.padding(
                        bottom = 12.dp,
                    ),
            )

            HomeRecommendList(
                recommendSongList = uiState.recommendSongList,
                modifier =
                    Modifier
                        .padding(
                            bottom = 48.dp,
                        ),
            )
        }

        item {
            HomeTitle(
                title = "인기 선곡",
                modifier =
                    Modifier.padding(
                        bottom = 16.dp,
                    ),
            )

            HomePopularGrid(
                popularSongList = uiState.popularSongList,
                gridState = popularGridState,
                onMixUpClick = onMixUpClick,
                modifier =
                    Modifier
                        .padding(
                            bottom = 48.dp,
                        ),
            )
        }

        item {
            HomeBannerList(
                bannerDataList = uiState.bannerList,
                modifier =
                    Modifier
                        .padding(
                            bottom = 48.dp,
                        ),
            )
        }

        item {
            HomeNewSongTitle(
                selectedNewSongTab = uiState.selectedNewSongTab,
                onFilterClick = onNewSongFilterClick,
                modifier =
                    Modifier
                        .padding(bottom = 14.dp),
            )

            HomeNewSongGrid(
                newSongList = uiState.newSongData,
                modifier =
                    Modifier
                        .padding(
                            bottom = 48.dp,
                        ),
            )
        }

        item {
            HomeChartTitle(
                modifier = Modifier.padding(bottom = 12.dp),
            )

            HomeChipList(
                chipContentList = uiState.chipContentList,
            )

            HomeMelonChartGrid(
                melonChartList = uiState.melonChartList,
                gridState = melonChartGridState,
                modifier = Modifier.padding(vertical = 20.dp),
            )

            HomeChartButton(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 60.dp),
            )
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    MELONTheme {
        Box(
            modifier =
                Modifier
                    .fillMaxSize()
                    .background(MELONTheme.colors.background),
        ) {
            HomeScreen(
                uiState =
                    HomeUiState(
                        userName = "안드콩",
                        preferenceSong =
                            PreferenceSongCardData(
                                image = R.drawable.img_preference_95,
                                description = "이거 진짜 좋은뎅",
                                songTitle = "LINK IT ALL",
                                singer = "SPYAIR",
                            ),
                        recommendSongList =
                            persistentListOf(
                                RecommendSongItemData(
                                    image = R.drawable.img_recommend1_140,
                                    description = "내가 아끼는 최애곡 모음",
                                ),
                                RecommendSongItemData(
                                    image = R.drawable.img_recommend1_140,
                                    description = "내가 아끼는 최애곡 모음",
                                ),
                                RecommendSongItemData(
                                    image = R.drawable.img_recommend1_140,
                                    description = "내가 아끼는 최애곡 모음",
                                ),
                            ),
                        popularSongList =
                            persistentListOf(
                                PopularSongData(
                                    imgUrl = "",
                                    subtitle = "멜론DJ's Pick",
                                    title = "1XOXZ",
                                    artistName = "IVE (아이브)",
                                ),
                                PopularSongData(
                                    imgUrl = "",
                                    subtitle = "멜론DJ's Pick",
                                    title = "2XOXZ",
                                    artistName = "IVE (아이브)",
                                ),
                                PopularSongData(
                                    imgUrl = "",
                                    subtitle = "멜론DJ's Pick",
                                    title = "3XOXZ",
                                    artistName = "Hearts2Hearts(하츠투하츠)",
                                ),
                                PopularSongData(
                                    imgUrl = "",
                                    subtitle = "멜론DJ's Pick",
                                    title = "4XOXZ",
                                    artistName = "IVE (아이브)",
                                ),
                                PopularSongData(
                                    imgUrl = "",
                                    subtitle = "멜론DJ's Pick",
                                    title = "5XOXZ",
                                    artistName = "IVE (아이브)",
                                ),
                                PopularSongData(
                                    imgUrl = "",
                                    subtitle = "멜론DJ's Pick",
                                    title = "6XOXZ",
                                    artistName = "IVE (아이브)",
                                ),
                            ),
                        bannerList =
                            persistentListOf(
                                BannerData(
                                    title = "2025 WOODZ PREVIEW CONCERT",
                                    image = R.drawable.ic_launcher_background,
                                    category = "Melon Ticket",
                                    headline = "우즈 CONCERT",
                                    description = "멜론티켓에서 예매하기",
                                    backgroundColor = MELONTheme.colors.bar6,
                                ),
                                BannerData(
                                    title = "2025 WOODZ PREVIEW CONCERT",
                                    image = R.drawable.ic_launcher_background,
                                    category = "Melon Ticket",
                                    headline = "우즈 CONCERT",
                                    description = "멜론티켓에서 예매하기멜론티켓에서 예매하기",
                                    backgroundColor = MELONTheme.colors.bar6,
                                ),
                                BannerData(
                                    title = "2025 WOODZ PREVIEW CONCERT",
                                    image = R.drawable.ic_launcher_background,
                                    category = "Melon Ticket",
                                    headline = "우즈 CONCERT",
                                    description = "멜론티켓에서 예매하기멜론티켓에서 예매하기멜론티켓에서 예매하기멜론티켓에서 예매하기",
                                    backgroundColor = MELONTheme.colors.bar6,
                                ),
                            ),
                        newSongData =
                            persistentListOf(
                                NewSongItemData(
                                    imageUrl = "TODO()",
                                    songTitle = "Back to Life",
                                    singer = "&TEAM",
                                ),
                                NewSongItemData(
                                    imageUrl = "TODO()",
                                    songTitle = "Back to Life",
                                    singer = "&TEAM",
                                ),
                                NewSongItemData(
                                    imageUrl = "TODO()",
                                    songTitle = "Back to Life",
                                    singer = "&TEAM",
                                ),
                                NewSongItemData(
                                    imageUrl = "TODO()",
                                    songTitle = "Back to Life",
                                    singer = "&TEAM",
                                ),
                                NewSongItemData(
                                    imageUrl = "TODO()",
                                    songTitle = "Back to Life",
                                    singer = "&TEAM",
                                ),
                                NewSongItemData(
                                    imageUrl = "TODO()",
                                    songTitle = "Back to Life",
                                    singer = "&TEAM",
                                ),
                                NewSongItemData(
                                    imageUrl = "TODO()",
                                    songTitle = "Back to Life",
                                    singer = "&TEAM",
                                ),
                                NewSongItemData(
                                    imageUrl = "TODO()",
                                    songTitle = "Back to Life",
                                    singer = "&TEAM",
                                ),
                                NewSongItemData(
                                    imageUrl = "TODO()",
                                    songTitle = "Back to Life",
                                    singer = "&TEAM",
                                ),
                                NewSongItemData(
                                    imageUrl = "TODO()",
                                    songTitle = "Back to Life",
                                    singer = "&TEAM",
                                ),
                                NewSongItemData(
                                    imageUrl = "TODO()",
                                    songTitle = "Back to Life",
                                    singer = "&TEAM",
                                ),
                            ),
                        chipContentList =
                            persistentListOf(
                                "TOP 100",
                                "HOT 100",
                                "월드뮤직",
                                "한강에서 즐기기 좋은 음악",
                            ),
                        melonChartList =
                            persistentListOf(
                                MelonChartItemData(
                                    imgUrl = "TODO()",
                                    title = "Blue Valentine",
                                    singer = "NMIXX",
                                ),
                                MelonChartItemData(
                                    imgUrl = "TODO()",
                                    title = "Blue Valentine",
                                    singer = "NMIXX",
                                ),
                                MelonChartItemData(
                                    imgUrl = "TODO()",
                                    title = "Blue Valentine",
                                    singer = "NMIXX",
                                ),
                                MelonChartItemData(
                                    imgUrl = "TODO()",
                                    title = "Blue Valentine",
                                    singer = "NMIXX",
                                ),
                                MelonChartItemData(
                                    imgUrl = "TODO()",
                                    title = "Blue Valentine",
                                    singer = "NMIXX",
                                ),
                                MelonChartItemData(
                                    imgUrl = "TODO()",
                                    title = "Blue Valentine",
                                    singer = "NMIXX",
                                ),
                                MelonChartItemData(
                                    imgUrl = "TODO()",
                                    title = "Blue Valentine",
                                    singer = "NMIXX",
                                ),
                                MelonChartItemData(
                                    imgUrl = "TODO()",
                                    title = "Blue Valentine",
                                    singer = "NMIXX",
                                ),
                            ),
                    ),
                onMixUpClick = {},
                popularGridState = rememberLazyGridState(),
                onNewSongFilterClick = {},
                melonChartGridState = rememberLazyGridState(),
            )
        }
    }
}
