package org.sopt.melon.presentation.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import org.sopt.melon.presentation.foryou.navigation.navigateToForYou
import org.sopt.melon.presentation.home.navigation.Home
import org.sopt.melon.presentation.home.navigation.navigateToHome

class MainNavigator(
    val navController: NavHostController,
) {
    private val currentDestination: NavDestination?
        @Composable get() =
            navController
                .currentBackStackEntryAsState()
                .value
                ?.destination

    val startDestination = Home

    val currentTab: MainTab?
        @Composable get() =
            MainTab.find { tab ->
                currentDestination?.hasRoute(tab::class) == true
            }

    fun navigate(tab: MainTab) {
        val navOptions =
            navOptions {
                navController.currentDestination?.route?.let {
                    popUpTo(it) {
                        saveState = true
                        inclusive = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }

        when (tab) {
            MainTab.HOME -> navController.navigateToHome(navOptions = navOptions)
            MainTab.FORYOU -> navController.navigateToForYou(navOptions = navOptions)
            MainTab.SEARCH -> {} // TODO: 디자인 미구현 사항
            MainTab.DRAWER -> {} // TODO: 디자인 미구현 사항
            MainTab.SHORTCUT -> {} // TODO: 디자인 미구현 사항
        }
    }

    fun navigateUp() = navController.navigateUp()

    @Composable
    fun showBottomBar(): Boolean {
        val isMainTabRoute =
            MainTab.contains {
                currentDestination?.hasRoute(it::class) == true
            }
        return isMainTabRoute
    }
}

@Composable
fun rememberMainNavigator(
    navController: NavHostController = rememberNavController(),
): MainNavigator =
    remember(navController) {
        MainNavigator(navController)
    }
