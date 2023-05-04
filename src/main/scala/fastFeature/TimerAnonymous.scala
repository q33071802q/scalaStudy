package fastFeature

/**
 * 匿名函数 赋予一个只被使用一次的函数没有意义 =》表示匿名函数
 */
object TimerAnonymous {
  def oncePerSecond(callback: () => Unit): Unit = {
    while (true) {
      callback();
      Thread sleep 1000
    }
  }

  def main(args: Array[String]): Unit = {
    oncePerSecond(() => println("yyy"))
  }
}
