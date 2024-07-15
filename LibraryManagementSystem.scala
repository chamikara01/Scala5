object LibraryManagementSystem {
  private var library: Set[Book] = Set(
    Book("Madoldoowa", "Martin Wick", "1234567890"),
    Book("HathPana", "Kumarathunga Munidasa", "0987654321"),
    Book("Nil Katarolu", "Mohan Raj", "1122334455")
  )

  private def addBook(book: Book): Unit = {
    library += book
    println(s"Book added: ${book.title}")
  }

  private def removeBookByISBN(isbn: String): Unit = {
    library = library.filterNot(_.isbn == isbn)
    println(s"Book with ISBN $isbn removed.")
  }

  private def isBookInLibrary(isbn: String): Boolean = {
    library.exists(_.isbn == isbn)
  }

  private def displayLibrary(): Unit = {
    println("Current Library Collection:")
    library.foreach { book =>
      println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")
    }
  }

  private def searchBookByTitle(title: String): Unit = {
    val bookOption = library.find(_.title.toLowerCase == title.toLowerCase)
    bookOption match {
      case Some(book) => println(s"Book found: Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")
      case None => println(s"Book with title '$title' not found.")
    }
  }

  private def displayBooksByAuthor(author: String): Unit = {
    val booksByAuthor = library.filter(_.author.toLowerCase == author.toLowerCase)
    println(s"Books by $author:")
    booksByAuthor.foreach { book =>
      println(s"Title: ${book.title}, ISBN: ${book.isbn}")
    }
  }

  def main(args: Array[String]): Unit = {
    displayLibrary()

    addBook(Book("MagulKaama", "Kumarathunga Munidasa", "2233445566"))

    removeBookByISBN("0987654321")

    println(s"Is book with ISBN 1122334455 in library? ${isBookInLibrary("1122334455")}")

    searchBookByTitle("Madoldoowa")

    displayBooksByAuthor("Kumarathunga munidasa")

    displayLibrary()
  }
}
