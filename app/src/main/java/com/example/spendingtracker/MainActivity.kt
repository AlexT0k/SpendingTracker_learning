package com.example.spendingtracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.spendingtracker.model.Category
import com.example.spendingtracker.ui.DashboardScreen
import com.example.spendingtracker.ui.theme.SpendingTrackerTheme
import com.example.spendingtracker.viewmodel.ExpenseViewModel

class MainActivity : ComponentActivity() {
    private val expenseViewModel: ExpenseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Add some mock data if empty
        if (expenseViewModel.uiState.value.expenses.isEmpty()) {
            expenseViewModel.addExpense("Groceries", 85.50, Category.defaultCategories[0])
            expenseViewModel.addExpense("Bus Ticket", 2.50, Category.defaultCategories[1])
            expenseViewModel.addExpense("Movie Ticket", 15.00, Category.defaultCategories[2])
            expenseViewModel.addExpense("Electric Bill", 60.00, Category.defaultCategories[3])
        }
        
        enableEdgeToEdge()
        setContent {
            SpendingTrackerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DashboardScreen(
                        viewModel = expenseViewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
