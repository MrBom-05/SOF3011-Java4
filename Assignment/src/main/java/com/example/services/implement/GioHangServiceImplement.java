package com.example.services.implement;

import com.example.entities.GioHang;
import com.example.repositories.GioHangRepository;
import com.example.services.GioHangService;

public class GioHangServiceImplement implements GioHangService {

    private GioHangRepository gioHangRepository = new GioHangRepository();

    @Override
    public boolean insert(GioHang gioHang) {
        return gioHangRepository.insert(gioHang);
    }

    @Override
    public boolean check(String id) {
        return gioHangRepository.check(id);
    }

    @Override
    public String getById(String id) {
        return gioHangRepository.getById(id);
    }
}
