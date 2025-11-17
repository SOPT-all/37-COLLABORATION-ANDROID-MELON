package org.sopt.melon.presentation.drawer

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.melon.core.common.navigation.MainTabRoute

fun NavController.navigateToDrawer(
    navOptions: NavOptions? = null,
) = navigate(Drawer, navOptions)

fun NavGraphBuilder.drawerGraph(
) {
    composable<Drawer> {
    }
}


@Serializable
data object Drawer : MainTabRoute
