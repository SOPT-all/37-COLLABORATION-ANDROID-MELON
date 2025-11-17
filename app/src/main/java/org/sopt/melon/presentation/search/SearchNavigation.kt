package org.sopt.melon.presentation.search

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.melon.core.common.navigation.MainTabRoute

fun NavController.navigateToSearch(
    navOptions: NavOptions? = null,
) = navigate(Search, navOptions)

fun NavGraphBuilder.searchGraph() {
    composable<Search> {
    }
}

@Serializable
data object Search : MainTabRoute
