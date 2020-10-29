package mx.impl;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CorreosDaoImpl implements mx.dao.CorreosDao {

    @Override
    public List<String> listaCorreos(String clave) {
        List<String> lista = null;
        Session session = mx.util.HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String SQL = "SELECT correo FROM Avisocorreo where departamento='" + clave + "'";
        try {
            lista = session.createQuery(SQL).list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            t.rollback();
        }
        return lista;
    }
 }


