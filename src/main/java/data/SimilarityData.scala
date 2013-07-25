package data

import data.CaseClasses.User

class SimilarityData {

  val userList = List.empty[User]
 // case class User(id: String, nCoordinate : Int) 

  def getUsers(): List[User] =
    {

      userList :+
        new User("1", 101010101) :+
        new User("2", 111011101) :+
        new User("3", 101010101) :+
        new User("4", 101110101) :+
        new User("5", 101110101) :+
        new User("6", 101011101) :+
        new User("7", 101010101) :+
        new User("8", 101010101) :+
        new User("9", 111000111);

    }

  def main(args: Array[String]) {
    println(getUsers.size)
  }

}
  