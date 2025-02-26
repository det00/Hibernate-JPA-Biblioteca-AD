package dao;

import database.HibernateUtil;
import model.Libreria;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class LibreriaDao {
    Session session;
    public List<Libreria> getLibrerias(){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query<Libreria> query = session.createQuery("FROM Libreria l LEFT JOIN FETCH l.coleccionLibros",Libreria.class);

        List<Libreria> listaLibreriasLibros = query.list();
        session.getTransaction().commit();
        session.close();
        return listaLibreriasLibros;
    }
}
