package org.sopt.melon.presentation.mixup.component

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import org.sopt.melon.R
import org.sopt.melon.core.common.util.noRippleClickable

@Composable
fun MixUpCheckBox(
    isSelected: Boolean,
    onSelectClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Image(
        imageVector =
            ImageVector.vectorResource(
                if (isSelected) {
                    R.drawable.ic_checkbox_selected
                } else {
                    R.drawable.ic_checkbox_default
                },
            ),
        contentDescription = null,
        modifier = modifier.noRippleClickable(onSelectClick),
    )
}
