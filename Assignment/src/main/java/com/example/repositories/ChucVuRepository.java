package com.example.repositories;

import com.example.entities.ChucVu;
import com.example.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class ChucVuRepository {
    Session session = HibernateUtil.getFACTORY().openSession();

    Transaction transaction = null;

    public List<ChucVu> getListChucVu() {

        Query query = session.createQuery("from ChucVu");
        List<ChucVu> list = query.getResultList();
        return list;
    }

    public boolean insert(ChucVu chucVu) {
        try {
            transaction = session.beginTransaction();
            session.save(chucVu);
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
            Query query = session.createQuery("delete from ChucVu where id =: id");
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(String id, ChucVu chucVu){
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("update ChucVu set ten =: ten where id =: id");
            query.setParameter("id", id);
            query.setParameter("ten", chucVu.getTen());
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ChucVu getById(String id){
        Query query = session.createQuery("from ChucVu where id =: id");
        query.setParameter("id", id);
        ChucVu chucVu = (ChucVu) query.getSingleResult();
        return chucVu;
    }
}
