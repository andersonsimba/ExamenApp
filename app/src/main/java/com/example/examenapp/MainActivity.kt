package com.example.examenapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.examenapp.navigation.AppNavigation
import com.example.examenapp.ui.theme.ExamenAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ExamenAppTheme {
                AppNavigation()
            }
        }
    }
}