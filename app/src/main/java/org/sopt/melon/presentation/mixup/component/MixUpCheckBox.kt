package org.sopt.melon.presentation.mixup.component

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.melon.R
import org.sopt.melon.core.common.util.noRippleClickable

@Composable
fun MixUpCheckBox(
    isSelected: Boolean,
    onSelectClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Icon(
        imageVector =
            ImageVector.vectorResource(
                if (isSelected) {
                    R.drawable.ic_checkbox_selected
                } else {
                    R.drawable.ic_checkbox_default
                },
            ),
        tint = Color.Unspecified,
        contentDescription = null,
        modifier = modifier.noRippleClickable(onSelectClick),
    )
}

@Preview
@Composable
fun MixUpCheckBoxPreview() {
    var isSelected by remember { mutableStateOf(true) }
    MixUpCheckBox(
        isSelected = isSelected,
        onSelectClick = { isSelected = !isSelected },
    )
}
