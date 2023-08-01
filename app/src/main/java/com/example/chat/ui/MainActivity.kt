package com.example.chat.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.chat.navigation.FragmentsIds
import com.example.chat.navigation.mainFragment
import com.example.chat.theme.ChatTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = FragmentsIds.MainFragment.name) {
                    mainFragment(navController)
                }
            }
        }
    }

}