package controller;

import dao.LibreriaDao;
import model.Libreria;
import model.Libro;

public class LibreriaController {
    LibreriaDao libreriaDao = new LibreriaDao();
    public void getLibreriaLibros(){
        for (Libreria l : libreriaDao.getLibrerias()) {
            System.out.println("Librería: " + l.getNombre());
            for (Libro libro : l.getColeccionLibros()) {
                System.out.println(" - " + libro.getTitulo());
            }
            System.out.println();
        }
    }
}
