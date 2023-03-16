package com.example.repositories;

import com.example.entities.KhachHang;
import com.example.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class KhachHangRepository {
    Session session = HibernateUtil.getFACTORY().openSession();

    Transaction transaction = null;

    public List<KhachHang> getListKhachHang() {

        Query query = session.createQuery("from KhachHang");
        List<KhachHang> list = query.getResultList();
        return list;
    }

    public boolean insert(KhachHang khachHang) {
        try {
            transaction = session.beginTransaction();
            session.save(khachHang);
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
            Query query = session.createQuery("delete from KhachHang where id =: id");
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public KhachHang getById(String id){
        Query query = session.createQuery("from KhachHang where id =: id");
        query.setParameter("id", id);
        KhachHang khachHang = (KhachHang) query.getSingleResult();
        return khachHang;
    }
}
