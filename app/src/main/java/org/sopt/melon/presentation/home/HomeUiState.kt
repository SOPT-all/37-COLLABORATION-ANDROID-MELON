package org.sopt.melon.presentation.home

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import org.sopt.melon.R
import org.sopt.melon.presentation.home.model.BannerData
import org.sopt.melon.presentation.home.model.NewSongItemData
import org.sopt.melon.presentation.home.model.PopularSongData
import org.sopt.melon.presentation.home.model.PreferenceSongCardData
import org.sopt.melon.presentation.home.model.RecommendSongItemData
import org.sopt.melon.presentation.home.type.NewSongFilter

@Immutable
data class HomeUiState(
    val userName: String = "",
    val preferenceSong: PreferenceSongCardData =
        PreferenceSongCardData(
            image = R.drawable.img_preference_95,
            description = "",
            songTitle = "",
            singer = "",
        ),
    val recommendSongList: ImmutableList<RecommendSongItemData> = persistentListOf(),
    val popularSongList: ImmutableList<PopularSongData> = persistentListOf(),
    val bannerList: ImmutableList<BannerData> = persistentListOf(),
    val newSongData: ImmutableList<NewSongItemData> = persistentListOf(),
    val chipContentList: ImmutableList<String> = persistentListOf(),
    val selectedNewSongFilter: NewSongFilter = NewSongFilter.ALL,
    // 멜론 차트 데이터
)
