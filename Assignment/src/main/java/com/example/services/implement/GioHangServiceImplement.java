package com.example.services.implement;

import com.example.entities.GioHang;
import com.example.repositories.GioHangRepository;
import com.example.services.GioHangService;

import java.util.UUID;

public class GioHangServiceImplement implements GioHangService {

    private GioHangRepository gioHangRepository = new GioHangRepository();

    @Override
    public boolean insert(GioHang gioHang) {
        return gioHangRepository.insert(gioHang);
    }

    @Override
    public boolean check(UUID id) {
        return gioHangRepository.check(id);
    }

    @Override
    public UUID getById(UUID id) {
        return gioHangRepository.getById(id);
    }
}
