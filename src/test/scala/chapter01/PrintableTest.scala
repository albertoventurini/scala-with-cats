package chapter01

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

import PrintableInstances._
import PrintableSyntax._

@RunWith(classOf[JUnitRunner])
class PrintableTest extends FunSuite {

  val cat: Cat = Cat("Romeo", 18, "black")

  test("PrintableCanPrintCats") {
    val printed: String = Printable.format(cat)

    assert(printed === "Romeo is a 18 year old black cat")
  }

  test("PrintableSyntaxWorks") {
    val printed: String = cat.format

    assert(printed === "Romeo is a 18 year old black cat")
  }

}
