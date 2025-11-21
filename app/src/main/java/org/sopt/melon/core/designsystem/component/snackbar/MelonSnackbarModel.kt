package org.sopt.melon.core.designsystem.component.snackbar

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf

@Immutable
data class MelonSnackbarActionRequest(
    val message: String,
    val actionLabel: String,
    val onClick: () -> Unit,
)

val LocalMelonSnackbarTrigger =
    staticCompositionLocalOf<(MelonSnackbarActionRequest) -> Unit> {
        error("No MelonSnackbarTrigger provided")
    }
