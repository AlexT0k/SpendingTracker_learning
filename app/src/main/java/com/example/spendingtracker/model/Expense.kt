package com.example.spendingtracker.model

import java.util.UUID

data class Expense(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val amount: Double,
    val category: Category,
    val date: Long = System.currentTimeMillis()
)
