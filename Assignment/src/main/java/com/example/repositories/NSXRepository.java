package com.example.repositories;

import com.example.entities.NSX;
import com.example.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class NSXRepository {
    Session session = HibernateUtil.getFACTORY().openSession();

    Transaction transaction = null;

    public List<NSX> getListNSX() {
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("from NSX");
        List<NSX> list = query.getResultList();
        return list;
    }

    public boolean insert(NSX nsx) {
        try {
            transaction = session.beginTransaction();
            session.save(nsx);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }
    }

    public boolean delete(String id) {
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("delete from NSX where id =: id");
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(String id, NSX nsx){
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("update NSX set ten =: ten where id =: id");
            query.setParameter("id", id);
            query.setParameter("ten", nsx.getTen());
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public NSX getById(String id){
        Query query = session.createQuery("from NSX where id =: id");
        query.setParameter("id", id);
        NSX nsx = (NSX) query.getSingleResult();
        return nsx;
    }
}
