package chapter01

import cats.Show

object CatsPrintable {
  
  // Cats provides a `Show` type class that can be easily extended
  implicit val ShowCats: Show[Cat] = Show.show(cat => s"${cat.name} is a ${cat.age} year old ${cat.color} cat")

}
