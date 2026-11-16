# Project Plan

Add advanced features to the existing Personal Expense Tracker: 
1. Allow users to create custom categories (transition from static enum to dynamic list).
2. Tapping the "Total Spent" card displays a breakdown of spending by category (e.g., in a dialog or new screen).
3. Introduce time-based filtering: separate total spending counters for each month, and the ability to view total spending for a specific period (e.g., year, week, season).

## Project Brief

# Personal Expense Tracker - Project Brief

## Features
1. **Dynamic Custom Categories**: Allow users to create and manage personalized expense categories, replacing predefined static options to better fit their tracking needs.
2. **Category Spending Breakdown**: Provide an interactive "Total Spent" dashboard card that, when tapped, reveals a detailed view (e.g., a dialog or separate screen) displaying expenses grouped by category.
3. **Time-Based Filtering**: Enable users to analyze their spending over time by introducing specific monthly totals and flexible custom period filters (e.g., weekly, seasonal, or yearly views).

## High-Level Tech Stack
* **Language**: Kotlin
* **UI Framework**: Jetpack Compose
* **Navigation**: Jetpack Navigation 3 (Strictly state-driven navigation for managing multiple screens and dialogs)
* **Adaptive Layouts**: Compose Material 3 Adaptive library (for responsive layouts and multi-pane support across different screen sizes)
* **Architecture & Concurrency**: MVVM (Model-View-ViewModel) architecture leveraging Android `ViewModel`, Kotlin Coroutines, and `StateFlow` for lightweight, reactive state management in-memory.

## Implementation Steps
**Total Duration:** 19m 42s

### Task_1_StateAndViewModel: Define Expense model, Category enum with colors, and ViewModel to manage list of expenses and calculate total spent.
- **Status:** COMPLETED
- **Updates:** Task_1_StateAndViewModel completed successfully. The Expense model, Category enum with colors, and ExpenseViewModel with ExpenseUiState have been created and the project compiles.
- **Acceptance Criteria:**
  - Expense and Category models exist
  - ViewModel exposes UI state and add expense method
- **Duration:** 2m 3s

### Task_2_DashboardUI: Implement main dashboard using Jetpack Compose and Material 3. Apply light-green financial theme. Build Total Spent top card and scrollable recent transactions list.
- **Status:** COMPLETED
- **Updates:** Refinement fixed: Disabled dynamic color and enforced light-green theme on primaryContainer colors. Build verified.
- **Acceptance Criteria:**
  - Material 3 light-green theme is applied
  - Total Spent card is at the top
  - Scrollable list shows recent transactions
  - Category-specific colors (e.g. Red for Food, Blue for Transport) are used
- **Duration:** 3m 8s

### Task_3_AddExpenseFlow: Implement Add Expense flow using Navigation 3 or a BottomSheet. Add a FAB on the main screen to trigger it. Connect input form to the ViewModel.
- **Status:** COMPLETED
- **Updates:** Add Expense flow implemented. Added a FAB to DashboardScreen that opens a ModalBottomSheet with AddExpenseForm. Connected input to ExpenseViewModel. Saving updates the dashboard list and total spent.
- **Acceptance Criteria:**
  - FAB triggers Add Expense BottomSheet or Screen
  - Input form accepts amount, category, and note
  - Saving updates the dashboard list and total spent
- **Duration:** 1m 34s

### Task_4_RunAndVerify: Run and Verify application stability. Instruct critic_agent to verify application stability (no crashes), confirm alignment with user requirements, and report critical UI issues.
- **Status:** COMPLETED
- **Updates:** Verification successful. App is stable, light-green theme is correctly applied to Total Spent card and FAB. All requirements met.
- **Acceptance Criteria:**
  - make sure all existing tests pass
  - build pass
  - app does not crash
- **Duration:** 2m 56s

### Task_5_CustomCategoriesAndBreakdown: Refactor Category to a dynamic list in ViewModel. Update Add Expense form for custom category creation. Make 'Total Spent' card clickable using Navigation 3 to open a Category Breakdown screen/dialog.
- **Status:** COMPLETED
- **Updates:** Custom categories implemented using dynamic lists in ViewModel. Add Expense form now allows category creation with color picker. Total Spent card is now clickable and opens a CategoryBreakdownDialog showing spending per category.
- **Acceptance Criteria:**
  - Users can create custom categories
  - Tapping 'Total Spent' shows expense breakdown by category
- **Duration:** 2m 50s

### Task_6_TimeFilteringAndVerify: Add time-based filtering (monthly, custom periods) to ViewModel. Update Dashboard UI with time filter controls. Run and Verify application stability, instruct critic_agent to verify application stability, confirm alignment with requirements, and report critical UI issues.
- **Status:** COMPLETED
- **Updates:** Implemented TimeFiltering (Week, Month, Year, All) with UI chips on Dashboard. Updated ExpenseViewModel to filter expenses dynamically based on timestamp. Critic Agent verified stability, Custom Categories, Category Breakdown, and Time Filtering features successfully. No critical UI issues.
- **Acceptance Criteria:**
  - UI allows selecting specific time periods
  - Dashboard spending accurately reflects the selected period
  - make sure all existing tests pass
  - build pass
  - app does not crash
- **Duration:** 7m 11s

