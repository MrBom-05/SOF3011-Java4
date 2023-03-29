package com.example.services.implement;

import com.example.entities.HoaDonChiTiet;
import com.example.repositories.HoaDonChiTietRepository;
import com.example.services.HoaDonChiTietService;
import com.example.services.HoaDonService;

public class HoaDonChiTietServiceImplement implements HoaDonChiTietService {

    private HoaDonChiTietRepository hoaDonChiTietRepository = new HoaDonChiTietRepository();

    @Override
    public boolean insert(HoaDonChiTiet hoaDonChiTiet) {
        return hoaDonChiTietRepository.insert(hoaDonChiTiet);
    }
}
