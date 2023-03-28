package com.example.repositories;

import com.example.models.HoaDonCustom;
import com.example.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.persistence.Query;
import java.util.List;

public class HoaDonRepository {
    Session session = HibernateUtil.getFACTORY().openSession();

    Transaction transaction = session.getTransaction();

    public List<HoaDonCustom> getListHoaDon() {
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("select new com.example.models.HoaDonCustom(hd.id, hd.ma, hd.nhanVien.ten, hd.khachHang.ten, hd.khachHang.sdt, hd.khachHang.diaChi, hd.ngayTao, hd.ngayShip, hd.ngayNhan, hd.ngayThanhToan, hd.trangThai) from com.example.entities.HoaDon hd left join hd.nhanVien nv left join hd.khachHang kh");
        List<HoaDonCustom> list = query.getResultList();
        return list;
    }
}
