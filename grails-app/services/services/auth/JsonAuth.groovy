package services.auth

import bookloc.Book
import bookloc.User
import grails.converters.JSON
import groovy.json.JsonSlurper
import services.repositorios.RepBook
import services.repositorios.RepUser

class JsonAuth {

    RepBook repBook = new RepBook()
    RepUser repUser = new RepUser()

    final HashMap authuser(JSON json){
        def slurper = new JsonSlurper()
        def jsonMap = slurper.parseText(json.toString())
        def rentedBooks = []

        Book book = repBook.findByISBN(jsonMap.isbn)
        if(book == null)
            return [status:"FAILED",message:"No such book with isbn $jsonMap.isbn"]

        User user = repUser.findByName(jsonMap.username)
        if(user == null)
            return [status:"FAILED",message:"No such user with name $jsonMap.username"]

        if(jsonMap.password == user.password) {
            if(user.rentedBooks == null)
                user.rentedBooks = ""
            rentedBooks = user.rentedBooks.split(',')
            rentedBooks += [book.isbn]
            user.rentedBooks = rentedBooks.toString()[1..rentedBooks.toString().size()-2].replaceAll(" ","")
            repUser.save(user)
        }
        else
            return [status:"FAILED",message:"Invalid password"]

        return [user:user,book:book,isbn:jsonMap.isbn,status:"SUCCESS"]
    }
}
