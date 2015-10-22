package bookloc

class Fachada {
    private BookController controllerLivro
    private LibrarianController controllerBibliotecario
    private UserController controllerUsuario
    private AuthAdapter adaptadorAutenticacao

    public Fachada() {
        this.controllerLivro = new BookController()
        this.controllerBibliotecario = new LibrarianController()
        this.controllerUsuario = new UserController()
        this.adaptadorAutenticacao = new AuthAdapter()
    }

    def editarLivro(Book book) {
        controllerLivro.update();
    }
    def buscarLivro(Book book) {
        controllerLivro.show(book)
    }
    def criarLivro() {
        controllerLivro.create()
    }
    def removerLivro() {
        controllerLivro.delete()
    }

    def autenticarLocacao(String authPayload) {
        def rentInfo = adaptadorAutenticacao.authUser(authPayload)
        controllerUsuario.checkCredentials(rentInfo.name,rentInfo.passwd)
        controllerLivro.markAsRented(rentInfo.idlivro)
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
