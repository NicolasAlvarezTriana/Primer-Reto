import kotlin.math.roundToInt

val dataUser = Array(3){ "" }
val nameProduct = ArrayList<String>()
val quantityProduct = ArrayList<String>()
val priceProduct = ArrayList<Int>()

fun initDataUser(){
    print("Digite su nombre: ")
    dataUser[0] = readLine() ?: ""
    print("Digite su fecha de nacimiento (DD-MM-AAAA): ")
    dataUser[1] = readLine() ?: ""
    print("Digite su número de contacto: ")
    dataUser[2] = readLine() ?: ""
}

fun requestDataProduct(){
    print("Digite producto: ")
    nameProduct.add(readLine() ?: " ")
    print("Digite cantidad productos: ")
    quantityProduct.add(readLine() ?: " ")
    print("Digite precio producto (sin comas ni puntos): ")
    priceProduct.add(readLine()?.toInt() ?: 0)
}

fun initProducts(size : Int ){
   for(i in 0 until size){
       requestDataProduct()
       println("___________________________________")
   }
}

fun initTotalPrice(size: Int) : Double{
    var sum = 0.0
    for(i in 0 until size){
        sum += priceProduct[i]
    }
    return sum
}

fun printInvoiceProducts(size: Int){
    val total = initTotalPrice(size)
    val taxedTotal = (total + (total * (0.1)))
    println("|          Invoice              |  " )
    println("| Producto | Cantidad | Precio  |  " )
    for(i in 0 until size){
        println("| ${nameProduct[i]} | ${quantityProduct[i]} | ${priceProduct[i]}  |  " )
    }
    println("| Total                  | ${total.roundToInt()} |")
    println("| Total Con Impuestos    | ${taxedTotal.roundToInt()} |")
}

fun main(){
    initDataUser()
    println("____________________________________________")
    print("Cuantos productos va registrar ${dataUser[0]}: ")
    val size = readLine()?.toInt() ?: 0
    initProducts(size)
    println("____________________________________________")
    printInvoiceProducts(size)
}
