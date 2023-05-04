package githubStudy

import java.io.{FileNotFoundException, FileReader}
import scala.collection.immutable
import scala.io.StdIn

/**
 * 条件表达式if 有返回值
 */
object ScalaApp extends App {
  val x = "scala";
  var result = if (x.length == 5) "true" else "false"
  println(result)
}

/**
 * 块表达式 最后一行代码就是块的结果
 */
object ScalaAppBlock extends App {
  val result = {
    val a = 1 + 1;
    val b = 2 + 2;
    a + b;
  }
  println(result)

  /**
   * 最后一个表达式没有返回值 则块的返回值是Unit类型
   */
  val result2 = {
    val a = 1 + 1;
    val b = 2 + 2;

  }
  println(result2)
}

/**
 * 循环 var可变 val有点类似java中的final 是个不变的
 */
object ScalaLoop extends App {
  var n = 0;

  while (n < 10) {
    n += 1;
    println(n)
  }

  do {
    println(n);
  } while (n > 10)
}

/**
 * for循环
 */
object ScalaFor extends App {
  //  for (n <- 1 until 10) println(n)
  //  for (i <- 1 to 3; j <- 1 to 3) print(f"${10 * i + j}%3d")
  //  for (i <- 1 to 3; j <- 1 to 3 if i != j) print(f"${10 * i + j}%3d")

  /**
   * 可以使用yield 关键词从for循环产生Vector 称为for推导式
   */
  private val ints: immutable.IndexedSeq[Int] = for (i <- 1 to 10) yield i * 6
  println(ints.toString())
}

/**
 * 异常处理
 */
object ScalaTry extends App {
  try {
    val reader = new FileReader("word.txt")
  } catch {
    case ex: FileNotFoundException =>
      ex.printStackTrace();
      println("没有找到对应的文件")
  } finally {
    println("一定会执行")
  }

  /**
   * finally一定会执行 所以不要在finally中返回值 否则返回值会被作为整个try语句的返回值
   *
   * @return
   */
  def g(): Int = try return 1 finally return 2

  println(g())
}

/**
 * switch scala不支持break 和continue
 */
object ScalaSwitch extends App {
  private val elements: Array[String] = Array("A", "B", "C", "D", "F")
  for (elem <- elements) {
    elem match {
      case "A" => println(10)
      case "B" => println(20)
      case "C" => println(30)
      case _ => println(50)
    }
  }
}

/**
 * 输入输出 println s表示${}要格式化的字符
 */
object ScalaInOut extends App{
  private val name: String = StdIn.readLine("Your name")
  println("your age:")
  private val age: Int = StdIn.readInt()
  println(s"Hello,${name}! Next year, you will be ${age+1}.")
}





