package com.example.services;

import com.example.entities.GioHangChiTiet;
import com.example.models.GioHangChiTietCustom;

import java.util.List;

public interface GioHangChiTietService {
    public List<GioHangChiTietCustom> getList(String id);

    public boolean insert(GioHangChiTiet gioHangChiTiet);

    public boolean delete(String idSP, String idGH);
}
