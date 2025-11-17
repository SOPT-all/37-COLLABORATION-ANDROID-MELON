package org.sopt.melon.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Brush


// Gray Scale
val Gray100 = Color(0xFFFAFAFA)
val Gray200 = Color(0xFFA6A6A6)
val Gray300 = Color(0xFF8C8C8C)
val Gray400 = Color(0xFF7B7B7B)
val Gray500 = Color(0xFF303030)
val Gray600 = Color(0xFF2A2A2A)
val Gray700 = Color(0xFF1C1C1C)

// Base Color
val White = Color(0xFFFFFFFF)
val Black = Color(0xFF000000)
val Opacity1 = Color(0x80FFFFFF)
val Opacity2 = Color(0x99000000)

// Background Color
val Background = Color(0xFF121212)
val Background2 = Color(0xFF202021)

// Bar Color
val Bar1 = Color(0xFFC7F79C)
val Bar2 = Color(0xFF77EC77)
val Bar3 = Color(0xFF80DF43)
val Bar4 = Color(0xFF5FCB75)
val Bar5 = Color(0xFF56BD4D)
val Bar6 = Color(0xFF3C894C)

// Main Color
val Primary = Color(0xFF04E632)
val Secondary = Color(0xFF0DE06D)

// Color Palette
val Cyan = Color(0xFF00EEFF)
val Orange = Color(0xFFFFAD86)
val Violet = Color(0xFF6E00DF)
val Violet2 = Color(0xFF893FE4)
val Purple = Color(0xFFA11CD7)
val Navy = Color(0xFF122A56)
val Blue = Color(0xFF4B33FF)
val SkyBlue = Color(0xFF627DED)
val BlueGray = Color(0xFF495263)
val Pink = Color(0xFFFC5AFF)
val NeonPink = Color(0xFFFF2C75)
val Yellow = Color(0xFFFEE500)
val RedOrange = Color(0xFFFF4E0D)
val LightGray = Color(0xFF70737C)

// Gradient Color
val GradientLine = Brush.linearGradient(
    0.0f to LightGray,
    0.3f to LightGray.copy(alpha = 0f)
)

val Gradient1 = Brush.linearGradient(
    0.0f to Violet2,
    0.5f to SkyBlue,
    0.8f to Cyan,
    1.0f to Cyan
)

val Gradient2 = Brush.linearGradient(
    0.0f to Cyan,
    0.5f to Primary
)

val Gradient3 = Brush.linearGradient(
    0.0f to BlueGray,
    0.53f to Gray500,
    1.0f to Background
)

@Immutable
data class MelonColors(
    val gray100: Color = Gray100,
    val gray200: Color = Gray200,
    val gray300: Color = Gray300,
    val gray400: Color = Gray400,
    val gray500: Color = Gray500,
    val gray600: Color = Gray600,
    val gray700: Color = Gray700,

    val white: Color = White,
    val black: Color = Black,
    val opacity1: Color = Opacity1,
    val opacity2: Color = Opacity2,

    val background: Color = Background,
    val background2: Color = Background2,

    val bar1: Color = Bar1,
    val bar2: Color = Bar2,
    val bar3: Color = Bar3,
    val bar4: Color = Bar4,
    val bar5: Color = Bar5,
    val bar6: Color = Bar6,

    val primary: Color = Primary,
    val secondary: Color = Secondary,

    val cyan: Color = Cyan,
    val orange: Color = Orange,
    val violet: Color = Violet,
    val purple: Color = Purple,
    val navy: Color = Navy,
    val blue: Color = Blue,
    val pink: Color = Pink,
    val neonPink: Color = NeonPink,
    val yellow: Color = Yellow,
    val redOrange: Color = RedOrange,

    val gradientLine: Brush = GradientLine,
    val gradient1: Brush = Gradient1,
    val gradient2: Brush = Gradient2,
    val gradient3: Brush = Gradient3
)

val defaultMelonColors = MelonColors(
    gray100 = Gray100,
    gray200 = Gray200,
    gray300 = Gray300,
    gray400 = Gray400,
    gray500 = Gray500,
    gray600 = Gray600,
    gray700 = Gray700,

    white = White,
    black = Black,
    opacity1 = Opacity1,
    opacity2 = Opacity2,

    background = Background,
    background2 = Background2,

    bar1 = Bar1,
    bar2 = Bar2,
    bar3 = Bar3,
    bar4 = Bar4,
    bar5 = Bar5,
    bar6 = Bar6,

    primary = Primary,
    secondary = Secondary,

    cyan = Cyan,
    orange = Orange,
    violet = Violet,
    purple = Purple,
    navy = Navy,
    blue = Blue,
    pink = Pink,
    neonPink = NeonPink,
    yellow = Yellow,
    redOrange = RedOrange,

    gradientLine = GradientLine,
    gradient1 = Gradient1,
    gradient2 = Gradient2,
    gradient3 = Gradient3
)

val LocalMelonColorsProvider = staticCompositionLocalOf { defaultMelonColors }
