package controller;

import dao.LibroDao;
import model.Libreria;
import model.Libro;

public class LibroController {
    LibroDao libroDao = new LibroDao();

    public void getLibrosEditorialAutor(){
        for (Libro l : libroDao.getLibros()) {
            System.out.println("Libro: " + l.getTitulo());
            System.out.println(" - Editorial: " + l.getEditorial().getNombre());
            System.out.println(" - Autor: " + l.getAutor().getNombre());
            System.out.println();
        }
    }

    public void getLibrosLibrerias(){
        for (Libro l : libroDao.getLibros()) {
            System.out.println("Libro: " + l.getTitulo());
            for (Libreria lb : l.getLibrerias()) {
                System.out.println(" - " + lb.getNombre());
            }
            System.out.println();
        }
    }
}
