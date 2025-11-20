package org.sopt.melon.presentation.home.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.melon.R
import org.sopt.melon.core.designsystem.theme.MELONTheme

@Composable
fun HomeTopBar(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier =
            modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(42.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_logo),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.size(32.dp),
        )

        Spacer(Modifier.weight(1f))

        TopBarChip()

        Spacer(Modifier.width(16.dp))

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_cash),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.size(32.dp),
        )
    }
}

@Composable
private fun TopBarChip(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier =
            modifier
                .height(20.dp)
                .border(
                    width = 1.dp,
                    color = MELONTheme.colors.white,
                    shape = RoundedCornerShape(3.dp),
                )
                .padding(horizontal = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_diamond),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.size(12.dp),
        )

        Spacer(Modifier.width(2.dp))

        Text(
            stringResource(R.string.home_topbar_chip_content),
            style = MELONTheme.typography.caption.m_10,
            color = MELONTheme.colors.white,
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
private fun HomeTopBarPreview() {
    MELONTheme {
        HomeTopBar()
    }
}
