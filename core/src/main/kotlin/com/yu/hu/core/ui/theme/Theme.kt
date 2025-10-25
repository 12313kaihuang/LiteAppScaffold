package com.yu.hu.core.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    //基础主色系（Primary 系列）
    primary = Purple40, //主题色
    onPrimary = Color.White, //与 primary 对比的文字/图标色
    primaryContainer = Purple40, //主色的容器背景色
    onPrimaryContainer = Color.White,//在主容器上使用的文字/图标色
    //次级色系（Secondary 系列）
    secondary = PurpleGrey40, //次要强调色
    onSecondary = Color.White,
    secondaryContainer = PurpleGrey40, //次要容器背景色
    onSecondaryContainer = Color.White,
    //第三色系（Tertiary 系列）
    tertiary = Pink40, //辅助品牌色（常用于插画或次要视觉元素）
    onTertiary = Color.White,
    tertiaryContainer = Pink40, //第三容器背景色
    onTertiaryContainer = Color.White,
    //错误提示色系（Error 系列）
    error = Color.Red,
    onError = Color.White,
    errorContainer = Color.Red,
    onErrorContainer = Color.White,
    //背景与表面（Surface / Background）
    background = Color.White, //应用背景色
    onBackground = Color.Black,
    //surface = Color.Transparent, //表面背景色（可叠加不同层级）
    //onSurface = Color.Black,

    //表面变体（Surface Variant 系列）
    //surfaceVariant //比 surface 稍深/浅的变体
    //onSurfaceVariant

    //轮廓与边框
    //outline = //一般边框颜色
    //outlineVariant = //弱化边框颜色

    //反转表面（Inverse 系列）
    //inverseSurface = //在深浅模式下相反的表面色 如SnackBar背景
    //inverseOnSurface = //在 inverseSurface 上的文字颜色 如SnackBar 文本
    //inversePrimary = //与 primary 对比的反色 悬浮按钮高亮时

    //其他辅助色
    //surfaceVariant = //用于表面叠加的色彩 如Elevation 阴影效果叠色
    //scrim = //遮罩色 Dialog、BottomSheet 背景遮罩
)

@Composable
fun LiteAppScaffoldTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}