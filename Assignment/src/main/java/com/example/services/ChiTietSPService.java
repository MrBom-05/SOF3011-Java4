package com.example.services;

import com.example.entities.ChiTietSP;
import com.example.models.ChiTietSPCustom;
import com.example.models.SanPhamChiTietCustom;
import com.example.models.SanPhamCustom;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface ChiTietSPService {
    public List<ChiTietSPCustom> getListChiTietSP();

    public boolean insert(ChiTietSP chiTietSP);

    public boolean delete(UUID id);

    public boolean update(UUID id, ChiTietSP chiTietSP);

    public UUID getIdSanPhamById(UUID id);

    public UUID getIdMauSacById(UUID id);

    public UUID getIdDongSPById(UUID id);

    public UUID getIdNSXById(UUID id);

    public ChiTietSP getById(UUID id);

    public List<SanPhamCustom> getListSP();

    public SanPhamChiTietCustom getProductById(UUID id);

    public BigDecimal getGiaBanById(UUID id);
}
