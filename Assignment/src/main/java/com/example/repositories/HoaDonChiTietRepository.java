package com.example.repositories;

import com.example.entities.HoaDon;
import com.example.entities.HoaDonChiTiet;
import com.example.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import java.util.UUID;

public class HoaDonChiTietRepository {

    Session session = HibernateUtil.getFACTORY().openSession();

    Transaction transaction = session.getTransaction();

    public boolean insert(HoaDonChiTiet hoaDonChiTiet) {
        try {
            transaction = session.beginTransaction();
            session.save(hoaDonChiTiet);
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
}
