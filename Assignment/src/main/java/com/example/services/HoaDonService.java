package com.example.services;

import com.example.entities.HoaDon;
import com.example.models.HoaDonAdminCustom;
import com.example.models.HoaDonCustom;
import com.example.models.HoaDonUserCustom;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

public interface HoaDonService {
    public List<HoaDonAdminCustom> getListHoaDon();

    public UUID insert(HoaDon hoaDon);

    public List<HoaDonUserCustom> getListHoaDonByUser(UUID id);

    public HoaDonCustom getByID(UUID id);

    public boolean updateHoaDonNgayShip(UUID id, int trangThai, Date date);

    public boolean updateHoaDonNgayNhan(UUID id, int trangThai, Date date);

    public boolean updateHoaDonNgayThanhToan(UUID id, int trangThai, Date date);
}
