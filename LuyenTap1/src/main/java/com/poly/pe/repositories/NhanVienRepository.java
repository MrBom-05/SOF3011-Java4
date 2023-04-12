package com.poly.pe.repositories;

import com.poly.pe.entities.NhanVien;
import com.poly.pe.utils.HibernateUtil;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Queue;

public class NhanVienRepository {

    private Session session = HibernateUtil.getFACTORY().openSession();

    private Transaction transaction = session.getTransaction();

    public List<NhanVien> getList(){
        Query query = session.createQuery("select nv from NhanVien nv");
        return query.getResultList();
    }

    public boolean insert(NhanVien nhanVien){
        try {
            transaction = session.beginTransaction();
            session.save(nhanVien);
            transaction.commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(NhanVien nhanVien){
        try {
            transaction = session.beginTransaction();
            session.delete(nhanVien);
            transaction.commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


    public NhanVien getByMa(String ma){
        Query query = session.createQuery("select nv from NhanVien nv where nv.ma =: ma");
        query.setParameter("ma", ma);

        try {
            return (NhanVien) query.getSingleResult();
        } catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }
}
