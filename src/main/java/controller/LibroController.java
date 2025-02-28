package controller;

import dao.LibroDao;
import model.Libro;

public class LibroController {
    private final LibroDao libroDao = new LibroDao();

    public void crearLibro(Libro libro) {
        libroDao.crearLibro(libro);
        System.out.println("Libro creado: " + libro.getTitulo());
    }

    public void mostrarLibrosConEditorialYAutor() {
        System.out.println("TODOS LOS LIBROS CON SU EDITORIAL Y AUTOR:");
        for (Libro l : libroDao.getLibrosConEditorialYAutor()) {
            System.out.println(l.getTitulo() + " - " + l.getAutor().getNombre() +
                    " " + l.getAutor().getApellidos() +
                    " (Editorial: " + l.getEditorial().getNombre() + ")");
        }
        System.out.println();
    }

    public void mostrarLibrosConLibreria() {
        System.out.println("TODOS LOS LIBROS Y LAS LIBRERIAS EN LAS QUE ESTAN:");
        for (Libro l : libroDao.getLibrosConLibreria()) {
            System.out.print(l.getTitulo() + " está en: ");
            l.getLibrerias().forEach(libreria -> System.out.print(libreria.getNombre() + ", "));
            System.out.println();
        }
        System.out.println();
    }
}