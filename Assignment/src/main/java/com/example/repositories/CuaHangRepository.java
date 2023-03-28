package com.example.repositories;

import com.example.entities.CuaHang;
import com.example.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import jakarta.persistence.Query;
import java.util.List;
import java.util.UUID;

public class CuaHangRepository {
    Session session = HibernateUtil.getFACTORY().openSession();

    Transaction transaction = session.getTransaction();

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

    public boolean update(UUID id, CuaHang cuaHang) {
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

    public CuaHang getById(UUID id) {
        return session.find(CuaHang.class, id);
    }
}
