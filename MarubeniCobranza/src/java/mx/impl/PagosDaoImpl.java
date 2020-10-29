package mx.impl;

import java.util.List;
import mx.model.Pagos;
import mx.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PagosDaoImpl implements mx.dao.PagosDao {

    @Override
    public List<Pagos> listaFactura() {
        List<Pagos> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM Pagos WHERE procesado=0";
        try {
            lista = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            transaction.rollback();
        }
        return lista;
    }

    @SuppressWarnings("null")
    @Override
    public void insertFactf01(Pagos p) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(p);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void updateFactf01(int folio, String p) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "UPDATE Pagos SET Enviado=:p WHERE pagoMultiple=:folio";
        Query q = session.createQuery(hql);
        q.setParameter("p", p);
        q.setParameter("folio", Integer.valueOf(folio));
        try {
            q.executeUpdate();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
    }

    @Override
    public List<Pagos> listarFacturasEnvioCorreos() {
        List<Pagos> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Pagos WHERE enviado IS NULL";
        try {
            lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    public List<Pagos> listarFacturasSeleccionadas() {
        List<Pagos> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Pagos WHERE enviado='NO'";
        try {
            lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    public List<String> listaUsuariosAvisoPago() {
        List<String> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "SELECT DISTINCT depto FROM Pagos WHERE enviado='NO' ";
        try {
            lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    public void updateEnvio(String vendedor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "UPDATE Pagos SET enviado='SI' WHERE depto LIKE '%" + vendedor + "%' AND Enviado='NO'";
        Query q = session.createQuery(hql);
        try {
            q.executeUpdate();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
    }
}
