 package mx.impl;
 
 import java.util.List;
 import mx.model.Cuenm01;
 import mx.util.HibernateUtil;
 import org.hibernate.HibernateException;
 import org.hibernate.Session;
 import org.hibernate.Transaction;
 
 public class CuenM01DaoImpl implements mx.dao.CuenM01Dao
 {
   @Override
   public List<Cuenm01> listaFactura()
   {
     List<Cuenm01> lista = null;
     Session session = HibernateUtil.getSessionFactory().openSession();
     Transaction transaction = session.beginTransaction();
     String hql = "FROM Cuenm01 WHERE procesado=0 and saldo >.5";
     try {
       lista = session.createQuery(hql).list();
       transaction.commit();
       session.close();
     } catch (HibernateException e) {
       transaction.rollback();
     }
     return lista;
   }
   
 
   @Override
   @SuppressWarnings("null")
   public void insertFactf01(Cuenm01 f)
   {
     Session session = null;
     try {
       session = HibernateUtil.getSessionFactory().openSession();
       session.beginTransaction();
       session.save(f);
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
   @SuppressWarnings("null")
   public void updateFactf01(Cuenm01 f)
   {
     Session session = null;
     try {
       session = HibernateUtil.getSessionFactory().openSession();
       session.beginTransaction();
       session.update(f);
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
   public List<Cuenm01> listaReporte()
   {
     List<Cuenm01> lista = null;
     Session session = HibernateUtil.getSessionFactory().openSession();
     Transaction transaction = session.beginTransaction();
     String hql = "FROM Cuenm01 WHERE procesado=1";
     try {
       lista = session.createQuery(hql).list();
       transaction.commit();
       session.close();
     } catch (HibernateException e) {
       transaction.rollback();
     }
     return lista;
   }
   
   @Override
   public List<Cuenm01> lsitaFacturasParciales()
   {
     List<Cuenm01> lista = null;
     Session session = HibernateUtil.getSessionFactory().openSession();
     Transaction transaction = session.beginTransaction();
     String hql = "FROM Cuenm01 WHERE procesado=1 and pagoParcial=1";
     try {
       lista = session.createQuery(hql).list();
       transaction.commit();
       session.close();
     } catch (HibernateException e) {
       transaction.rollback();
     }
     return lista;
   }
 }


