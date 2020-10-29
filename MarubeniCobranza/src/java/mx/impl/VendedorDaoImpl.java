package mx.impl;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class VendedorDaoImpl implements mx.dao.VendedorDao {

    @Override
    public List<String> listaVendedor(String clave) {
        List<String> lista = null;
        Session session = mx.util.HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String SQL = "SELECT correo FROM Vendedor where strcvevend='" + clave + "'";
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
