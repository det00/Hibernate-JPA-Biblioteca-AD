package dao;


import database.HibernateUtil;
import model.Libro;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class LibroDao {
    Session session;

    public List<Libro> getLibros() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query<Libro> query = session.createQuery(
                "FROM Libro l " +
                        "JOIN FETCH l.editorial " +
                        "JOIN FETCH l.autor " +
                        "JOIN FETCH l.librerias", Libro.class
        );
        List<Libro> listaLibros = query.list();
        session.getTransaction().commit();
        session.close();
        return listaLibros;
    }
}
