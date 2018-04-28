package chapter01

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

import CatsPrintable._
import cats.implicits._

@RunWith(classOf[JUnitRunner])
class CatsPrintableTest extends FunSuite {

  test("DefiningAnInstanceOfShowWorks") {
    val cat: Cat = Cat("Romeo", 18, "black")

    assert("Romeo is a 18 year old black cat" == cat.show)
  }

}
