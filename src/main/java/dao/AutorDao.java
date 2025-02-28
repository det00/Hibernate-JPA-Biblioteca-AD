package dao;

import database.HibernateUtil;
import model.Autor;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AutorDao {
    private Session session;

    public void crearAutor(Autor autor) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(autor);
        session.getTransaction().commit();
        session.close();
    }

    public List<Autor> getAutoresConLibros() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query<Autor> query = session.createQuery(
                "FROM Autor a JOIN FETCH a.librosEscritos",
                Autor.class
        );
        List<Autor> autores = query.list();
        session.getTransaction().commit();
        session.close();
        return autores;
    }
}