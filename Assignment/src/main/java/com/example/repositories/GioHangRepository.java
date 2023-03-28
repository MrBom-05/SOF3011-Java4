package com.example.repositories;

import com.example.entities.GioHang;
import com.example.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import jakarta.persistence.Query;
import java.util.List;
import java.util.UUID;

public class GioHangRepository {

    Session session = HibernateUtil.getFACTORY().openSession();

    Transaction transaction = session.getTransaction();

    public boolean insert(GioHang gioHang) {
        try {
            transaction = session.beginTransaction();
            session.save(gioHang);
            transaction.commit();
            return true;
        } catch (ConstraintViolationException e) {
            // Thực hiện xử lý khi gặp lỗi unique key constraint
            e.printStackTrace();
            transaction.rollback();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }


    public boolean check(UUID id) {
        Query query = session.createQuery("from GioHang g where g.khachHang.id =: id");
        query.setParameter("id", id);
        List<GioHang> gioHangList = query.getResultList();
        if (gioHangList == null || gioHangList.isEmpty()) {
            return false;
        }
        return true;
    }

    public UUID getById(UUID id) {
        Query query = session.createQuery("select g.id from GioHang g where g.khachHang.id =: id");
        query.setParameter("id", id);
        return (UUID) query.getSingleResult();
    }

}
