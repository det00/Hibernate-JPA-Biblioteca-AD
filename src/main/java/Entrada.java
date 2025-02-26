
import controller.AutorController;
import controller.LibreriaController;
import controller.LibroController;


public class Entrada {
    public static void main(String[] args) {
        LibroController libroController = new LibroController();
        LibreriaController libreriaController = new LibreriaController();
        AutorController autorController = new AutorController();

        libroController.getLibrosEditorialAutor();
        libroController.getLibrosLibrerias();

        libreriaController.getLibreriaLibros();

        autorController.getAutoresLibros();




    }
}