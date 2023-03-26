package com.example.repositories;

import com.example.entities.SanPham;
import com.example.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class SanPhamRepository {
    Session session = HibernateUtil.getFACTORY().openSession();

    Transaction transaction = null;

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
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }
    }

    public boolean delete(String id) {
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

    public boolean update(String id, SanPham sanPham){
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

    public SanPham getById(String id){
        Query query = session.createQuery("from SanPham where id =: id");
        query.setParameter("id", id);
        SanPham sanPham = (SanPham) query.getSingleResult();
        return sanPham;
    }
}
