package com.msaitodev.salesclerk.humanmed.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import com.msaitodev.core.common.ui.LocalAppColors
import com.msaitodev.core.common.ui.AppColors

private val LightColorScheme = lightColorScheme(
    primary = BrandPrimary,
    secondary = BrandSecondary,
    tertiary = BrandTertiary,
    background = AppBackground,
    surface = AppBackground,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.Black,
    onBackground = Color(0xFF001E3C),
    onSurface = Color(0xFF001E3C),
)

private val DarkColorScheme = darkColorScheme(
    primary = BrandPrimaryDark,
    secondary = BrandSecondaryDark,
    tertiary = BrandTertiaryDark,
    background = Color(0xFF121212),
    surface = Color(0xFF121212),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
)

// アプリケーション用のセマンティックカラー定義（ライトモード用）
private val LightAppColors = AppColors(
    correctBorder = Color(0xFF005FB8),      // ブランドカラーのブルー
    correctBackground = Color(0xFFE1F5FE),  // 非常に淡いブルー（以前のグリーンから刷新）
    wrongBorder = Color(0xFFC53030),
    wrongBackground = Color(0xFFFFE0E0),
    selectedBackground = Color(0xFFE5E5E5)
)

// アプリケーション用のセマンティックカラー定義（ダークモード用）
private val DarkAppColors = AppColors(
    correctBorder = Color(0xFF4FC3F7),      // 明るいスカイブルー
    correctBackground = Color(0xFF002F56),  // 濃いネイビー（介護のグリーン #1C4532 から刷新）
    wrongBorder = Color(0xFFF56565),
    wrongBackground = Color(0xFF652B19),
    selectedBackground = Color(0xFF4A5568)
)

@Composable
fun SalesclerkTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    val appColors = if (darkTheme) DarkAppColors else LightAppColors

    CompositionLocalProvider(
        LocalAppColors provides appColors
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            content = content
        )
    }
}
