package com.example.examenapp.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.examenapp.model.Platillo
import com.example.examenapp.viewmodel.BiteBoxViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(
    navController: NavController,
    viewModel: BiteBoxViewModel,
    nombre: String
) {

    var filtro by remember {
        mutableStateOf("Todos")
    }

    val listaFiltrada = when (filtro) {

        "Pizza" -> viewModel.platillos.filter {
            it.categoria == "Pizza"
        }

        "Hamburguesa" -> viewModel.platillos.filter {
            it.categoria == "Hamburguesa"
        }

        else -> viewModel.platillos
    }

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text("Hola, $nombre")
                }
            )
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("carrito")
                }
            ) {
                Text("🛒")
            }
        }

    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(12.dp)
        ) {

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Button(
                    onClick = {
                        filtro = "Todos"
                    }
                ) {
                    Text("Todos")
                }

                Button(
                    onClick = {
                        filtro = "Pizza"
                    }
                ) {
                    Text("Pizzas")
                }

                Button(
                    onClick = {
                        filtro = "Hamburguesa"
                    }
                ) {
                    Text("Hamburguesas")
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            LazyColumn {

                items(listaFiltrada) { platillo ->

                    PlatilloCard(
                        platillo = platillo,
                        onClick = {
                            navController.navigate(
                                "detalle/${platillo.id}"
                            )
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun PlatilloCard(
    platillo: Platillo,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {
                onClick()
            }
    ) {

        Column {

            AsyncImage(
                model = platillo.urlImagen,
                contentDescription = platillo.nombre,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier.padding(12.dp)
            ) {

                Text(
                    text = platillo.nombre,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = platillo.categoria
                )

                Text(
                    text = "$${platillo.precio}"
                )
            }
        }
    }
}