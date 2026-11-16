package com.example.spendingtracker.model

import androidx.compose.ui.graphics.Color
import java.util.UUID

data class Category(
    val id: String = UUID.randomUUID().toString(),
    val displayName: String,
    val color: Color
) {
    companion object {
        val defaultCategories = listOf(
            Category(id = "food", displayName = "Food", color = Color(0xFFF44336)),
            Category(id = "transport", displayName = "Transport", color = Color(0xFF2196F3)),
            Category(id = "entertainment", displayName = "Entertainment", color = Color(0xFFFF9800)),
            Category(id = "utilities", displayName = "Utilities", color = Color(0xFF4CAF50)),
            Category(id = "other", displayName = "Other", color = Color(0xFF9E9E9E))
        )
    }
}
