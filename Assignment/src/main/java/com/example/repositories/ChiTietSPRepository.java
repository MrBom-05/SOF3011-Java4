package com.example.repositories;

import com.example.entities.ChiTietSP;
import com.example.models.ChiTietSPCustom;
import com.example.models.SanPhamChiTietCustom;
import com.example.models.SanPhamCustom;
import com.example.utilities.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;


import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class ChiTietSPRepository {
    Session session = HibernateUtil.getFACTORY().openSession();

    Transaction transaction = session.getTransaction();

    public List<ChiTietSPCustom> getListChiTietSP() {
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("select new com.example.models.ChiTietSPCustom(sp.id, sp.sanPham.ma, sp.sanPham.ten, sp.nsx.ten, sp.mauSac.ten, sp.dongSP.ten, sp.namSX, sp.moTa, sp.soLuongTon, sp.giaNhap, sp.giaBan) from com.example.entities.ChiTietSP sp left join sp.sanPham spm left join sp.nsx nsx left join sp.mauSac ms left join sp.dongSP dsp");
        List<ChiTietSPCustom> list = query.getResultList();
        return list;
    }

    public boolean insert(ChiTietSP chiTietSP) {
        try {
            transaction = session.beginTransaction();
            session.save(chiTietSP);
            transaction.commit();
            return true;
        } catch (ConstraintViolationException e) {
            // Thực hiện xử lý khi gặp lỗi unique key constraint
            e.printStackTrace();
            transaction.rollback();
            return false;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(UUID id) {
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("delete from ChiTietSP where id =: id");
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

    public boolean update(ChiTietSP chiTietSP) {
        try {
            transaction.begin();
            session.merge(chiTietSP);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    public String getIdSanPhamById = "select s.sanPham.id from ChiTietSP s where id =: id";
    public String getIdMauSacById = "select s.mauSac.id from ChiTietSP s where id =: id";
    public String getIdDongSPById = "select s.dongSP.id from ChiTietSP s where id =: id";
    public String getIdNSXById = "select s.nsx.id from ChiTietSP s where id =: id";

    public UUID getIdById(UUID id, String where) {

        Query query = session.createQuery(where);
        query.setParameter("id", id);

        return (UUID) query.getSingleResult();
    }


    public ChiTietSP getById(UUID id) {
        return session.find(ChiTietSP.class, id);
    }

    public List<SanPhamCustom> getListSP() {
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("select new com.example.models.SanPhamCustom(sp.id, sp.sanPham.ten, sp.sanPham.anh, sp.giaBan) from com.example.entities.ChiTietSP sp left join sp.sanPham spm");
        List<SanPhamCustom> list = query.getResultList();
        return list;
    }

    public SanPhamChiTietCustom getProductById(UUID id) {
        Query query = session.createQuery("select new com.example.models.SanPhamChiTietCustom(sp.id, sp.sanPham.ten, sp.sanPham.anh, sp.soLuongTon, sp.giaBan) from com.example.entities.ChiTietSP sp left join sp.sanPham spm where sp.id =: id");
        query.setParameter("id", id);
        return (SanPhamChiTietCustom) query.getSingleResult();
    }

    public BigDecimal getGiaBanById(UUID id) {
        Query query = session.createQuery("select sp.giaBan from ChiTietSP sp where sp.id =: id");
        query.setParameter("id", id);
        return (BigDecimal) query.getSingleResult();
    }
}
