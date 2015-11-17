package entidades

class Book {
    String title
    String publisher
    String isbn
    Boolean isRented
    Long shelf
    Long rack

    static constraints = {
        isRented nullable: true
    }
    static mapping = {
        isRented defaultValue: "false"
    }
}
