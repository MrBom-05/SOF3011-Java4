package com.example.repositories;

import com.example.entities.ChiTietSP;
import com.example.models.ChiTietSPCustom;
import com.example.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class ChiTietSPRepository {
    Session session = HibernateUtil.getFACTORY().openSession();

    Transaction transaction = null;

    public List<ChiTietSPCustom> getListChiTietSP() {

        Query query = session.createQuery("select new com.example.models.ChiTietSPCustom(sp.id, sp.sanPham.ma, sp.sanPham.ten, sp.nsx.ten, sp.mauSac.ten, sp.dongSP.ten, sp.namSX, sp.moTa, sp.soLuongTon, sp.giaNhap, sp.giaBan) from com.example.entities.ChiTietSP sp");
        List<ChiTietSPCustom> list = query.getResultList();
        return list;
    }

    public boolean insert(ChiTietSP chiTietSP) {
        try {
            transaction = session.beginTransaction();
            session.save(chiTietSP);
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
            Query query = session.createQuery("delete from ChiTietSP where id =: id");
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getIdSanPhamById = "select s.sanPham.id from ChiTietSP s where id =: id";
    public String getIdMauSacById = "select s.mauSac.id from ChiTietSP s where id =: id";
    public String getIdDongSPById = "select s.dongSP.id from ChiTietSP s where id =: id";
    public String getIdNSXById = "select s.nsx.id from ChiTietSP s where id =: id";

    public String getIdById(String id, String where){

        Query query = session.createQuery(where);
        query.setParameter("id", id);

        return (String) query.getSingleResult();
    }


    public ChiTietSP getById(String id){
        Query query = session.createQuery("from ChiTietSP where id =: id");
        query.setParameter("id", id);
        ChiTietSP chiTietSP = (ChiTietSP) query.getSingleResult();
        return chiTietSP;
    }
}
