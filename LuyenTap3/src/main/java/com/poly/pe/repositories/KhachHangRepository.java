package com.poly.pe.repositories;

import com.poly.pe.entities.KhachHang;
import com.poly.pe.utils.HibernateUtil;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class KhachHangRepository {


    private Session session = HibernateUtil.getFACTORY().openSession();
    private Transaction transaction = session.getTransaction();


    public List<KhachHang> getList() {
        Query query = session.createQuery("select k from KhachHang k");
        return query.getResultList();
    }


    public boolean insert(KhachHang khachHang) {
        try {
            transaction = session.beginTransaction();
            session.save(khachHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(KhachHang khachHang) {
        try {
            transaction = session.beginTransaction();
            session.delete(khachHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public KhachHang getByMa(String ma) {
        Query query = session.createQuery("select k from KhachHang k where k.ma =: ma");
        query.setParameter("ma", ma);

        try {
            return (KhachHang) query.getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }

}
