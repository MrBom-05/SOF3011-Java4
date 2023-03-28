package com.example.repositories;

import com.example.entities.MauSac;
import com.example.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import jakarta.persistence.Query;
import java.util.List;
import java.util.UUID;

public class MauSacRepository {
    Session session = HibernateUtil.getFACTORY().openSession();

    Transaction transaction = session.getTransaction();

    public List<MauSac> getListMauSac() {
        Session session = HibernateUtil.getFACTORY().openSession();
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
            Query query = session.createQuery("delete from MauSac where id =: id");
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

    public boolean update(UUID id, MauSac mauSac) {
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("update MauSac set ten =: ten where id =: id");
            query.setParameter("id", id);
            query.setParameter("ten", mauSac.getTen());
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (ConstraintViolationException e) {
            // Thực hiện xử lý khi gặp lỗi unique key constraint
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public MauSac getById(UUID id) {
        return session.find(MauSac.class, id);
    }
}
