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

        Query query = session.createQuery("FROM ChucVu");
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
            Query query = session.createQuery("DELETE FROM ChucVu WHERE id =: id");
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
