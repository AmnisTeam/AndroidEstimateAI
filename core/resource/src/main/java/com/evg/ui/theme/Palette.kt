package com.evg.ui.theme

import androidx.compose.ui.graphics.Color

data class AppPalette(
    val primary: Color,
    val secondary: Color,
    val background: Color,
    val shimmer: Color,

    val text: Color,

    // TextField
    val textField: Color,
    val textFieldName: Color,
    val textFieldBackground: Color,

    // BottomBar
    val bottomBarSelected: Color,
)

enum class AppStyle {
    Purple,
}


val baseDarkPalette = AppPalette(
    primary = Color(0xFFC6B8FF),
    secondary = Color(0xFF4F378B),
    background = Color(0xFF161622),
    shimmer = Color.LightGray,

    text = Color(0xFFFFFFFF),

    // TextField
    textField = Color(0xFF6C6D8D),
    textFieldName = Color(0xFFAAAAAA),
    textFieldBackground = Color(0xFF1C1C2D),

    // BottomBar
    bottomBarSelected = Color(0xFF342F52),
)

val baseLightPalette = AppPalette(
    primary = Color(0xFFC6B8FF),
    secondary = Color(0xFFC6B8FF),
    background = Color(0xFFFFFFFF),
    shimmer = Color.Gray,

    text = Color(0xFF000000),

    // TextField
    textField = Color(0xFF6C6D8D),
    textFieldName = Color(0xFFAAAAAA),
    textFieldBackground = Color(0xFFF1F1F1),

    // BottomBar
    bottomBarSelected = Color(0xFF342F52),
)

