package controller;


import dao.AutorDao;
import dao.LibreriaDao;
import dao.LibroDao;
import model.Autor;
import model.Libro;

public class AutorController {

    AutorDao autorDao = new AutorDao();

    public void getAutoresLibros(){
        for (Autor a : autorDao.getAutores()) {
            System.out.println("Autor: " + a.getNombre() + " " + a.getApellidos());
            System.out.println("Libros escritos:");
            for (Libro libro : a.getLibrosEscritos()) {
                System.out.println(" - " + libro.getTitulo());
            }
            System.out.println();
        }
    }
}
