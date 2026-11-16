package com.example.spendingtracker.viewmodel

import androidx.lifecycle.ViewModel
import com.example.spendingtracker.model.Category
import com.example.spendingtracker.model.Expense
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class ExpenseUiState(
    val expenses: List<Expense> = emptyList(),
    val totalSpent: Double = 0.0
)

class ExpenseViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ExpenseUiState())
    val uiState: StateFlow<ExpenseUiState> = _uiState.asStateFlow()

    fun addExpense(title: String, amount: Double, category: Category) {
        val expense = Expense(
            title = title,
            amount = amount,
            category = category
        )
        _uiState.update { currentState ->
            val updatedExpenses = currentState.expenses + expense
            val updatedTotal = updatedExpenses.sumOf { it.amount }
            currentState.copy(
                expenses = updatedExpenses,
                totalSpent = updatedTotal
            )
        }
    }
}
