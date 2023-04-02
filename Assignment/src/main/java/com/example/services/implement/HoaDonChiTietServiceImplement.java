package com.example.services.implement;

import com.example.entities.HoaDonChiTiet;
import com.example.models.HoaDonChiTietCustom;
import com.example.repositories.HoaDonChiTietRepository;
import com.example.services.HoaDonChiTietService;

import java.util.List;
import java.util.UUID;

public class HoaDonChiTietServiceImplement implements HoaDonChiTietService {

    private HoaDonChiTietRepository hoaDonChiTietRepository = new HoaDonChiTietRepository();

    @Override
    public boolean insert(HoaDonChiTiet hoaDonChiTiet) {
        return hoaDonChiTietRepository.insert(hoaDonChiTiet);
    }

    @Override
    public List<HoaDonChiTietCustom> getListByID(UUID id) {
        return hoaDonChiTietRepository.getListByID(id);
    }
}
