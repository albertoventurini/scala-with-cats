package chapter01

// Type class
trait Printable[A] {
  def format(value: A): String
}

// Type class instances
object PrintableInstances {

  implicit val PrintableString: Printable[String] = new Printable[String] {
    override def format(value: String): String = value
  }

  implicit val PrintableInt: Printable[Int] = new Printable[Int] {
    override def format(value: Int): String = value.toString
  }

  implicit val printableCat: Printable[Cat] = new Printable[Cat] {
    override def format(value: Cat): String = s"${value.name} is a ${value.age} year old ${value.color} cat"
  }
}

// Companion object interface to the type class
object Printable {
  def format[A](value: A)(implicit p: Printable[A]): String = {
    p.format(value)
  }

  def print[A](value: A)(implicit p: Printable[A]): Unit = println(format(value))
}

// Alternative syntax: implicit classes
object PrintableSyntax {
  implicit class PrintableOps[A](value: A) {

    // Extension method to automatically format an A to a String
    def format(implicit p: Printable[A]): String = p.format(value)
  }
}