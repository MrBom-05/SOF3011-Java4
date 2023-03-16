package com.example.repositories;

import com.example.entities.MauSac;
import com.example.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class MauSacRepository {
    Session session = HibernateUtil.getFACTORY().openSession();

    Transaction transaction = null;

    public List<MauSac> getListMauSac() {

        Query query = session.createQuery("from MauSac");
        List<MauSac> list = query.getResultList();
        return list;
    }

    public boolean insert(MauSac mauSac) {
        try {
            transaction = session.beginTransaction();
            session.save(mauSac);
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
            Query query = session.createQuery("delete from MauSac where id =: id");
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public MauSac getById(String id){
        Query query = session.createQuery("from MauSac where id =: id");
        query.setParameter("id", id);
        MauSac mauSac = (MauSac) query.getSingleResult();
        return mauSac;
    }
}
