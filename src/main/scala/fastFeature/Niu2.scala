package fastFeature

/**
 * 模式匹配是检查某个值 是否匹配某一个模式的机制
 *
 * 一个成功的匹配同时会将匹配值解构成某组成部分
 *
 * 是Java的switch升级版 同样可以替代一系列 if/else
 */


object Niu2 {
  type Environment = String => Int

  def main(args: Array[String]): Unit = {
    println(matchTest(1))
    val exp: Tree = Sum(Sum(Var("x"), Var("x")), Sum(Const(7), Var("y")))
    val env: Environment = {
      case "x" => 5
      case "y" => 7
    }
    println("Expression: " + exp)
    println("Evaluation with x=5, y=7: " + eval(exp, env))
    println("Derivative relative to x:\n " + derive(exp, "x"))
    println("Derivative relative to y:\n " + derive(exp, "y"))
  }

  def matchTest(x: Int): String = x match {
    case 0 => "zero"
    case 1 => "one"
    case 2 => "two"
  }


  def eval(t: Tree, env: Environment): Int = t match {
    case Sum(l, r) => eval(l, env) + eval(r, env);
    case Var(n) => env(n)
    case Const(v) => v
  }

  /**
   * _代表任何值的万用字符
   *
   * @param t
   * @param v
   * @return
   */
  def derive(t: Tree, v: String): Tree = t match {
    case Sum(l, r) => Sum(derive(l, v), derive(r, v));
    case Var(n) if (v == n) => Const(1)
    case _ => Const(0)
  }
}
