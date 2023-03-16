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
