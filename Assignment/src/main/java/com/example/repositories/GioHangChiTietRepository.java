package com.example.repositories;

import com.example.models.GioHangChiTietCustom;
import com.example.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class GioHangChiTietRepository {
    Session session = HibernateUtil.getFACTORY().openSession();

    Transaction transaction = null;

    public List<GioHangChiTietCustom> getList(String id) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("select new com.example.models.GioHangChiTietCustom(sp.chiTietSP.id, sp.chiTietSP.sanPham.ten, sp.chiTietSP.sanPham.anh, sp.chiTietSP.mauSac.ten, sp.donGia, sp.soLuong) from com.example.entities.GioHangChiTiet sp left join sp.chiTietSP.sanPham spm left join sp.chiTietSP.mauSac ms left join sp.gioHang.khachHang kh where sp.gioHang.khachHang.id =: id");
        query.setParameter("id", id);
        List<GioHangChiTietCustom> list = query.getResultList();
        return list;
    }
}
