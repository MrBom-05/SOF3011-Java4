package com.example.repositories;

import com.example.entities.HoaDonChiTiet;
import com.example.models.HoaDonChiTietCustom;
import com.example.utilities.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import java.util.List;
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

    public List<HoaDonChiTietCustom> getListByID(UUID id) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("select new com.example.models.HoaDonChiTietCustom(hdct.chiTietSP.id, hdct.chiTietSP.sanPham.ten, hdct.chiTietSP.sanPham.anh, hdct.chiTietSP.mauSac.ten, hdct.donGia, hdct.soLuong) from com.example.entities.HoaDonChiTiet hdct left join hdct.chiTietSP.sanPham spm left join hdct.chiTietSP.mauSac ms where hdct.hoaDon.id =: id");
        query.setParameter("id", id);
        List<HoaDonChiTietCustom> list = query.getResultList();
        return list;
    }
}
