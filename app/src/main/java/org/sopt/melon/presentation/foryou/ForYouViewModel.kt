package org.sopt.melon.presentation.foryou

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.sopt.melon.data.repository.MusicRepository
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ForYouViewModel @Inject constructor(
    private val musicRepository: MusicRepository,
) : ViewModel() {
    init {
        fetchCustomMusic()
    }

    fun fetchCustomMusic() =
        viewModelScope.launch {
            musicRepository
                .getCustomMusic()
                .onSuccess { response ->
                    Timber.tag("ForYouViewModel").d(response.toString())
                }.onFailure { e ->
                    Timber.tag("ForYouViewModel").d(e.toString())
                }
        }
}
