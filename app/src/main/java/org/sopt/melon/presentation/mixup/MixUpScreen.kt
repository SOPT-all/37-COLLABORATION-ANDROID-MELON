package org.sopt.melon.presentation.mixup

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MixUpRoute(
    navigateUp: () -> Unit,
) {
    MixUpScreen()
}

@Composable
private fun MixUpScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ){
        Text("MIXUP", color = Color.White)
    }
}
