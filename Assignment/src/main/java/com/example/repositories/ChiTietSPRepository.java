package com.example.repositories;

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

        Query query = session.createQuery("SELECT new com.example.models.ChiTietSPCustom(sp.sanPham.ma, sp.sanPham.ten, sp.nsx.ten, sp.mauSac.ten, sp.dongSP.ten, sp.namSX, sp.moTa, sp.soLuongTon, sp.giaNhap, sp.giaBan) FROM com.example.entities.ChiTietSP sp");
        List<ChiTietSPCustom> list = query.getResultList();
        return list;
    }
}
