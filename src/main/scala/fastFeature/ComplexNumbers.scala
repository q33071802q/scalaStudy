package fastFeature

/**
 * 无对象函数
 */
object ComplexNumbers {
  def main(args: Array[String]): Unit = {
    val c = new Complex(1.2, 3.4);
    val b = new ComplexY(1.2, 3.4);
    val a = new ComplexE(1.2, 3.4);
    println(c.im())
    println(b.im)
    println(a.toString)

  }
}
