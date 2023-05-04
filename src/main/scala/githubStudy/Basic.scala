package githubStudy

/**
 * 基本数据类型
 * 整数类型 Byte Short Int Long Char
 * 数值类型 Float Double
 *
 * 取值范围与java相同
 *
 */
object Basic extends App {
  val b: Byte = 1;
  val a: Short = 1;
  val c: Int = 1;
  val d: Long = 1;
  val e: Float = 1;
  val f: Double = 1;
  val g: Char = '1';
  val h: String = "1";
  val i: Boolean = false;
  val j: Unit = () //表示无值 等于java中的void 只有一个实例 写成（）
  val k: Null = null
  val l: Nothing = l //scala类层级的最低端 任何其他类型的子类型
  val m: Any = m //所有其他类的超类
  val n: AnyRef = null //是Scala里所有引用类的基类

  private val value = """hello \t"""
  println(value)

}

/**
 * 插值表达式
 *
 * 定义字符串 避免大量字符串拼接
 *
 * 定义字符串之前添加s
 * ${} 引用变量或者编写表达式
 */


object intercept extends App {
  val variable = s"${2 / 3}fsafa"
  println(variable)
}

/**
 * 赋值 没有java中的++ -- 只能+=1 -=1
 */
object assign extends App{
  var a = 1;
  a+=1;
  println(a)
}

/**
 * << >> 移位运算符
 * << 相当于自己相加几次
 * >> 相当于自己相减几次
 * +优先级还挺高
 */
object computer extends App{
  var b = 2+2;
  println(b)
  println(22 << 0)
  println(22 << 1)
  println(22 << 2)
  println(22 << 3)
  println(22 << 4)
  println(22 >> 0)
  println(22 >> 1)
  println(22 >> 2)
  println(22 >> 3)
  println(22 >> 4)
}


