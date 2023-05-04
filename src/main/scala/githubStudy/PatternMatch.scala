package githubStudy

/**
 * 模式匹配
 *
 * 本质上是提取器 unapply
 *
 * switch 有返回值
 * 不用写break break是隐含的
 * case支持任何类型
 */
object PatternMatch extends App {
  def matchTest(x: Int) = x match {
    case 1 => "one"
    case 2 => "two"
    case _ if x > 9 && x < 100 => "两位数"
    case _ => "other"
  }

  println(matchTest(1))
  println(matchTest(2))
  println(matchTest(3))
  println(matchTest(10))
}

/**
 * 匹配数据结构
 */
object matchDataStruct extends App {
  /**
   * 匹配元组
   *
   * @param x
   * @return
   */
  def matchTest(x: Any) = x match {
    case (0, _, _) => "匹配第一个元素为0的元组"
    case (a, b, c) => println(a + "~" + b + "~" + c)
    case _ => "other"
  }

  println(matchTest(0, 1, 2))
  matchTest((1, 2, 3))
  println(matchTest(Array(10, 11, 12, 14)))

  def matchArray[T](x: Array[T]) = x match {
    case Array(0) => "匹配只有一个元素0的数组"
    case Array(a, b) => println(a + "~" + b)
    case Array(10,_*)=>"第一个元素为10的数组"
    case _=>"other"
  }

  println(matchArray(Array(0)))
  matchArray(Array(0,1))
  println(matchArray(Array(10,11,12)))
  println(matchArray(Array(3,2,1)))
}

/**
 * 用作类型检查
 */
object typeCheck extends App {
  def matchTest[T](x: T) = x match {
    case x: Int => "数值型"
    case x: String => "字符型"
    case x: Float => "浮点型"
    case _ => "other"
  }

  println(matchTest(1))
  println(matchTest(10.3f))
  println(matchTest("str"))
  println(matchTest(2.1))
}

/**
 * 样例类
 *
 * 特殊的类 经过优化后可以用于模式匹配
 */
abstract class InnerPerson{}

case class Employee(name:String,age:Int,salary:Double) extends InnerPerson{}

case class Student(name:String,age:Int) extends InnerPerson{}

object PersonScala extends App{
  def matchTest(person: InnerPerson) = person match {
    case Employee(_, _, salary) => "student salary:"+salary
    case Student(name, _) => "student:"+name
    case _ => "other"
  }

  println(matchTest(Student("hebei",18)))
  println(matchTest(Employee("ying",22,9999)))
}
