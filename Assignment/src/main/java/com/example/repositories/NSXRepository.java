package com.example.repositories;

import com.example.entities.NSX;
import com.example.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import jakarta.persistence.Query;
import java.util.List;
import java.util.UUID;

public class NSXRepository {
    Session session = HibernateUtil.getFACTORY().openSession();

    Transaction transaction = session.getTransaction();

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
            Query query = session.createQuery("delete from NSX where id =: id");
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

    public boolean update(UUID id, NSX nsx) {
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

    public NSX getById(UUID id) {
        return session.find(NSX.class, id);
    }
}
