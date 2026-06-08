package com.example.examenapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.Color

@Composable
fun LoginScreen(
    navController: NavController
) {

    var nombre by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "BiteBox ",
            style = MaterialTheme.typography.headlineLarge
        )

        OutlinedTextField(
            value = nombre,
            onValueChange = {
                nombre = it
            },
            label = {
                Text("BiteBox ")
            }
        )

        Button(
            onClick = {
                navController.navigate("menu/$nombre")
            },
            enabled = nombre.length > 3,
                    colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF0D47A1)
                    )
        ) {
            Text("Entrar")
        }
    }
}