package com.example.services;

import com.example.entities.HoaDon;
import com.example.models.HoaDonCustom;

import java.util.List;
import java.util.UUID;

public interface HoaDonService {
    public List<HoaDonCustom> getListHoaDon();

    public UUID insert(HoaDon hoaDon);
}
