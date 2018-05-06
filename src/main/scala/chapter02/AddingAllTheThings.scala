package chapter02

import cats.instances.int._
import cats.instances.option._
import cats.syntax.semigroup._ // for |+|
import cats.kernel.Monoid

object AddingAllTheThings {

//  def add(items: List[Int]): Int = items match {
//    case List() => Monoid[Int].empty
//    case x :: xs => x |+| add(xs)
//  }

  // With foldLeft:
  //def add(items: List[Int]): Int = items.foldLeft(Monoid[Int].empty)(_ |+| _)

  def add[A](items: List[A])(implicit monoid: Monoid[A]): A =
    items.foldLeft(monoid.empty)(monoid.combine)


  case class Order(totalCost: Double, quantity: Double)

  implicit val orderMonoid: Monoid[Order] = new Monoid[Order] {
    override def empty: Order = Order(0, 0)
    override def combine(x: Order, y: Order): Order = Order(x.totalCost + y.totalCost, x.quantity + y.quantity)
  }
}
