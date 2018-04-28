package chapter01

import cats.Eq
import cats.instances.string._
import cats.instances.int._
import cats.instances.option._
import cats.syntax.eq._

// Exercise 1.5.5 -- writing this as an object with a main method,
// so that the === operator is not overridden by scalatic's implementation.
object CatsEq {

  val cat1 = Cat("Garfield",   38, "orange and black")
  val cat2 = Cat("Heathcliff", 33, "orange and black")
  val optionCat1 = Option(cat1)
  val optionCat2 = Option.empty[Cat]

  implicit val catsEq: Eq[Cat] = Eq.instance[Cat] {
    (c1, c2) => c1.color === c2.color && c1.age === c2.age && c1.name === c2.name
  }

  def main(args: Array[String]): Unit = {
    assert(cat1 === cat1)
    assert(cat1 =!= cat2)
    assert(optionCat1 === optionCat1)
    assert(optionCat1 =!= optionCat2)
  }

}
