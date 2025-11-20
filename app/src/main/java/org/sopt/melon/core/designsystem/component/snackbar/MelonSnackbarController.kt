package org.sopt.melon.core.designsystem.component.snackbar

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private const val SNACKBAR_AUTO_DISMISS_MS = 3000L

class MelonSnackbarController(
    private val coroutineScope: CoroutineScope,
) {
    val snackbarHostState = SnackbarHostState()

    var currentRequest by mutableStateOf<MelonSnackbarRequest?>(null)
        private set

    private var actionJob: Job? = null
    private var timerJob: Job? = null
    fun show(request: MelonSnackbarRequest) {
        currentRequest = request

        coroutineScope.launch {
            clearCurrentSnackbar()

            val job = launch {
                snackbarHostState.showSnackbar(
                    message = request.message,
                    actionLabel = request.actionLabel,
                    withDismissAction = true,
                )
            }
            actionJob = job

            timerJob = launch {
                delay(SNACKBAR_AUTO_DISMISS_MS)
                if (actionJob == job) {
                    job.cancel()
                    currentRequest = null
                    actionJob = null
                    timerJob = null
                }
            }
        }
    }

    private fun clearCurrentSnackbar() {
        actionJob?.cancel()
        timerJob?.cancel()
        snackbarHostState.currentSnackbarData?.dismiss()
    }

    fun performAction() {
        currentRequest?.onClick?.invoke()
        currentRequest = null

        coroutineScope.launch {
            snackbarHostState.currentSnackbarData?.dismiss()
        }
    }
}

@Composable
fun rememberMelonSnackbarController(
    scope: CoroutineScope = rememberCoroutineScope(),
): MelonSnackbarController = remember {
    MelonSnackbarController(scope)
}
