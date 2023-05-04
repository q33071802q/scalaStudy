package fastFeature

/**
 * 创建类实例时不需要用new 直接Const(5)
 *
 *
 */
object Niu {
  def main(args: Array[String]): Unit = {
    val sum = Sum(Const(1), Const(1));
    println(sum.toString)
    println(sum.l)
  }
}
