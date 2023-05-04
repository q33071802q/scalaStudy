package fastFeature

object IntegerReference {
  def main(args: Array[String]): Unit = {
    val cell = new Reference[Int]
    cell.set(13)
    println(cell.get * 2)
  }
}
