package chapter03

import chapter03.BranchingOut._
import org.scalatest.FunSuite
import cats.syntax.functor._

class BranchingOutTest extends FunSuite {

  test("mapWorks") {
    val tree: Tree[Int] = Branch(Branch(Leaf(1), Leaf(2)), Leaf(3))

    assert(tree.map(i => i + 1) === Branch(Branch(Leaf(2), Leaf(3)), Leaf(4)))
  }

}
