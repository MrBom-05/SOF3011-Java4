package com.example.services.implement;

import com.example.models.HoaDonCustom;
import com.example.repositories.HoaDonRepository;
import com.example.services.HoaDonService;

import java.util.List;

public class HoaDonServiceImplement implements HoaDonService {

    private HoaDonRepository hoaDonRepository = new HoaDonRepository();

    @Override
    public List<HoaDonCustom> getListHoaDon() {
        return hoaDonRepository.getListHoaDon();
    }
}
