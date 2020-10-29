 package mx.impl;
 
 import java.util.List;
 import mx.model.Polizapagos;
 import org.hibernate.HibernateException;
 import org.hibernate.Session;
 import org.hibernate.Transaction;
 
 public class PolPagosDaoImpl implements mx.dao.PolPagosDao
 {
@SuppressWarnings("override")
   public List<Polizapagos> listaRepPol(String p)
   {
     List<Polizapagos> lista = null;
     Session session = mx.util.HibernateUtil.getSessionFactory().openSession();
     Transaction t = session.beginTransaction();
     String hql = "FROM Polizapagos WHERE userFolio='" + p + "'";
     try {
       lista = session.createQuery(hql).list();
       t.commit();
       session.close();
     } catch (HibernateException e) {
       t.rollback();
     }
     return lista;
   }
 }


