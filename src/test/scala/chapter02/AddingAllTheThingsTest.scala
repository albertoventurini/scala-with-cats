package chapter02

import org.scalatest.FunSuite
import cats.instances.option._
import cats.instances.int._
import chapter02.AddingAllTheThings.Order

class AddingAllTheThingsTest extends FunSuite {

  test("add_emptyList_returns0") {
    val result = AddingAllTheThings.add(List[Int]())
    assert(0 === result)
  }

  test("add_oneElement_returnsTheElement") {
    assert(1 === AddingAllTheThings.add(List(1)))
  }

  test("add_multipleElements_returnsTheSum") {
    assert(6 === AddingAllTheThings.add(List(1,2,3)))
  }

  test("add_listOfOptions_works") {
    assert(Some(6) === AddingAllTheThings.add(List(Some(1), None, Some(2), Some(3))))
  }

  test("add_listOfOrders_works") {
    assert(Order(3.0, 3.0) === AddingAllTheThings.add(List(Order(1.0, 1.0), Order(2.0, 2.0))))
  }

}
