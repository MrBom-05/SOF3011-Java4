package com.example.repositories;

import com.example.entities.DongSP;
import com.example.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import jakarta.persistence.Query;
import java.util.List;
import java.util.UUID;

public class DongSPRepository {
    Session session = HibernateUtil.getFACTORY().openSession();

    Transaction transaction = session.getTransaction();

    public List<DongSP> getListDongSP() {
        Session session = HibernateUtil.getFACTORY().openSession();
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

    public boolean delete(UUID id) {
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("delete from DongSP where id =: id");
            query.setParameter("id", id);
            int rowsAffected = query.executeUpdate();
            if (rowsAffected == 0) {
                // không có bản ghi nào bị xóa
                transaction.rollback();
                return false;
            } else {
                // xóa thành công
                transaction.commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    public boolean update(UUID id, DongSP dongSP) {
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

    public DongSP getById(UUID id) {
        return session.find(DongSP.class, id);
    }
}
