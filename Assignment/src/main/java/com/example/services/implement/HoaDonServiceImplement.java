package com.example.services.implement;

import com.example.entities.HoaDon;
import com.example.models.HoaDonCustom;
import com.example.repositories.HoaDonRepository;
import com.example.services.HoaDonService;

import java.util.List;
import java.util.UUID;

public class HoaDonServiceImplement implements HoaDonService {

    private HoaDonRepository hoaDonRepository = new HoaDonRepository();

    @Override
    public List<HoaDonCustom> getListHoaDon() {
        return hoaDonRepository.getListHoaDon();
    }

    @Override
    public UUID insert(HoaDon hoaDon) {
        return hoaDonRepository.insert(hoaDon);
    }
}
