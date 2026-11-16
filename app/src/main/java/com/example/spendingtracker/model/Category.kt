package com.example.spendingtracker.model

import androidx.compose.ui.graphics.Color

enum class Category(val displayName: String, val color: Color) {
    FOOD("Food", Color(0xFFF44336)),       // Red
    TRANSPORT("Transport", Color(0xFF2196F3)), // Blue
    ENTERTAINMENT("Entertainment", Color(0xFFFF9800)), // Orange
    UTILITIES("Utilities", Color(0xFF4CAF50)), // Green
    OTHER("Other", Color(0xFF9E9E9E)) // Grey
}
