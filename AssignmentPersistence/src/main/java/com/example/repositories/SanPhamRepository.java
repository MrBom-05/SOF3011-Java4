package com.example.repositories;

import com.example.entities.SanPham;
import com.example.utilities.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class SanPhamRepository {
    private EntityManager entityManager = JpaUtil.getEntityManager();

    public List<SanPham> getList() {
        TypedQuery<SanPham> query = entityManager.createQuery("select s from SanPham s", SanPham.class);
        return query.getResultList();
    }
}
