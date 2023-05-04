package githubStudy

import scala.language.implicitConversions

/**
 * 隐式转换
 */
class Implicit {

}

class PersonImplict(val name: String)

class Thor(val name: String) {
  def hammer(): Unit = {
    println(name + "举起雷神之锤")
  }
}

/**
 * implicit 声明带有单个参数的转换函数 将值从一种类型转换成另一种类型 可以使用以前没有的功能
 */
object Thor extends App {
  implicit def person2Thor(p: PersonImplict): Thor = new Thor(p.name)

  new PersonImplict("sss").hammer()
}

/**
 * 隐式参数 有点默认写入上下文的意思
 */
class Delimiters(val left: String, val right: String)

object Delimiters {
  implicit val bracket = new Delimiters("(", ")")
}

object DelimitersScala extends App {
  def formatted(context: String)(implicit deli: Delimiters): Unit = {
    println(deli.left + context + deli.right)
  }

  formatted("this is context")
}