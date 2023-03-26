package com.example.repositories;

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
        Session session = HibernateUtil.getFACTORY().openSession();
        Query query = session.createQuery("select new com.example.models.NhanVienCustom(nv.ma, nv.ten, nv.tenDem, nv.ho, nv.gioiTinh, nv.ngaySinh, nv.diaChi, nv.sdt, nv.cuaHang.ten, nv.chucVu.ten, nv.email, nv.matKhau, nv.trangThai) from com.example.entities.NhanVien nv left join nv.cuaHang ch left join nv.chucVu cv");
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

    public boolean delete(String ma) {
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("delete from NhanVien where ma =: ma");
            query.setParameter("ma", ma);
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

    public boolean update(String ma, NhanVien nhanVien){
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("update NhanVien set ten =: ten, tenDem =: tenDem, ho =: ho, ngaySinh =: ngaySinh, gioiTinh =: gioiTinh, sdt =: sdt, email =: email, matKhau =: matKhau, diaChi =: diaChi, cuaHang =: cuaHang, chucVu =: chucVu, trangThai =: trangThai where ma =: ma");
            query.setParameter("ma", ma);
            query.setParameter("ten", nhanVien.getTen());
            query.setParameter("tenDem", nhanVien.getTenDem());
            query.setParameter("ho", nhanVien.getHo());
            query.setParameter("ngaySinh", nhanVien.getNgaySinh());
            query.setParameter("gioiTinh", nhanVien.getGioiTinh());
            query.setParameter("sdt", nhanVien.getSdt());
            query.setParameter("email", nhanVien.getEmail());
            query.setParameter("matKhau", nhanVien.getMatKhau());
            query.setParameter("diaChi", nhanVien.getDiaChi());
            query.setParameter("cuaHang", nhanVien.getCuaHang());
            query.setParameter("chucVu", nhanVien.getChucVu());
            query.setParameter("trangThai", nhanVien.getTrangThai());
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getIdCuaHangByMa = "select n.cuaHang.id from NhanVien n where ma =: ma";
    public String getIdChucVuByMa = "select n.chucVu.id from NhanVien n where ma =: ma";

    public String getIdByMa(String ma, String where){

        Query query = session.createQuery(where);
        query.setParameter("ma", ma);

        return (String) query.getSingleResult();
    }


    public NhanVien getByMa(String ma){
        Query query = session.createQuery("from NhanVien where ma =: ma");
        query.setParameter("ma", ma);
        NhanVien nhanVien = (NhanVien) query.getSingleResult();
        return nhanVien;
    }
}
