package org.sopt.melon.presentation.main.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import org.sopt.melon.core.common.util.noRippleClickable
import org.sopt.melon.core.designsystem.theme.MELONTheme
import org.sopt.melon.presentation.main.MainTab

@Composable
fun MainBottomBar(
    tabs: ImmutableList<MainTab>,
    currentTab: MainTab?,
    onTabSelected: (MainTab) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        Box(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color.DarkGray),
            // TODO: COLOR 수정
        )

        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.Black, // TODO: COLOR 수정
                    ).padding(
                        start = 14.dp,
                        top = 4.dp,
                        end = 14.dp,
                        bottom = 18.dp,
                    ),
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            tabs.forEach { tab ->
                val selectedIcon = if (tab == currentTab) tab.selectedIconRes else tab.defaultIconRes
                val selectedColor = if (tab == currentTab) Color.Green else Color.Gray // TODO: COLOR 수정

                MainNavigationBarItem(
                    tab = tab,
                    onClick = { onTabSelected(tab) },
                    selectedIcon = selectedIcon,
                    selectedColor = selectedColor,
                    modifier = Modifier.weight(1f),
                )
            }
        }
    }
}

@Composable
private fun MainNavigationBarItem(
    tab: MainTab,
    onClick: () -> Unit,
    @DrawableRes selectedIcon: Int,
    selectedColor: Color,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier =
            modifier
                .semantics(mergeDescendants = true) { role = Role.Tab }
                .size(48.dp)
                .noRippleClickable(onClick),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(space = 2.dp, alignment = Alignment.CenterVertically),
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(selectedIcon),
            contentDescription = stringResource(tab.title),
            tint = Color.Unspecified,
        )

        Text(
            text = stringResource(tab.title),
            style = TextStyle.Default, // TODO: TYPO 수정
            color = selectedColor,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MainBottomBarPreview() {
    MELONTheme {
        MainBottomBar(
            tabs = MainTab.entries.toImmutableList(),
            currentTab = MainTab.HOME,
            onTabSelected = {},
        )
    }
}
