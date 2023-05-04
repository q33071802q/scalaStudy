package fastFeature

/**
 * 泛型
 *
 * 将类型作为程序参数
 *
 * scala借可定义泛型类跟函数解决动态转型问题。
 *
 * 引用 可以是空的 、 指向某类型的对象
 *
 * @tparam T
 */
class Reference[T] {
  /**
   * _表示预设值 数值 0、boolean false、Unit （） 所有对象 null
   */
  private var contents: T = _

  def set(value: T): Unit = {
    contents = value;
  }

  def get: T = contents;
}
