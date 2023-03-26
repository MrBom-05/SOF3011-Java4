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
        Session session = HibernateUtil.getFACTORY().openSession();
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

    public boolean update(String id, CuaHang cuaHang){
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("update CuaHang set ten =: ten, diaChi =: diaChi, thanhPho =: thanhPho, quocGia =: quocGia where id =: id");
            query.setParameter("id", id);
            query.setParameter("ten", cuaHang.getTen());
            query.setParameter("diaChi", cuaHang.getDiaChi());
            query.setParameter("thanhPho", cuaHang.getThanhPho());
            query.setParameter("quocGia", cuaHang.getQuocGia());
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
