package com.example.repositories;

import com.example.entities.HoaDon;
import com.example.models.HoaDonAdminCustom;
import com.example.models.HoaDonUserCustom;
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

    public List<HoaDonAdminCustom> getListHoaDon() {
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("select new com.example.models.HoaDonAdminCustom(hd.id, hd.ma, hd.nhanVien.ten, hd.khachHang.ten, hd.khachHang.sdt, hd.khachHang.diaChi, hd.ngayTao, hd.ngayShip, hd.ngayNhan, hd.ngayThanhToan, hd.trangThai) from com.example.entities.HoaDon hd left join hd.nhanVien nv left join hd.khachHang kh");
        List<HoaDonAdminCustom> list = query.getResultList();
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

    public List<HoaDonUserCustom> getListHoaDonByUser(UUID id){
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("select new com.example.models.HoaDonUserCustom(hdct.hoaDon.id, hdct.hoaDon.ma, hdct.hoaDon.ngayTao, count(hdct), sum(hdct.donGia), hdct.hoaDon.trangThai) from com.example.entities.HoaDonChiTiet hdct left join hdct.hoaDon hd left join hdct.chiTietSP ctdp where hdct.hoaDon.khachHang.id =: id group by hdct.hoaDon.id, hdct.hoaDon.ma, hdct.hoaDon.ngayTao, hdct.hoaDon.trangThai");
        query.setParameter("id", id);
        List<HoaDonUserCustom> list = query.getResultList();
        return list;
    }
}
