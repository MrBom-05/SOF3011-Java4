package com.example.repositories;

import com.example.entities.CuaHang;
import com.example.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class CuaHangRepository {
    Session session = HibernateUtil.getFACTORY().openSession();

    Transaction transaction = null;

    public List<CuaHang> getListCuaHang() {

        Query query = session.createQuery("from CuaHang");
        List<CuaHang> list = query.getResultList();
        return list;
    }

    public boolean insert(CuaHang cuaHang) {
        try {
            transaction = session.beginTransaction();
            session.save(cuaHang);
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
            Query query = session.createQuery("delete from CuaHang where id =: id");
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public CuaHang getById(String id){
        Query query = session.createQuery("from CuaHang where id =: id");
        query.setParameter("id", id);
        CuaHang cuaHang = (CuaHang) query.getSingleResult();
        return cuaHang;
    }
}
