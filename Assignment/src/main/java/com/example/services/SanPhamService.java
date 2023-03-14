package com.example.services;

import com.example.entities.SanPham;

import java.util.List;

public interface SanPhamService {
    public List<SanPham> getListSanPham();

    public boolean insert(SanPham sanPham);
}
