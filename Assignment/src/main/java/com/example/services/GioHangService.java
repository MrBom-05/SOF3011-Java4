package com.example.services;

import com.example.entities.GioHang;

public interface GioHangService {
    public boolean insert(GioHang gioHang);

    public boolean check(String id);

    public String getById(String id);
}
