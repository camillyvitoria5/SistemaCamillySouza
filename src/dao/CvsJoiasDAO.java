/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.CvsJoias;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author marcos
 */
public class CvsJoiasDAO extends DAOAbstract {

    public CvsJoiasDAO() {

    }

    @Override
    public void insert(Object object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
    }

    @Override
    public void update(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.update(object);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.delete(object);
        session.getTransaction().commit();
    }

    @Override
    public Object list(int codigo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CvsJoias.class);
        criteria.add(Restrictions.eq("cvs_id_joias", codigo) );
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
        public ArrayList listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CvsJoias.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return (ArrayList) lista;
}


    public static void main(String[] args) {
        CvsJoiasDAO cvsJoiasDAO = new CvsJoiasDAO();
        cvsJoiasDAO.listAll();
    }
}