package org.sopt.melon.presentation.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import org.sopt.melon.R.drawable.ic_drawer_default
import org.sopt.melon.R.drawable.ic_foryou_default
import org.sopt.melon.R.drawable.ic_foryou_selected
import org.sopt.melon.R.drawable.ic_home_default
import org.sopt.melon.R.drawable.ic_home_selected
import org.sopt.melon.R.drawable.ic_search_default
import org.sopt.melon.R.drawable.ic_shortcut_default
import org.sopt.melon.R.string.drawer
import org.sopt.melon.R.string.foryou
import org.sopt.melon.R.string.home
import org.sopt.melon.R.string.search
import org.sopt.melon.R.string.shortcut
import org.sopt.melon.core.common.navigation.MainTabRoute
import org.sopt.melon.core.common.navigation.Route
import org.sopt.melon.presentation.drawer.Drawer
import org.sopt.melon.presentation.foryou.navigation.ForYou
import org.sopt.melon.presentation.home.navigation.Home
import org.sopt.melon.presentation.search.Search
import org.sopt.melon.presentation.shortcut.ShortCut

enum class MainTab(
    @DrawableRes val defaultIconRes: Int,
    @DrawableRes val selectedIconRes: Int,
    @StringRes val title: Int,
    val route: MainTabRoute,
) {
    HOME(
        defaultIconRes = ic_home_default,
        selectedIconRes = ic_home_selected,
        title = home,
        route = Home,
    ),
    FORYOU(
        defaultIconRes = ic_foryou_default,
        selectedIconRes = ic_foryou_selected,
        title = foryou,
        route = ForYou,
    ),
    SEARCH(
        defaultIconRes = ic_search_default,
        selectedIconRes = ic_search_default,
        title = search,
        route = Search,
    ),
    DRAWER(
        defaultIconRes = ic_drawer_default,
        selectedIconRes = ic_drawer_default,
        title = drawer,
        route = Drawer,
    ),
    SHORTCUT(
        defaultIconRes = ic_shortcut_default,
        selectedIconRes = ic_shortcut_default,
        title = shortcut,
        route = ShortCut,
    );

    companion object {
        @Composable
        fun find(predicate: @Composable (MainTabRoute) -> Boolean): MainTab? =
            MainTab.entries.find { predicate(it.route) }


        @Composable
        fun contains(predicate: @Composable (Route) -> Boolean): Boolean {
            return MainTab.entries.map { it.route }.any { predicate(it) }
        }
    }
}
