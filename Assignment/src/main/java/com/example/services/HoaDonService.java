package com.example.services;

import com.example.entities.HoaDon;
import com.example.models.HoaDonAdminCustom;
import com.example.models.HoaDonUserCustom;

import java.util.List;
import java.util.UUID;

public interface HoaDonService {
    public List<HoaDonAdminCustom> getListHoaDon();

    public UUID insert(HoaDon hoaDon);

    public List<HoaDonUserCustom> getListHoaDonByUser(UUID id);
}
