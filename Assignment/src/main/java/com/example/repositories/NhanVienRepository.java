package com.example.repositories;

import com.example.entities.ChucVu;
import com.example.entities.NhanVien;
import com.example.models.NhanVienCustom;
import com.example.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class NhanVienRepository {
    Session session = HibernateUtil.getFACTORY().openSession();

    Transaction transaction = null;

    public List<NhanVienCustom> getListNhanVien() {

        Query query = session.createQuery("SELECT new com.example.models.NhanVienCustom(nv.ma, nv.ten, nv.tenDem, nv.ho, nv.gioiTinh, nv.ngaySinh, nv.diaChi, nv.sdt, nv.cuaHang.ten, nv.chucVu.ten, nv.email, nv.matKhau, nv.trangThai) FROM com.example.entities.NhanVien nv");
        List<NhanVienCustom> list = query.getResultList();
        return list;
    }

    public boolean insert(NhanVien nhanVien) {
        try {
            transaction = session.beginTransaction();
            session.save(nhanVien);
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
            Query query = session.createQuery("DELETE FROM NhanVien WHERE id =: id");
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
