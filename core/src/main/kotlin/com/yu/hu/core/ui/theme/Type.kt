package com.yu.hu.core.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    //Display（展示级） → 大标题、装饰性文字
    //displayLarge = ,
    //displayMedium = ,
    //displaySmall = ,

    //Headline（标题级） → 页面或模块标题
    //headlineLarge = ,
    //headlineMedium = ,
    //headlineSmall = ,

    //Title（中标题） → 小模块标题、导航栏文字
    //titleLarge = , //TopAppBar.title
    //titleMedium = ,
    //titleSmall = ,

    //Body（正文） → 普通文字内容
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    //bodyMedium =
    //bodySmall =

    //Label（标签） → 辅助信息、按钮文字、输入提示
    //labelLarge =
    //labelMedium =
    //labelSmall =
)