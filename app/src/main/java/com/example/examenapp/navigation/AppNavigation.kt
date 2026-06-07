package com.example.examenapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.examenapp.screens.CartScreen
import com.example.examenapp.screens.DetailScreen
import com.example.examenapp.screens.LoginScreen
import com.example.examenapp.screens.MenuScreen
import com.example.examenapp.viewmodel.BiteBoxViewModel

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    val viewModel: BiteBoxViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {

        composable("login") {
            LoginScreen(navController)
        }

        composable("menu/{nombre}") { backStackEntry ->

            val nombre =
                backStackEntry.arguments?.getString("nombre") ?: ""

            MenuScreen(
                navController = navController,
                viewModel = viewModel,
                nombre = nombre
            )
        }

        composable(
            route = "detalle/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            val id =
                backStackEntry.arguments?.getInt("id") ?: 0

            DetailScreen(
                navController = navController,
                viewModel = viewModel,
                id = id
            )
        }

        composable("carrito") {

            CartScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
    }
}