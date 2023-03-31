package com.example.repositories;

import com.example.entities.GioHangChiTiet;
import com.example.models.GioHangChiTietCustom;
import com.example.utilities.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import jakarta.persistence.Query;
import org.hibernate.query.NativeQuery;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

public class GioHangChiTietRepository {
    Session session = HibernateUtil.getFACTORY().openSession();

    Transaction transaction = session.getTransaction();

    public List<GioHangChiTietCustom> getList(UUID id) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("select new com.example.models.GioHangChiTietCustom(sp.chiTietSP.id, sp.chiTietSP.sanPham.ten, sp.chiTietSP.sanPham.anh, sp.chiTietSP.mauSac.ten, sp.donGia, sp.soLuong) from com.example.entities.GioHangChiTiet sp left join sp.chiTietSP.sanPham spm left join sp.chiTietSP.mauSac ms left join sp.gioHang.khachHang kh where sp.gioHang.khachHang.id =: id");
        query.setParameter("id", id);
        List<GioHangChiTietCustom> list = query.getResultList();
        return list;
    }

    public boolean insert(GioHangChiTiet gioHangChiTiet) {
        try {
            transaction = session.beginTransaction();
            session.save(gioHangChiTiet);
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

    public boolean deleteOne(UUID idSP, UUID idGH) {
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("delete from GioHangChiTiet gh where gh.chiTietSP.id =: idSP and gh.gioHang.id =: idGH");
            query.setParameter("idSP", idSP);
            query.setParameter("idGH", idGH);
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteAll(UUID idGH) {
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("delete from GioHangChiTiet where gioHang.id =: idGH");
            query.setParameter("idGH", idGH);
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(UUID idSP, UUID idGH, int soLuong) {
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("update GioHangChiTiet set soLuong = soLuong +: soLuong where chiTietSP.id =: idSP and gioHang.id =: idGH");
            query.setParameter("idSP", idSP);
            query.setParameter("idGH", idGH);
            query.setParameter("soLuong", soLuong);
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean check(UUID idSP, UUID idGH) {
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("from GioHangChiTiet gh where gh.chiTietSP.id =: idSP and gh.gioHang.id =: idGH");
        query.setParameter("idSP", idSP);
        query.setParameter("idGH", idGH);
        List<GioHangChiTiet> list = query.getResultList();
        if (list == null || list.isEmpty()) {
            return true;
        }
        return false;
    }

    public int index(UUID id) {
        try {
            Transaction transaction = session.beginTransaction();

            // Thực hiện câu lệnh SQL để lấy giá trị index lớn nhất
            Query query = session.createQuery("from GioHangChiTiet gh where gh.gioHang.khachHang.id = :id");
            query.setParameter("id", id);
            // In ra giá trị index lớn nhất
            List<GioHangChiTiet> list = query.getResultList();
            int count = 0;
            for (GioHangChiTiet gioHangChiTiet : list) {
                count++;
            }

            System.out.println("Max index: " + count);
            transaction.commit();
            return count; // trả về giá trị mặc định nếu maxIndex là null
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return 0;
    }


}
