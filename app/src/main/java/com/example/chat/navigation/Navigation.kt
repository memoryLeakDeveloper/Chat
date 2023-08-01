package com.example.chat.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.chat.ui.fragment.main.MainFragment

fun NavGraphBuilder.mainFragment(navController: NavController) {
    composable(FragmentsIds.MainFragment.name) {
        MainFragment()
    }
}