package org.sopt.melon.core.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

object MELONTheme {
    val colors: MelonColors
        @Composable
        @ReadOnlyComposable
        get() = LocalMelonColorsProvider.current

    val typography: MelonTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalMelonTypographyProvider.current
}

@Composable
fun ProvideMelonColorsAndTypography(
    colors: MelonColors,
    typography: MelonTypography,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalMelonColorsProvider provides colors,
        LocalMelonTypographyProvider provides typography,
        content = content,
    )
}

@Composable
fun MELONTheme(
    content: @Composable () -> Unit,
) {
    ProvideMelonColorsAndTypography(
        colors = defaultMelonColors,
        typography = defaultMelonTypography,
    ) {
        MaterialTheme(
            content = content,
        )
    }
}
