package controller;

import dao.EditorialDao;
import model.Editorial;

public class EditorialController {
    private final EditorialDao editorialDao = new EditorialDao();

    public void crearEditorial(Editorial editorial) {
        editorialDao.crearEditorial(editorial);
        System.out.println("Editorial creada: " + editorial.getNombre());
    }
}