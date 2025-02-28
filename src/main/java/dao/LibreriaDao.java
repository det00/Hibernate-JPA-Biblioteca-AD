package dao;

import database.HibernateUtil;
import model.Libreria;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class LibreriaDao {
    private Session session;

    public void crearLibreria(Libreria libreria) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(libreria);
        session.getTransaction().commit();
        session.close();
    }

    public List<Libreria> getLibreriasConLibros() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query<Libreria> query = session.createQuery(
                "FROM Libreria l JOIN FETCH l.coleccionLibros",
                Libreria.class
        );
        List<Libreria> librerias = query.list();
        session.getTransaction().commit();
        session.close();
        return librerias;
    }
}