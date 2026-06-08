package com.example.examenapp.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.examenapp.model.Platillo

class BiteBoxViewModel : ViewModel() {

    val carrito = mutableStateListOf<Platillo>()

    val platillos = listOf(

        Platillo(
            1,
            "Pizza Pepperoni",
            "Deliciosa pizza con pepperoni y queso mozzarella.",
            12.50,
            "Pizza",
            "https://images.unsplash.com/photo-1513104890138-7c749659a591"
        ),

        Platillo(
            2,
            "Pizza Hawaiana",
            "Pizza con jamón y piña.",
            11.30,
            "Pizza",
            "https://images.unsplash.com/photo-1594007654729-407eedc4be65"
        ),

        Platillo(
            3,
            "Pizza Suprema",
            "Pizza con vegetales y carnes seleccionadas.",
            14.50,
            "Pizza",
            "https://images.unsplash.com/photo-1565299624946-b28f40a0ae38"
        ),

        Platillo(
            4,
            "Pizza Margarita",
            "Pizza con Salsa de tomate de San Marzano, mozzarella fresca, hojas de albahaca y un toque de aceite de oliva.Masa.",
            14.50,
            "Pizza",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRgI9Od6nFmvyEjWe0voHqRkUSmrqypzJOC0Nmehzox-g&s=10"

        ),

        Platillo(
            5,
            "Hamburguesa Clásica",
            "Hamburguesa de res con queso cheddar.",
            8.50,
            "Hamburguesa",
            "https://images.unsplash.com/photo-1568901346375-23c9450c58cd"
        ),

        Platillo(
            6,
            "Hamburguesa BBQ",
            "Hamburguesa con salsa BBQ y tocino.",
            10.50,
            "Hamburguesa",
            "https://images.unsplash.com/photo-1550547660-d9450f859349"
        ),

        Platillo(
            7,
            "Hamburguesa Doble.",
            "Doble carne y doble queso.",
            12.75,
            "Hamburguesa",
            "https://images.unsplash.com/photo-1571091718767-18b5b1457add"
        ),
        Platillo(
            8,
            "Hamburguesa Vegetariana",
            "Hamburguesa elaborada con proteína vegetal, lechuga, tomate y salsa especial.",
            14.50,
            "Hamburguesa",
            "https://images.unsplash.com/photo-1520072959219-c595dc870360"
        )
    )

    fun agregarAlCarrito(platillo: Platillo) {
        carrito.add(platillo)
    }

    fun vaciarCarrito() {
        carrito.clear()
    }

    fun calcularTotal(): Double {
        return carrito.sumOf { it.precio }
    }

    fun obtenerPlatilloPorId(id: Int): Platillo? {
        return platillos.find { it.id == id }
    }
}