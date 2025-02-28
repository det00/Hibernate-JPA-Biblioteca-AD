import controller.AutorController;
import controller.EditorialController;
import controller.LibroController;
import controller.LibreriaController;
import model.Autor;
import model.Editorial;
import model.Libro;
import model.Libreria;

import java.util.ArrayList;
import java.util.List;

public class Entrada {
    public static void main(String[] args) {
        AutorController autorController = new AutorController();
        EditorialController editorialController = new EditorialController();
        LibroController libroController = new LibroController();
        LibreriaController libreriaController = new LibreriaController();

        // crear 3 autores
        Autor autor1 = new Autor("Gabriel", "García Márquez");
        Autor autor2 = new Autor("Isabel", "Allende");
        Autor autor3 = new Autor("Julio", "Cortázar");

        autorController.crearAutor(autor1);
        autorController.crearAutor(autor2);
        autorController.crearAutor(autor3);

        // crear 2 editoriales
        Editorial editorial1 = new Editorial();
        editorial1.setNombre("Editorial Sudamericana");
        editorial1.setDireccion("Buenos Aires, Argentina");

        Editorial editorial2 = new Editorial();
        editorial2.setNombre("Editorial Planeta");
        editorial2.setDireccion("Barcelona, España");

        editorialController.crearEditorial(editorial1);
        editorialController.crearEditorial(editorial2);

        // crear 8 libros
        List<Libro> libros = new ArrayList<>();

        libros.add(new Libro(0, "Cien años de soledad", 25.99, editorial1, autor1, new ArrayList<>()));
        libros.add(new Libro(0, "El otoño del patriarca", 20.50, editorial2, autor1, new ArrayList<>()));
        libros.add(new Libro(0, "La casa de los espíritus", 18.75, editorial1, autor2, new ArrayList<>()));
        libros.add(new Libro(0, "Eva Luna", 22.40, editorial2, autor2, new ArrayList<>()));
        libros.add(new Libro(0, "Rayuela", 27.99, editorial1, autor3, new ArrayList<>()));
        libros.add(new Libro(0, "Final del juego", 19.60, editorial2, autor3, new ArrayList<>()));
        libros.add(new Libro(0, "Crónica de una muerte anunciada", 21.30, editorial1, autor1, new ArrayList<>()));
        libros.add(new Libro(0, "De amor y de sombra", 23.10, editorial2, autor2, new ArrayList<>()));

        for (Libro libro : libros) {
            libroController.crearLibro(libro);
        }

        // crear 2 librerías con 4 libros cada una
        Libreria libreria1 = new Libreria();
        libreria1.setNombre("Librería Central");
        libreria1.setNombrePropietario("Ana Pérez");
        libreria1.setDireccion("Calle Mayor 45, Madrid");
        libreria1.setColeccionLibros(libros.subList(0, 4)); // Primeros 4 libros

        Libreria libreria2 = new Libreria();
        libreria2.setNombre("Librería del Sur");
        libreria2.setNombrePropietario("Carlos Gómez");
        libreria2.setDireccion("Avenida Libertador 120, Buenos Aires");
        libreria2.setColeccionLibros(libros.subList(4, 8)); // Últimos 4 libros

        libreriaController.crearLibreria(libreria1);
        libreriaController.crearLibreria(libreria2);

        System.out.println("Se ha completado la creación de autores, editoriales, libros y librerías.");



        libroController.mostrarLibrosConEditorialYAutor();

        autorController.mostrarAutoresConLibros();

        libreriaController.mostrarLibreriasConLibros();

        libroController.mostrarLibrosConLibreria();

    }
}