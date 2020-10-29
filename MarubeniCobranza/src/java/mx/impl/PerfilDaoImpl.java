package mx.impl;

import java.util.List;
import javax.faces.context.FacesContext;
import mx.dao.PerfilDao;

import mx.model.Usuario;
import mx.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PerfilDaoImpl
        implements PerfilDao {

    @Override
    public List<Usuario> listaUsuarios() {
        List<Usuario> lista = null;
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "select nombre FROM Usuario WHERE codigoPerfil='Usuario' AND codigoSap='" + us.getCodigoSap() + "'";
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
    public List<Usuario> admonPoliza() {
        List<Usuario> lista = null;
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "select nombre FROM Usuario WHERE admonPoliza='Si' AND codigoSap='" + us.getCodigoSap() + "'";
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
