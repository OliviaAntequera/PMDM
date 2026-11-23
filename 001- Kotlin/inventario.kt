
fun main() {
    val stock = listOf(25, 0, 8, -3, 50, 3)

    val proveedor = "Sin proveedor"

    var agotados = 0
    var stockBajo = 0
    var total = 0
    var productosValidos = 0

    println("Proveedor: $proveedor")

    // Numerar productos
    for ((indice, unidades) in stock.withIndex()) {

        val numeroProducto = indice + 1

        // Comprobación unidades negativas
        if (unidades < 0) {
            println("Producto $numeroProducto: Dato erróneo")
            continue
        }

        // Suma unidades y contar productos validos
        total += unidades
        productosValidos++

        // Estado producto
        val estado = when {
            unidades == 0 -> {
                agotados++
                "Agotado"
            }
            unidades in 1..9 -> {
                stockBajo++
                "Stock bajo"
            }
            unidades in 10..29 -> "Stock normal"
            else -> "Stock alto"
        }

        println("Producto $numeroProducto: $unidades uds ($estado)")
    }

    // Calcular media
    val media = if (productosValidos > 0) {
        total / productosValidos
    } else {
        0
    }

    // Print resultados
    println("Agotados: $agotados. Stock bajo: $stockBajo.")
    println("Total: $total uds. Media: $media.")

    // Comprobar si hay que hacer pedidos
    if (agotados > 0 || stockBajo > 0) {
        println("Hay que hacer un pedido.")
    } else {
        println("No hace falta pedido.")
    }
}
