package com.example.repositories;

import com.example.entities.GioHang;
import com.example.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class GioHangRepository {

    Session session = HibernateUtil.getFACTORY().openSession();

    Transaction transaction = null;

    public boolean insert(GioHang gioHang) {
        try {
            transaction = session.beginTransaction();
            session.save(gioHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }
    }


    public boolean check(String id) {
        Query query = session.createQuery("from GioHang g where g.khachHang.id =: id");
        query.setParameter("id", id);
        List<GioHang> gioHangList = query.getResultList();
        if (gioHangList == null || gioHangList.isEmpty()){
            return false;
        }
        return true;
    }

    public String getById(String id) {
        Query query = session.createQuery("select g.id from GioHang g where g.khachHang.id =: id");
        query.setParameter("id", id);
        return (String) query.getSingleResult();
    }

}
