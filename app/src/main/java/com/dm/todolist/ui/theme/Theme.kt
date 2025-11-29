package com.dm.todolist.ui.theme

import android.app.Activity
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView

private val Cream = Color(0xFFFFFDF2)
private val Black = Color(0xFF000000)
private val DarkGray = Color(0xFF2D2D2D)
private val LightBeige = Color(0xFFF5F3E8)
private val MediumGray = Color(0xFF6B6B6B)
private val SystemColors = darkColorScheme(
    primary = Color(0xFFFFFDF2),
    onPrimary = Color(0xFF000000),
    primaryContainer = Color(0xFF6B6B6B),
    onPrimaryContainer = Color(0xFFFFFDF2),
    secondary = Color(0xFFF5F3E8),
    onSecondary = Color(0xFF000000),
    secondaryContainer = Color(0xFF6B6B6B),
    onSecondaryContainer = Color(0xFFFFFDF2),
    background = Color(0xFF4A586B),
    onBackground = Color(0xFFFFFDF2),
    surface = Color(0xFF2D2D2D),
    onSurface = Color(0xFFFFFDF2),
    surfaceVariant = Color(0xFF6B6B6B),
    onSurfaceVariant = Color(0xFFF5F3E8),
    error = Color(0xFFFF6B6B),
    onError = Color(0xFF000000)
)

@Composable
fun TodoListTheme(content: @Composable () -> Unit) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = SystemColors.primaryContainer.toArgb()
        }
    }

    MaterialTheme(
        colorScheme = SystemColors,
        content = content
    )
}