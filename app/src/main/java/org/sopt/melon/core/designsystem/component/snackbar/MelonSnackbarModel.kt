package org.sopt.melon.core.designsystem.component.snackbar

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf

@Immutable
data class MelonSnackbarRequest(
    val message: String,
    val actionLabel: String,
    val onClick: () -> Unit,
)

val LocalMelonSnackbarTrigger = staticCompositionLocalOf<(MelonSnackbarRequest) -> Unit> {
    error("No MelonSnackbarTrigger provided")
}
