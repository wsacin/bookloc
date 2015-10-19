package bookloc

class Book {
    Long id
    String title
    String publisher
    String isbn
    Boolean isRented
    Long shelf
    Long rack

    static constraints = {
    }
}
