package dao;

import database.HibernateUtil;
import model.Autor;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;

public class AutorDao {
    Session session;
    public List<Autor> getAutores() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query<Autor> query = session.createQuery("FROM Autor a JOIN FETCH a.librosEscritos", Autor.class);
        List<Autor> listaAutores = query.list();
        session.getTransaction().commit();
        session.close();
        return listaAutores;
    }
}