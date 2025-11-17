package org.sopt.melon.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.sp
import org.sopt.melon.R

object PretendardFont {
    val Bold = FontFamily(Font(R.font.pretendard_bold))
    val SemiBold = FontFamily(Font(R.font.pretendard_semibold))
    val Medium = FontFamily(Font(R.font.pretendard_medium))
    val Regular = FontFamily(Font(R.font.pretendard_regular))
}

sealed interface TypographyTokens {

    @Immutable
    data class Title(
        val b_24: TextStyle,
    )

    @Immutable
    data class Heading(
        val b_20: TextStyle,
    )

    @Immutable
    data class Body(
        val sb_16: TextStyle,
        val sb_14: TextStyle,
        val m_14: TextStyle,
        val r_14: TextStyle,
    )

    @Immutable
    data class Caption(
        val r_12: TextStyle,
        val m_10: TextStyle,
        val sb_8: TextStyle,
    )
}

@Immutable
data class MelonTypography(
    val title: TypographyTokens.Title,
    val heading: TypographyTokens.Heading,
    val body: TypographyTokens.Body,
    val caption: TypographyTokens.Caption,
)

val defaultMelonTypography = MelonTypography(
    title = TypographyTokens.Title(
        b_24 = TextStyle(
            fontFamily = PretendardFont.Bold,
            fontSize = 24.sp,
            lineHeight = 36.sp, // 150%
            letterSpacing = (-0.24).sp, // -1%
            platformStyle = PlatformTextStyle(
                includeFontPadding = false
            ),
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            )
        ),
    ),
    heading = TypographyTokens.Heading(
        b_20 = TextStyle(
            fontFamily = PretendardFont.Bold,
            fontSize = 20.sp,
            lineHeight = 30.sp, // 150%
            letterSpacing = (-0.2).sp, // -1%
            platformStyle = PlatformTextStyle(
                includeFontPadding = false
            ),
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            )
        ),
    ),
    body = TypographyTokens.Body(
        sb_16 = TextStyle(
            fontFamily = PretendardFont.SemiBold,
            fontSize = 16.sp,
            lineHeight = 24.sp, // 150%
            letterSpacing = (-0.16).sp, // -1%
            platformStyle = PlatformTextStyle(
                includeFontPadding = false
            ),
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            )
        ),
        sb_14 = TextStyle(
            fontFamily = PretendardFont.SemiBold,
            fontSize = 14.sp,
            lineHeight = 21.sp, // 150%
            letterSpacing = (-0.14).sp, // -1%
            platformStyle = PlatformTextStyle(
                includeFontPadding = false
            ),
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            )
        ),
        m_14 = TextStyle(
            fontFamily = PretendardFont.Medium,
            fontSize = 14.sp,
            lineHeight = 21.sp, // 150%
            letterSpacing = (-0.14).sp, // -1%
            platformStyle = PlatformTextStyle(
                includeFontPadding = false
            ),
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            )
        ),
        r_14 = TextStyle(
            fontFamily = PretendardFont.Regular,
            fontSize = 14.sp,
            lineHeight = 21.sp, // 150%
            letterSpacing = (-0.14).sp, // -1%
            platformStyle = PlatformTextStyle(
                includeFontPadding = false
            ),
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            )
        ),
    ),
    caption = TypographyTokens.Caption(
        r_12 = TextStyle(
            fontFamily = PretendardFont.Regular,
            fontSize = 12.sp,
            lineHeight = 18.sp, // 150%
            letterSpacing = (-0.12).sp, // -1%
            platformStyle = PlatformTextStyle(
                includeFontPadding = false
            ),
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            )
        ),
        m_10 = TextStyle(
            fontFamily = PretendardFont.Medium,
            fontSize = 10.sp,
            lineHeight = 15.sp, // 150%
            letterSpacing = (-0.1).sp, // -1%
            platformStyle = PlatformTextStyle(
                includeFontPadding = false
            ),
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            )
        ),
        sb_8 = TextStyle(
            fontFamily = PretendardFont.SemiBold,
            fontSize = 8.sp,
            lineHeight = 12.sp, // 150%
            letterSpacing = (-0.08).sp, // -1
            platformStyle = PlatformTextStyle(
                includeFontPadding = false
            ),
            lineHeightStyle = LineHeightStyle(
                alignment = LineHeightStyle.Alignment.Center,
                trim = LineHeightStyle.Trim.None,
            )
        ),
    ),
)

val LocalMelonTypographyProvider = staticCompositionLocalOf { defaultMelonTypography }
