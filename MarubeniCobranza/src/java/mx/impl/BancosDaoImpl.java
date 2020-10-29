package mx.impl;

import java.util.List;
import mx.model.Bancos;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BancosDaoImpl implements mx.dao.BancosDao {

    @Override
    public List<Bancos> listaBancos() {
        List<Bancos> lista = null;
        Session session = mx.util.HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String SQL = "FROM Bancos";
        try {
            lista = session.createQuery(SQL).list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }
}
