package fastFeature

object Test {
  def main(args: Array[String]): Unit = {
    val date = new Date(2023, 1, 1)
    val date1 = new Date(2023, 1, 1)
    println(date.<=(date1))
    println(date.toString)
    println(date1.toString)
  }
}
