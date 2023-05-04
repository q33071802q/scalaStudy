package githubStudy

class ExtendScala {
  var name = ""
  var age = 0
  protected var birthday = ""
  private var sex = ""

  def setSex(sex: String): Unit = {
    this.sex = sex;
  }

  override def toString: String = name + ":" + age + ":" + birthday + ":" + sex
}

class EmployeExtend extends ExtendScala {
  override def toString: String = "Employee~ " + super.toString

  def setBirthday(date: String): Unit = {
    birthday = date
  }
}

object ExtendScala extends App {
  val employee = new EmployeExtend;
  employee.name = "baihu";
  employee.age = 20;
  employee.setBirthday("2021-01-01")
  employee.setSex("man")
  println(employee)
}

/**
 * 类型检查
 */
object typeCheckExtend extends App {
  val employee = new EmployeExtend;
  val person = new ExtendScala;

  println(employee.isInstanceOf[ExtendScala])
  println(person.isInstanceOf[ExtendScala])

  /**
   * 强制类型转换
   */
  println(employee.getClass.toString)
  private val p: ExtendScala = employee.asInstanceOf[ExtendScala]
  println(p.getClass.toString)
  println(employee.getClass.toString)
  println(employee.getClass == classOf[EmployeExtend])
}

/**
 * 抽象类
 */
abstract class AbstractPerson {
  /**
   * 定义字段
   */
  var name: String
  var age: Int

  /**
   * 抽象方法
   * @return
   */
  def getDetail:String

  /**
   * 抽象类允许定义具体方法
   */
  def print(): Unit = {
    println("抽象类中的默认方法")
  }
}

class EmployeeAbstract extends AbstractPerson{
  /**
   * 定义字段
   */
  override var name: String = "employee"
  override var age: Int = 12



  /**
   * 抽象方法
   *
   * @return
   */
  override def getDetail: String = name+":"+age

}

object EmployeeAbstract extends App{
  val employee = new EmployeeAbstract;
  println(employee.getDetail)
}

/**
 * 特质 = interface
 * 使用trait关键字修饰
 */
trait Logger{
  /**
   * 抽象字段
   */
  var LogLevel:String
  /**
   * 具体字段
   */
  var LogType: String = "FILE"
  /**
   * 定义抽象方法
   * @param msg
   */
  def log(msg:String)

  /**
   * 定义具体方法
   * @param msg
   */
  def logInfo(msg:String): Unit = {
    println("INFO:"+msg)
  }
}

/**
 * 使用extend关键字 而不是implement 实现多个接口用with修饰
 */
class ConsoleLogger extends Logger with Serializable with Cloneable{
  /**
   * 定义抽象方法
   *
   * @param msg
   */
  override def log(msg: String): Unit = {
    println("CONSOLE:"+msg)
  }

  /**
   * 覆盖抽象字段
   */
  override var LogLevel: String = "INFO"
}


object ConsoleLogger extends App{
  val consoleLogger = new ConsoleLogger
}

/**
 * 带特质的对象
 */
object HHH extends App{
  trait Logger{
    def log(msg:String){}
  }

  trait ErrorLogger extends Logger{
    override def log(msg: String): Unit = {
      println("Error:"+msg)
    }
  }

  trait InfoLogger extends Logger{
    override def log(msg: String): Unit = {
      println("INFO:"+msg)
    }
  }

  class Person extends Logger{
    def printDetail(detail:String): Unit = {
      log(detail)
    }
  }

  private val person01 = new Person with InfoLogger
  private val person02 = new Person with ErrorLogger
  private val person03 = new Person with ErrorLogger with InfoLogger

  person01.printDetail("scala")
  person02.printDetail("scala")
  person03.printDetail("scala")
}



