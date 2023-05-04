package fastFeature

import scala.sys.error

/**
 * 继承Ord特质
 *
 * @param y
 * @param m
 * @param d
 */
class Date(y: Int, m: Int, d: Int) extends Ord {
  def year = y;

  def month = m;

  def day = d;

  override def toString: String = s"$year-$month-$day"

  /**
   * 重新定义equal 根据属性比较日期
   *
   * @param that
   * @return
   */
  override def equals(that: Any): Boolean =
    that.isInstanceOf[Date] && {
      val o = that.asInstanceOf[Date]
      o.day == day && o.month == month && o.year == year
    }

  def <(that: Any): Boolean = {
    if (!that.isInstanceOf[Date])
      error("cannot compare " + that + " and a Date")

    val o = that.asInstanceOf[Date]
    (year < o.year) ||
      (year == o.year && (month < o.month ||
        (month == o.month && day < o.day)))
  }


}
