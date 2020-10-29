 package mx.impl;
 
 import mx.dao.LoginDao;
 import mx.model.Usuario;
 import org.hibernate.Query;
 import org.hibernate.Session;
 
 public class LoginUsuarioImpl implements LoginDao
 {
   @Override
   public Usuario obternerDatosUsuario(Usuario usuario)
   {
     Session session = mx.util.HibernateUtil.getSessionFactory().openSession();
     String hql = "FROM Usuario WHERE nombre=:nombre and clave=:clave and vigencia <>0";
     Query q = session.createQuery(hql);
     q.setParameter("nombre", usuario.getNombre());
     q.setParameter("clave", usuario.getClave());
     return (Usuario)q.uniqueResult();
   }
   
 
   @Override
   public Usuario login(Usuario usuario)
   {
     Usuario user = obternerDatosUsuario(usuario);
     if ((user != null) && 
       (!user.getClave().equals(user.getClave()))) {
       user = null;
     }
     
     return user;
   }
 }


