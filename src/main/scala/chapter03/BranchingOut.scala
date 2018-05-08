package chapter03

import cats.Functor

object BranchingOut {

  sealed trait Tree[+A]
  final case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]
  final case class Leaf[A](value: A) extends Tree[A]

  implicit val treeFunctor: Functor[Tree] = new Functor[Tree] {

    override def map[A, B](fa: Tree[A])(f: A => B): Tree[B] = fa match {
      case Leaf(i) => Leaf(f(i))
      case Branch(l, r) => Branch(map(l)(f), map(r)(f))
    }

  }

}
