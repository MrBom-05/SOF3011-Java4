package com.example.repositories;

import com.example.entities.SanPham;
import com.example.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import jakarta.persistence.Query;
import java.util.List;
import java.util.UUID;

public class SanPhamRepository {
    Session session = HibernateUtil.getFACTORY().openSession();

    Transaction transaction = session.getTransaction();

    public List<SanPham> getListSanPham() {
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("from SanPham");
        List<SanPham> list = query.getResultList();
        return list;
    }

    public boolean insert(SanPham sanPham) {
        try {
            transaction = session.beginTransaction();
            session.save(sanPham);
            transaction.commit();
            return true;
        } catch (ConstraintViolationException e) {
            // Thực hiện xử lý khi gặp lỗi unique key constraint
            e.printStackTrace();
            transaction.rollback();
            return false;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(UUID id) {
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("delete from SanPham where id =: id");
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

    public boolean update(UUID id, SanPham sanPham) {
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("update SanPham set ten =: ten, anh =: anh where id =: id");
            query.setParameter("id", id);
            query.setParameter("ten", sanPham.getTen());
            query.setParameter("anh", sanPham.getAnh());
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public SanPham getById(UUID id) {
        return session.find(SanPham.class, id);
    }
}
