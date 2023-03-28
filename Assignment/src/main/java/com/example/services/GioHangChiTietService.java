package com.example.services;

import com.example.entities.GioHangChiTiet;
import com.example.models.GioHangChiTietCustom;

import java.util.List;
import java.util.UUID;

public interface GioHangChiTietService {
    public List<GioHangChiTietCustom> getList(UUID id);

    public boolean insert(GioHangChiTiet gioHangChiTiet);

    public boolean delete(UUID idSP, UUID idGH);
}
