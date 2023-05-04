package githubStudy

import githubStudy.Color.Color

import scala.beans.BeanProperty

/**
 * 类和对象
 */
class ClassAndObject {

}

/**
 * scala中 类不需要public声明 所有类都具有公共可见性
 */
class Person {

  /**
   * 声明私有变量 用var 修饰的变量默认拥有getter/setter属性
   */
  private var age = 0

  /**
   * 声明的变量不需要进行初始赋值 此时Scala无法进行类型判断
   *
   * 需要显式指明类型
   */
  private var name: String = _

  /**
   * 定义方法 应该指明传参类型。返回值类型不是必须的。
   *
   * Scala可以自动推断出来 为了方便调用者 建议指明
   */
  def growUp(step: Int): Unit = {
    age += step;
  }

  /**
   * 改值器方法 改变对象状态的方法 即使不需要传入参数 也建议声明中包含（）
   */
  def growUpFix(): Unit = {
    age += 10;
  }

  /**
   * 取值器方法 不会改变对象状态的方法 不必在声明中包含（）
   */
  def currentAge: Int = {
    age;
  }

  /**
   * 不建议使用return 关键字 默认方法中最后一行代码的计算结果是返回值
   * 如果方法简短 可以写在同一行 :表示类型 = 表示赋值
   */
  def getName: String = name;
}

/**
 * 伴生对象
 */
object Person {
  def main(args: Array[String]): Unit = {
    val counter = new Person()
    counter.age = 12;
    counter.growUp(8);
    counter.growUpFix();
    println(counter.age)
    println(counter.currentAge)
    println(counter.getName)
  }
}

/**
 * 类
 *
 * 成员变量默认都是public 不被干扰 private 通过getter setter访问
 *
 * var 变量同时拥有getter、setter
 * val 只拥有getter
 * private[this] 变量既没有getter、也没有setter 只能通过内部方法访问
 *
 * age get age
 * set age_=
 */
class ClassPerson {
  private val name = "heibaiying"
  private var age = 12
  private[this] var birthday = "2019-08-08"

  //birthday 只能被内部访问
  def getBirthday: String = birthday;
}

object ClassPerson {
  def main(args: Array[String]): Unit = {
    val person = new ClassPerson
    /*
    实际上调用的是person.age_=30
     */
    person.age = 30
    println(person.name)
    println(person.getBirthday)

    /**
     * 实际调用person.age()
     */
    println(person.age)
  }
}

/**
 * 想要额外生成get set方法 用@BeanProperty注解
 */
class BeanPerson {
  @BeanProperty
  var name = ""
}

object BeanPerson {
  def main(args: Array[String]): Unit = {
    val person = new BeanPerson
    person.setName("niu")
    println(person.getName)
  }
}

/**
 * 主构造器直接写在类名后面
 *
 * 主构造器传入的参数默认就是val类型 不可变 没有办法在内部改变传参
 *
 * 写在主构造器中的代码块会在类初始化时候执行 功能类似Java的静态代码块static{}
 *
 * @param name
 * @param age
 */
class ConstructPerson(val name: String, val age: Int) {
  println("功能类似Java的静态代码块 static{}")

  def getDetail: String = {
    name + ":" + age
  }

}

object ConstructPerson {
  def main(args: Array[String]): Unit = {
    val niu = new ConstructPerson("niu", 22)
    println(niu.getDetail)
  }
}

/**
 * 辅助构造器
 * 两点硬性要求
 * 名称为this
 * 每个辅助构造器必须以主构造器或其他的辅助构造器的调用开始
 */
class AuxiliaryConstructPerson(val name: String, val age: Int) {
  private var birthday = ""

  def this(name: String, age: Int, birthday: String) {
    //必须以主构造器或者其他构造器开始
    this(name, age)
    this.birthday = birthday
  }

  override def toString: String = name + ":" + age + ":" + birthday
}

object AuxiliaryConstructPerson {
  def main(args: Array[String]): Unit = {
    println(new AuxiliaryConstructPerson("heibaiying", 20, "2"))
  }
}

/**
 * 方法传参不可变
 *
 * 默认为val类型 意味着在方法体内部不能改变传入的参数
 *
 * scala遵循函数式编程 强调方法不应该有副作用
 */
class ImmutableMethodPerson {
  def low(word: String): String = {
    //    word = "word" //无法编译
    word.toLowerCase
  }
}

/**
 * 对象作用
 *
 * object 中的变量和方法都是静态的 所以可以用来存放工具类
 *
 * 可以用来存放单例对象的容器
 *
 * 可以作为类的伴生对象
 *
 * 可以拓展类或特质 extend
 *
 *
 * 工具类
 */
object Utils {
  /**
   * 相当于Java中的静态代码块static 在对象初始化时候被执行
   *
   * 这种方式实现的单例模式是饿汉式单例，即无论是否用到 都会一开始初始化完成
   */
  val person = new NiuPerson;
  /**
   * 全局固定常量 = java的 public static final
   */
  val CONSTANT = "固定常量"

  /**
   * 全局静态方法
   *
   * @param word
   * @return
   */
  def low(word: String): String = {
    word.toLowerCase
  }
}

class NiuPerson {
  println("NiuPerson 默认构造器创建")
}

object NiuPerson extends App {
  /**
   * 判断是否单例
   */
  println(Utils.person == Utils.person)
  println(Utils.CONSTANT)
  println(Utils.low("afHHH"))
}

/**
 * 伴生对象
 *
 * scala类与类同名的伴生对象 两者必须在同一个文件中
 */
class AccompanyPerson() {
  private val name = "HEI"

  def getName: String = {
    AccompanyPerson.toLow(AccompanyPerson.PREFIX + name)
  }
}

object AccompanyPerson {
  val PREFIX = "prefix-"

  def toLow(word: String): String = {
    word.toLowerCase
  }

  def main(args: Array[String]): Unit = {
    val person = new AccompanyPerson
    println(person.getName)
  }
}

/**
 * 枚举 scala没有枚举类 需要拓展Enumeration 调用Value对所有枚举值进行初始化
 */
object Color extends Enumeration {
  //类型别名
  type Color = Value
  val GREEN = Value
  val RED = Value(3)
  val BULE = Value("blue")
  val YELLOW = Value(5, "yellow")
  val PINK = Value
}

object ScalaColor extends App {
  def printColor(color: Color): Unit = {
    println(color.toString)
  }

  println(Color.YELLOW.toString == "yellow")
  for (c <- Color.values) println(c.id + ":" + c.toString)
}

