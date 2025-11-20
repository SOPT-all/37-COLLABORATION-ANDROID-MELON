package org.sopt.melon.core.designsystem.component.snackbar

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private const val SNACKBAR_AUTO_DISMISS_MS = 3000L

class MelonSnackbarController(
    private val coroutineScope: CoroutineScope,
) {
    val snackbarHostState = SnackbarHostState()

    var currentRequest by mutableStateOf<MelonSnackbarRequest?>(null)
        private set

    fun show(request: MelonSnackbarRequest) {
        currentRequest = request

        coroutineScope.launch {
            snackbarHostState.currentSnackbarData?.dismiss()

            val job = launch {
                snackbarHostState.showSnackbar(
                    message = request.message,
                    actionLabel = request.actionLabel,
                    withDismissAction = true,
                )
            }

            job.invokeOnCompletion {
                if (currentRequest === request) {
                    currentRequest = null
                }
            }

            launch {
                delay(SNACKBAR_AUTO_DISMISS_MS)
                job.cancel()
            }
        }
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
