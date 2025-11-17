package org.sopt.melon.presentation.shortcut

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.melon.core.common.navigation.MainTabRoute


fun NavController.navigateToShortCut(
    navOptions: NavOptions? = null,
) = navigate(ShortCut, navOptions)

fun NavGraphBuilder.shortCutGraph(
) {
    composable<ShortCut> {
    }
}


@Serializable
data object ShortCut : MainTabRoute
