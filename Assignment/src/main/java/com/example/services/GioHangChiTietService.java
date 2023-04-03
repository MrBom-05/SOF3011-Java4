package com.example.services;

import com.example.entities.GioHangChiTiet;
import com.example.models.GioHangChiTietCustom;

import java.util.List;
import java.util.UUID;

public interface GioHangChiTietService {
    public List<GioHangChiTietCustom> getList(UUID id);

    public boolean insert(GioHangChiTiet gioHangChiTiet);

    public boolean deleteOne(UUID idSP, UUID idGH);

    public boolean deleteAll(UUID idGH);

    public boolean updateProduct(UUID idSP, UUID idGH, int soLuong);

    public boolean updateCart(UUID idSP, UUID idGH, int soLuong);

    public boolean check(UUID idSP, UUID idGH);

    public int index(UUID id);

    public int getSoluongGioHangByID(UUID idSP, UUID idGH);
}
