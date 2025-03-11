class Producto(
    var codigoProducto: String,
    val nombreProducto: String,
    var precioProducto: Double,
    var cantidadStock: Int

) {
    fun venderProducto(cantidad: Int): Boolean {
        return if (cantidad >= cantidad) {
            cantidadStock -= cantidad
            println("Se vendieron $cantidad de productos $nombreProducto, la cantidad de Stock ahora es: $cantidadStock")
            true
        } else {
            println("No hay suficientes stocks de: $nombreProducto para vender $cantidad por unidad")
            false
        }
    }
    fun reponerStock(cantidad: Int) {
        cantidadStock += cantidad
        println("Se repusieron $cantidad de productos $nombreProducto")
    }

    fun aplicarDescuento(){
        precioProducto *= 0.98
        println("Se aplico un descuento del 2% al producto $nombreProducto su precio es: $${"%.2f".format(precioProducto)}")
    }
    fun aumentarPrecio(){
        precioProducto *= 1.06
        println(" El precio del producto es: '$nombreProducto' aumentó un 6%,  Nuevo precio: $${"%.2f".format(precioProducto)}")
    }

    fun calcularValorTotalInventario(): Double {
        return cantidadStock * precioProducto
    }

    fun mostrarInformacion() {
        println(" Código Del Producto: $codigoProducto, Nombre Del Producto: $nombreProducto, Precio Del Producto: $${"%.2f".format(precioProducto)},  Cantidad Stock: $cantidadStock")
    }

}


