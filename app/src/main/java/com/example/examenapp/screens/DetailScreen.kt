package com.example.examenapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.examenapp.viewmodel.BiteBoxViewModel

@Composable
fun DetailScreen(
    navController: NavController,
    viewModel: BiteBoxViewModel,
    id: Int
) {

    val platillo = viewModel.obtenerPlatilloPorId(id)

    if (platillo == null) {

        Text("Platillo no encontrado")
        return
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        AsyncImage(
            model = platillo.urlImagen,
            contentDescription = platillo.nombre,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = platillo.nombre,
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Text(
                text = platillo.descripcion
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Text(
                text = "Precio: $${platillo.precio}",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Button(
                onClick = {

                    viewModel.agregarAlCarrito(
                        platillo
                    )

                    navController.popBackStack()
                },
                modifier = Modifier.fillMaxWidth()
            ) {

                Text(
                    "Añadir al Carrito"
                )
            }
        }
    }
}