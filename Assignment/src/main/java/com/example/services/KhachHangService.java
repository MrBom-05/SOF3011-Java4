package com.example.services;

import com.example.entities.KhachHang;

import java.util.List;

public interface KhachHangService {
    public List<KhachHang> getListKhachHang();

    public boolean insert(KhachHang khachHang);
}