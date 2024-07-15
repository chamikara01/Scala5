object InventoryManagementSystem {
  import scala.io.StdIn.readLine

  private def getProductList: List[String] = {
    var productList: List[String] = List()
    var continue = true

    while (continue) {
      val productName = readLine("Enter product name(type 'done' to finish): ")
      if (productName.toLowerCase == "done") {
        continue = false
      } else {
        productList = productList :+ productName
      }
    }
    productList
  }

  private def printProductList(products: List[String]): Unit = {
    for (i <- products.indices) {
      println(s"${i + 1}.${products(i)}")
    }
  }

  private def getTotalProducts(products: List[String]): Int = {
    products.length
  }

  def main(args: Array[String]): Unit = {
    val products = getProductList

    println("\nProduct List:")
    printProductList(products)
    println(s"\n${getTotalProducts(products)}")
  }
}
