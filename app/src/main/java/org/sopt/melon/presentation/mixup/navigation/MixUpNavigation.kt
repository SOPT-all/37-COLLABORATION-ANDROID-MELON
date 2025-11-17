package org.sopt.melon.presentation.mixup.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.melon.core.common.navigation.Route
import org.sopt.melon.presentation.mixup.MixUpRoute

fun NavController.navigateToMixUp(
    navOptions: NavOptions? = null,
) = navigate(MixUp, navOptions)

fun NavGraphBuilder.mixUpGraph(
    navigateUp: () -> Unit,
) {
    composable<MixUp> {
        MixUpRoute(
            navigateUp = navigateUp,
        )
    }
}

@Serializable
data object MixUp : Route
