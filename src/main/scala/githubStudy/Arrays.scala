package githubStudy

import java.util
import scala.collection.{JavaConverters, mutable}
import scala.collection.mutable.ArrayBuffer

/**
 * 虚拟机层面 Array[Int]() 等价 Java Int[]
 * 用（index）访问 访问元素 相当于方法调用 .apply（index）
 */
object ArraysScala {
  def main(args: Array[String]): Unit = {
    val nums = new Array[Int](10);
    println(nums.mkString("Array(", ", ", ")"))

    val stringNums = new Array[String](10);
    println(stringNums.mkString("Array(", ", ", ")"))

    val a = Array("hello", "scala");
    println(a.mkString("-"))
    println(a(0))
  }
}

/**
 * 变长数组
 *
 * ArrayBuffer 实现变长数组 构造的时候必须给出类型参数 长度不是必须
 * 会在需要的时候自动扩容和缩容
 */
object changeAbleApp {
  def main(args: Array[String]): Unit = {
    val ab = new ArrayBuffer[Int]()
    ab += 1
    println(ab.mkString("-"))
    ab += (2, 3, 4)
    println(ab.mkString("-"))

    /**
     * 可以拼接集合 是真牛逼
     */
    ab ++= Array(5, 6, 7)
    println(ab.mkString("-"))

    /**
     * 移除最后几个元素
     */
    ab.trimEnd(3)
    println(ab.mkString("-"))

    /**
     * insert 末尾的+=1 时间复杂度 O（1） 随机位置则为 O（n）
     */
    ab.insert(4, 1);
    println(ab.mkString("-"))

    /**
     * 从某个位置开始移除元素
     */
    ab.remove(2, 3)
    println(ab.mkString("-"))

    /**
     * 转定长
     */
    val abToA = ab.toArray
    println(abToA.mkString("-"))

    /**
     * 定长转可变
     */
    val buffer = ab.toBuffer

  }
}

/**
 * 数组遍历
 * 继承App.scala 等于写在main方法里了
 */
object ArrayScalaLoop extends App {
  val a = Array(1, 2, 3, 4, 5, 6, 7);
  for (elem <- a) {
    print(elem)
  }

  println();
  for (index <- 0 until a.length) {
    print(a(index))
  }

  println();
  for (index <- a.indices) {
    print(a(index))
  }

  println()
  for (index <- a.indices.reverse) {
    print(a(index))
  }
}

/**
 * 数组转换 现有数组产生新数组
 */
object TransferApp extends App {
  val a = Array(1, 2, 3, 4, 5, 6);

  /**
   * yield关键字 有点停顿的意思 可以在循环中对每个元素处理
   */
  val ints = for (elem <- a if elem % 2 == 0) yield 10 * elem
  for (elem <- ints) {
    println(elem)
  }

  val ints2 = a.filter(_ % 2 == 0).map(_ * 10);
  for (elem <- ints2) {
    println(elem)
  }
}

/**
 * 多维数组
 */
object ScalaMultiple extends App{
  val matrix = Array(Array(11,12),Array(21,22))
  for (elem <- matrix) {
    for (elem <- elem) {
      print(elem+"-")
    }
    println()
  }
}

object ScalaJava extends App{
  val element = ArrayBuffer("hadoop","spark","storm")
  private val javaList: util.List[String] = JavaConverters.bufferAsJavaList(element)
  private val scalaBuffer: mutable.Buffer[String] = JavaConverters.asScalaBuffer(javaList)
  for (elem <- scalaBuffer) {
    println(elem)
  }
}

