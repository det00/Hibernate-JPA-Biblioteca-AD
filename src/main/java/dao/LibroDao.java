package dao;

import database.HibernateUtil;
import model.Libro;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class LibroDao {
    private Session session;

    public void crearLibro(Libro libro) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(libro);
        session.getTransaction().commit();
        session.close();
    }

    public List<Libro> getLibrosConEditorialYAutor() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query<Libro> query = session.createQuery(
                "FROM Libro l JOIN FETCH l.autor JOIN FETCH l.editorial",
                Libro.class
        );
        List<Libro> libros = query.list();
        session.getTransaction().commit();
        session.close();
        return libros;
    }

    public List<Libro> getLibrosConLibreria() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query<Libro> query = session.createQuery(
                "SELECT DISTINCT l FROM Libro l JOIN FETCH l.librerias",
                Libro.class
        );
        List<Libro> libros = query.list();
        session.getTransaction().commit();
        session.close();
        return libros;
    }
}