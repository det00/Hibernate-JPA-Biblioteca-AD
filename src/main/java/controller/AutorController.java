package controller;

import dao.AutorDao;
import model.Autor;

public class AutorController {
    private final AutorDao autorDao = new AutorDao();

    public void crearAutor(Autor autor) {
        autorDao.crearAutor(autor);
        System.out.println("Autor creado: " + autor.getNombre() + " " + autor.getApellidos());
    }

    public void mostrarAutoresConLibros() {
        System.out.println("TODOS LOS AUTORES CON SUS LIBROS:");
        for (Autor a : autorDao.getAutoresConLibros()) {
            System.out.println("Autor: " + a.getNombre() + " " + a.getApellidos());
            a.getLibrosEscritos().forEach(l -> System.out.println(" - " + l.getTitulo()));
        }
        System.out.println();
    }
}