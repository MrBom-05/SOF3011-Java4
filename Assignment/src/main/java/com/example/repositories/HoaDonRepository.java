package com.example.repositories;

import com.example.entities.ChucVu;
import com.example.entities.HoaDon;
import com.example.models.HoaDonCustom;
import com.example.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.persistence.Query;
import org.hibernate.exception.ConstraintViolationException;

import java.util.List;
import java.util.UUID;

public class HoaDonRepository {
    Session session = HibernateUtil.getFACTORY().openSession();

    Transaction transaction = session.getTransaction();

    public List<HoaDonCustom> getListHoaDon() {
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("select new com.example.models.HoaDonCustom(hd.id, hd.ma, hd.nhanVien.ten, hd.khachHang.ten, hd.khachHang.sdt, hd.khachHang.diaChi, hd.ngayTao, hd.ngayShip, hd.ngayNhan, hd.ngayThanhToan, hd.trangThai) from com.example.entities.HoaDon hd left join hd.nhanVien nv left join hd.khachHang kh");
        List<HoaDonCustom> list = query.getResultList();
        return list;
    }

    public UUID insert(HoaDon hoaDon) {
        try {
            transaction = session.beginTransaction();
            UUID id = (UUID) session.save(hoaDon);
            transaction.commit();
            System.out.println(id);
            return id;
        } catch (ConstraintViolationException e) {
            // Thực hiện xử lý khi gặp lỗi unique key constraint
            e.printStackTrace();
            transaction.rollback();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        }
    }
}
