package controller;

import dao.LibreriaDao;
import model.Libreria;

public class LibreriaController {
    private final LibreriaDao libreriaDao = new LibreriaDao();

    public void crearLibreria(Libreria libreria) {
        libreriaDao.crearLibreria(libreria);
        System.out.println("Librería creada: " + libreria.getNombre());
    }

    public void mostrarLibreriasConLibros() {
        System.out.println("TODAS LAS LIBRERIAS CON SUS LIBROS:");
        for (Libreria l : libreriaDao.getLibreriasConLibros()) {
            System.out.println("Librería: " + l.getNombre());
            l.getColeccionLibros().forEach(libro -> System.out.println(" - " + libro.getTitulo()));
        }
        System.out.println();
    }
}