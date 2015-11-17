package entidades

class User {
    String name
    String password
    String cpf
    Date dateOfBirth
    String rentedBooks

    static constraints = {
        rentedBooks nullable: true
    }
    static mapping = {
        rentedBooks defaultValue: "''"
    }
}
