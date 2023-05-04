package fastFeature

/**
 * 特质 Traits
 *
 * 可以从一或多个特质导入行为
 *
 * 可以看作带有实例的接口
 *
 * 当一个类继承特质时 实现了特质的接口并继承所有特质带有的功能
 *
 * Any类型在Scala中是所有类型的父类型。
 *
 * 因为同时是基本类型如Int、Float的父类型，
 *
 * 可以视作更为一般化的JavaObject类型
 */
trait Ord {
  def <(that: Any): Boolean

  def <=(that: Any): Boolean = (this < that) || (this == that)

  def >(that: Any): Boolean = !(this <= that)

  def >=(that: Any): Boolean = !(this < that)

}
