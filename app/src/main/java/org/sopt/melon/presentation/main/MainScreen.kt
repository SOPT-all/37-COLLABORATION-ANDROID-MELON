package org.sopt.melon.presentation.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.compose.NavHost
import kotlinx.collections.immutable.toImmutableList
import org.sopt.melon.core.designsystem.theme.MELONTheme
import org.sopt.melon.presentation.drawer.drawerGraph
import org.sopt.melon.presentation.foryou.navigation.forYouGraph
import org.sopt.melon.presentation.home.navigation.homeGraph
import org.sopt.melon.presentation.main.component.MainBottomBar
import org.sopt.melon.presentation.mixup.navigation.mixUpGraph
import org.sopt.melon.presentation.mixup.navigation.navigateToMixUp
import org.sopt.melon.presentation.search.searchGraph
import org.sopt.melon.presentation.shortcut.shortCutGraph

@Composable
fun MainScreen(
    navigator: MainNavigator = rememberMainNavigator(),
) {
    Scaffold(
        bottomBar = {
            AnimatedVisibility(
                visible = navigator.showBottomBar(),
                enter = fadeIn() + slideIn { IntOffset(0, it.height) },
                exit = fadeOut() + slideOut { IntOffset(0, it.height) },
            ) {
                MainBottomBar(
                    tabs = MainTab.entries.toImmutableList(),
                    currentTab = navigator.currentTab,
                    onTabSelected = navigator::navigate,
                    modifier =
                        Modifier
                            .navigationBarsPadding(),
                )
            }
        },
        containerColor = MELONTheme.colors.background,
    ) { innerPadding ->
        MainNavHost(
            navigator = navigator,
            innerPadding = innerPadding,
        )
    }
}

@Composable
private fun MainNavHost(
    innerPadding: PaddingValues,
    navigator: MainNavigator,
) {
    NavHost(
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None },
        navController = navigator.navController,
        startDestination = navigator.startDestination,
    ) {
        homeGraph(
            innerPadding = innerPadding,
            navigateToMixUp = navigator.navController::navigateToMixUp,
        )

        forYouGraph(
            innerPadding = innerPadding,
            navigateToMixUp = navigator.navController::navigateToMixUp,
        )

        searchGraph()

        drawerGraph()

        shortCutGraph()

        mixUpGraph(
            navigateUp = navigator::navigateUp,
        )
    }
}
