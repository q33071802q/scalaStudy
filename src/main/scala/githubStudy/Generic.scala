package githubStudy

/**
 * 泛型
 */
class Generic {

}

/**
 * java用<> scala用[]
 *
 * @param first
 * @param second
 * @tparam T
 * @tparam S
 */
class Pair[T, S](val first: T, val second: S) {
  override def toString: String = first + ":" + second
}

object PairScala extends App {
  var pair01 = new Pair("heibai01", 22);
  var pair02 = new Pair[String, Int]("heibai02", 22);

  println(pair01)
  println(pair02)
}

/**
 * 泛型方法
 */
object GenericUtils {
  def getHalf[T](a: Array[T]): Int = a.length / 2
}

/**
 * <: 符号 限定必须是Comparable的子类型
 * @param first
 * @param second
 * @tparam T
 */
class UpPair[T <: Comparable[T]](val first: T, val second: T) {
  def smaller:T = if (first.compareTo(second)<0) first else second
}

object UpPair extends App{
  val upPair = new UpPair("abc","abcd");
  println(upPair.smaller)
}









