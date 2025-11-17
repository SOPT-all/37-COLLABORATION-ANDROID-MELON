package org.sopt.melon.presentation.foryou.navigation

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
) {
    composable<ForYou> {
        ForYouRoute(
        )
    }
}


@Serializable
data object ForYou : MainTabRoute
