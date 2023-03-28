package com.example.services;

import com.example.entities.KhachHang;

import java.util.List;
import java.util.UUID;

public interface KhachHangService {
    public List<KhachHang> getListKhachHang();

    public boolean insert(KhachHang khachHang);

    public boolean delete(UUID id);

    public boolean update(UUID id, KhachHang khachHang);

    public KhachHang getById(UUID id);

    public KhachHang login(String email, String matKhau);
}
