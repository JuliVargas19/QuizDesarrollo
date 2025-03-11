fun main() {
    val productos = mutableListOf<Producto>()

    while (true){
        println("1. Crear Productos:")
        println("2. Vender Productos:")
        println("3. Reponer Stock:")
        println("4. Aplicar Descuento a los productos:")
        println("5. Mostrar Informacion del producto:")
        println("6. Aumentar el precio de los productos:")
        println("7. Valor total en el inventario:")
        println("8. Eliminar producto por Codigo")
        println("9. Salir..")
        println("Selecciona una opcion:")

        when (readLine()?.toIntOrNull()){
            1-> {
                println("Nombre del Producto: ")
                val nombreProducto = readLine() ?: ""
                println("Codigo del Producto: ")
                val  codigoProducto = readLine() ?: ""
                println("Precio Del Producto: ")
                val precioProducto = readLine() ?.toDoubleOrNull() ?: 0.0
                println("Cantidad Stock: ")
                val cantidadStock = readLine() ?.toIntOrNull() ?: 0

                productos.add(Producto(nombreProducto,codigoProducto,precioProducto,cantidadStock))
                println("Producto agregado con exito")
            }
            2-> {
                    print("Codigo del Producto a vender: ")
                    val codigo = readLine() ?: ""
                    val producto = productos.find { it.codigoProducto == codigo }
                    if (producto != null) {
                        print("Cantidad a vender: ")
                        val cantidad = readLine()?.toIntOrNull() ?: 0
                        producto.venderProducto(cantidad)
                    } else {
                        println("Producto no encontrado")
                    }
                }
                3 -> {
                    print("Codigo del Producto a reponer: ")
                    val codigo = readLine() ?: ""
                    val producto = productos.find { it.codigoProducto == codigo }
                    if (producto != null) {
                        print("Cantidad a reponer: ")
                        val cantidad = readLine()?.toIntOrNull() ?: 0
                        producto.reponerStock(cantidad)
                    } else {
                        println("Producto no encontrado")
                    }
                }
                4 -> productos.forEach { it.aplicarDescuento() }
                5 -> productos.forEach { it.mostrarInformacion() }
                6 -> productos.forEach { it.aumentarPrecio() }
                7 -> println("Valor total del inventario: ${productos.sumOf { it.calcularValorTotalInventario() }}")
                8 -> {
                    print("Codigo del Producto a eliminar: ")
                    val codigo = readLine() ?: ""
                    val producto = productos.find { it.codigoProducto == codigo }
                    if (producto != null) {
                        productos.remove(producto)
                        println("Producto eliminado ")
                    } else {
                        println("Producto no encontrado")
                    }
                }
                9 -> return
                else -> println("Opcion invalida, Intente de nuevo.")
            }
        }
    }

