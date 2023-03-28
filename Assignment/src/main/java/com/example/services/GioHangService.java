package com.example.services;

import com.example.entities.GioHang;

import java.util.UUID;

public interface GioHangService {
    public boolean insert(GioHang gioHang);

    public boolean check(UUID id);

    public UUID getById(UUID id);
}
