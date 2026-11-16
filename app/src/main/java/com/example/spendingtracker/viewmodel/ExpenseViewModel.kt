package com.example.spendingtracker.viewmodel

import androidx.lifecycle.ViewModel
import com.example.spendingtracker.model.Category
import com.example.spendingtracker.model.Expense
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.Calendar

enum class TimeFilter(val displayName: String) {
    WEEK("This Week"),
    MONTH("This Month"),
    YEAR("This Year"),
    ALL("All Time")
}

data class ExpenseUiState(
    val allExpenses: List<Expense> = emptyList(),
    val timeFilter: TimeFilter = TimeFilter.MONTH,
    val categories: List<Category> = Category.defaultCategories
) {
    val expenses: List<Expense>
        get() {
            val now = Calendar.getInstance()
            return allExpenses.filter { expense ->
                val expenseDate = Calendar.getInstance().apply { timeInMillis = expense.date }
                when (timeFilter) {
                    TimeFilter.WEEK -> {
                        now.get(Calendar.YEAR) == expenseDate.get(Calendar.YEAR) &&
                        now.get(Calendar.WEEK_OF_YEAR) == expenseDate.get(Calendar.WEEK_OF_YEAR)
                    }
                    TimeFilter.MONTH -> {
                        now.get(Calendar.YEAR) == expenseDate.get(Calendar.YEAR) &&
                        now.get(Calendar.MONTH) == expenseDate.get(Calendar.MONTH)
                    }
                    TimeFilter.YEAR -> {
                        now.get(Calendar.YEAR) == expenseDate.get(Calendar.YEAR)
                    }
                    TimeFilter.ALL -> true
                }
            }
        }

    val totalSpent: Double
        get() = expenses.sumOf { it.amount }
}

class ExpenseViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ExpenseUiState())
    val uiState: StateFlow<ExpenseUiState> = _uiState.asStateFlow()

    fun addExpense(title: String, amount: Double, category: Category, date: Long = System.currentTimeMillis()) {
        val expense = Expense(
            title = title,
            amount = amount,
            category = category,
            date = date
        )
        _uiState.update { currentState ->
            currentState.copy(
                allExpenses = currentState.allExpenses + expense
            )
        }
    }

    fun addCategory(displayName: String, color: androidx.compose.ui.graphics.Color) {
        val newCategory = Category(displayName = displayName, color = color)
        _uiState.update { currentState ->
            currentState.copy(
                categories = currentState.categories + newCategory
            )
        }
    }

    fun setTimeFilter(filter: TimeFilter) {
        _uiState.update { currentState ->
            currentState.copy(
                timeFilter = filter
            )
        }
    }
}
