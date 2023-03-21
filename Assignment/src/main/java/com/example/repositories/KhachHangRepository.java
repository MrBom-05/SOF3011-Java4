package com.example.repositories;

import com.example.entities.KhachHang;
import com.example.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class KhachHangRepository {
    Session session = HibernateUtil.getFACTORY().openSession();

    Transaction transaction = null;

    public List<KhachHang> getListKhachHang() {
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("from KhachHang");
        List<KhachHang> list = query.getResultList();
        return list;
    }

    public boolean insert(KhachHang khachHang) {
        try {
            transaction = session.beginTransaction();
            session.save(khachHang);
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
            Query query = session.createQuery("delete from KhachHang where id =: id");
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(String id, KhachHang khachHang) {
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("update KhachHang set ten =: ten, tenDem =: tenDem, ho =: ho, ngaySinh =: ngaySinh, sdt =: sdt, email =: email, matKhau =: matKhau, diaChi =: diaChi, thanhPho =: thanhPho, quocGia =: quocGia where id =: id");
            query.setParameter("id", id);
            query.setParameter("ten", khachHang.getTen());
            query.setParameter("tenDem", khachHang.getTenDem());
            query.setParameter("ho", khachHang.getHo());
            query.setParameter("ngaySinh", khachHang.getNgaySinh());
            query.setParameter("sdt", khachHang.getSdt());
            query.setParameter("email", khachHang.getEmail());
            query.setParameter("matKhau", khachHang.getMatKhau());
            query.setParameter("diaChi", khachHang.getDiaChi());
            query.setParameter("thanhPho", khachHang.getThanhPho());
            query.setParameter("quocGia", khachHang.getQuocGia());
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public KhachHang getById(String id) {
        Query query = session.createQuery("from KhachHang where id =: id");
        query.setParameter("id", id);
        KhachHang khachHang = (KhachHang) query.getSingleResult();
        return khachHang;
    }

    public KhachHang login(String email, String matKhau) {
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("select k from KhachHang k where email =: email and matKhau =: matKhau");
            query.setParameter("email", email);
            query.setParameter("matKhau", matKhau);
            KhachHang khachHang = (KhachHang) query.getSingleResult();
            transaction.commit();
            return khachHang;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
