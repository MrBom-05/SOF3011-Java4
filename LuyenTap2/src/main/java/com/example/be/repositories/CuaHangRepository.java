package com.example.be.repositories;

import com.example.be.entities.CuaHang;
import com.example.be.util.HibernateUtil;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CuaHangRepository {
    private Session session = HibernateUtil.getFACTORY().openSession();
    private Transaction transaction = session.getTransaction();

    public List<CuaHang> getList() {
        Query query = session.createQuery("select c from CuaHang c");
        return query.getResultList();
    }

    public boolean insert(CuaHang cuaHang) {
        try {
            transaction = session.beginTransaction();
            session.save(cuaHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(CuaHang cuaHang) {
        try {
            transaction = session.beginTransaction();
            session.update(cuaHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(CuaHang cuaHang) {
        try {
            transaction = session.beginTransaction();
            session.delete(cuaHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public CuaHang getByMa(String ma) {
        Query query = session.createQuery("select c from CuaHang c where c.ma =: ma");
        query.setParameter("ma", ma);
        try {
            return (CuaHang) query.getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }
}
