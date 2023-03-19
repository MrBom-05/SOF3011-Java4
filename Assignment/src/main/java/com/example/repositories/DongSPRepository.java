package com.example.repositories;

import com.example.entities.DongSP;
import com.example.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class DongSPRepository {
    Session session = HibernateUtil.getFACTORY().openSession();

    Transaction transaction = null;

    public List<DongSP> getListDongSP() {

        Query query = session.createQuery("from DongSP ");
        List<DongSP> list = query.getResultList();
        return list;
    }

    public boolean insert(DongSP dongSP) {
        try {
            transaction = session.beginTransaction();
            session.save(dongSP);
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
            Query query = session.createQuery("delete from DongSP where id =: id");
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(String id, DongSP dongSP){
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("update DongSP set ten =: ten where id =: id");
            query.setParameter("id", id);
            query.setParameter("ten", dongSP.getTen());
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public DongSP getById(String id){
        Query query = session.createQuery("from DongSP where id =: id");
        query.setParameter("id", id);
        DongSP dongSP = (DongSP) query.getSingleResult();
        return dongSP;
    }
}
