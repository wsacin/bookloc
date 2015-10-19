package bookloc

class Fachada {
    private BookController controllerLivro
    private LibrarianController controllerBibliotecario
    private UserController controllerUsuario

    public Fachada() {
        this.controllerLivro = new BookController()
        this.controllerBibliotecario = new LibrarianController()
        this.controllerUsuario = new UserController()
    }

    def editarLivro(Book book) {
        controllerLivro.update();
    }
    def buscarLivro(Book book) {
        controllerLivro.show(book)
    }
    def criarLivro(){
        controllerLivro.create()
    }
    def removerLivro(){
        controllerLivro.delete()
    }

    def editarUsuario(User user) {
        controllerUsuario.update(user);
    }
    def buscarUsuario(User user) {
        controllerUsuario.show(user)
    }
    def criarUsuario(){
        controllerUsuario.create()
    }
    def removerUsuario(User user){
        controllerUsuario.delete(user)
    }

}
