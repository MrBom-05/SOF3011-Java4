package com.example.services;

import com.example.entities.ChiTietSP;
import com.example.models.ChiTietSPCustom;
import com.example.models.SanPhamChiTietCustom;
import com.example.models.SanPhamCustom;

import java.util.List;

public interface ChiTietSPService {
    public List<ChiTietSPCustom> getListChiTietSP();

    public boolean insert(ChiTietSP chiTietSP);

    public boolean delete(String id);

    public boolean update(String id, ChiTietSP chiTietSP);

    public String getIdSanPhamById(String id);

    public String getIdMauSacById(String id);

    public String getIdDongSPById(String id);

    public String getIdNSXById(String id);

    public ChiTietSP getById(String id);

    public List<SanPhamCustom> getListSP();

    public SanPhamChiTietCustom getProductById(String id);

    public float getGiaBanById(String id);
}
