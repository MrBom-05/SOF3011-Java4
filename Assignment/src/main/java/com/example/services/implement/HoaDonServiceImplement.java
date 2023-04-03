package com.example.services.implement;

import com.example.entities.HoaDon;
import com.example.models.HoaDonAdminCustom;
import com.example.models.HoaDonCustom;
import com.example.models.HoaDonUserCustom;
import com.example.repositories.HoaDonRepository;
import com.example.services.HoaDonService;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

public class HoaDonServiceImplement implements HoaDonService {

    private HoaDonRepository hoaDonRepository = new HoaDonRepository();

    @Override
    public List<HoaDonAdminCustom> getListHoaDon() {
        return hoaDonRepository.getListHoaDon();
    }

    @Override
    public UUID insert(HoaDon hoaDon) {
        return hoaDonRepository.insert(hoaDon);
    }

    @Override
    public List<HoaDonUserCustom> getListHoaDonByUser(UUID id) {
        return hoaDonRepository.getListHoaDonByUser(id);
    }

    @Override
    public HoaDonCustom getByID(UUID id) {
        return hoaDonRepository.getByID(id);
    }

    @Override
    public boolean updateHoaDonNgayShip(UUID id, int trangThai, Date date) {
        return hoaDonRepository.updateHoaDon(id, trangThai, date, hoaDonRepository.ngayShip);
    }

    @Override
    public boolean updateHoaDonNgayNhan(UUID id, int trangThai, Date date) {
        return hoaDonRepository.updateHoaDon(id, trangThai, date, hoaDonRepository.ngayNhan);
    }

    @Override
    public boolean updateHoaDonNgayThanhToan(UUID id, int trangThai, Date date) {
        return hoaDonRepository.updateHoaDon(id, trangThai, date, hoaDonRepository.ngayThanhToan);
    }

}
