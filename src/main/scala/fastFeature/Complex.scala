package fastFeature

/**
 * scala面向对象语言 类的概念 声明类的语法与java接近
 *
 * 最主要的差别在于 scala的类可以有参数
 *
 * 接收两个参数 实部和虚部 创造Complex的实例时
 *
 * 必须传入这些参数 new fastFeature.Complex(1.5,2.3)
 *
 * 这个类有两个函数
 *
 * 可以理解成java的类构造函数
 */
class Complex(real: Double, imaginary: Double) {
  def re() = real

  def im() = imaginary;
}

/**
 * scala所有的类都继承自一个父类。
 *
 * 没有指定的话，会默认使用scala.AnyRef
 *
 *
 * @param real
 * @param imaginary
 */
class ComplexE(real: Double, imaginary: Double) {
  def re = real

  def im = imaginary;

  /**
   * 可以重写继承父类的函数。为了避免意外重写
   *
   * 必须加上 override 修饰字明确表示要重写函数。
   *
   * @return
   */
  override def toString =
    ""+re+({
      if (im<0) "" else "+"
    })+im+"i";
}

/**
 * 可以去掉函数的括号 直接就成类的成员属性了
 * @param real
 * @param imaginary
 */
class ComplexY(real: Double, imaginary: Double) {
  def re = real

  def im = imaginary;
}
