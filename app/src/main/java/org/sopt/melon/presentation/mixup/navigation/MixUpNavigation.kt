package org.sopt.melon.presentation.mixup.navigation

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.PaddingValues
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
    navigateToHome: () -> Unit,
    innerPadding: PaddingValues,
) {
    composable<MixUp>(
        enterTransition = {
            slideInVertically(
                initialOffsetY = { fullHeight -> fullHeight },
                animationSpec = tween(300, easing = FastOutSlowInEasing),
            )
        },
        popExitTransition = {
            slideOutVertically(
                targetOffsetY = { fullHeight -> fullHeight }, // 화면 아래로 이동
                animationSpec = tween(300, easing = FastOutLinearInEasing),
            )
        },
    ) {
        MixUpRoute(
            innerPadding = innerPadding,
            onChevronClick = navigateToHome,
        )
    }
}

@Serializable
data object MixUp : Route
