package org.sopt.melon.presentation.foryou.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.melon.core.common.navigation.MainTabRoute
import org.sopt.melon.presentation.foryou.ForYouRoute

fun NavController.navigateToForYou(
    navOptions: NavOptions? = null,
) = navigate(ForYou, navOptions)

fun NavGraphBuilder.forYouGraph(
    innerPadding: PaddingValues,
    navigateToMixUp: () -> Unit,
) {
    composable<ForYou> {
        ForYouRoute(
            innerPadding = innerPadding,
            navigateToMixUp = navigateToMixUp,
        )
    }
}

@Serializable
data object ForYou : MainTabRoute
