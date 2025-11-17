package org.sopt.melon.presentation.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import org.sopt.melon.presentation.drawer.navigateToDrawer
import org.sopt.melon.presentation.foryou.navigation.navigateToForYou
import org.sopt.melon.presentation.home.navigation.Home
import org.sopt.melon.presentation.home.navigation.navigateToHome
import org.sopt.melon.presentation.search.navigateToSearch
import org.sopt.melon.presentation.shortcut.navigateToShortCut

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
            MainTab.SEARCH -> navController.navigateToSearch(navOptions = navOptions)
            MainTab.DRAWER -> navController.navigateToDrawer(navOptions = navOptions)
            MainTab.SHORTCUT -> navController.navigateToShortCut(navOptions = navOptions)
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
