package org.sopt.melon.presentation.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.melon.core.common.navigation.MainTabRoute
import org.sopt.melon.presentation.home.HomeRoute

fun NavController.navigateToHome(
    navOptions: NavOptions? = null,
) = navigate(Home, navOptions)

fun NavGraphBuilder.homeGraph(
) {
    composable<Home> {
        HomeRoute(
        )
    }
}


@Serializable
data object Home : MainTabRoute
