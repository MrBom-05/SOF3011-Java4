package com.example.services;

import com.example.entities.HoaDonChiTiet;
import com.example.models.HoaDonChiTietCustom;

import java.util.List;
import java.util.UUID;

public interface HoaDonChiTietService {

    public boolean insert(HoaDonChiTiet hoaDonChiTiet);

    public List<HoaDonChiTietCustom> getListByID(UUID id);
}
