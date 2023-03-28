package com.example.services;

import com.example.entities.SanPham;

import java.util.List;
import java.util.UUID;

public interface SanPhamService {
    public List<SanPham> getListSanPham();

    public boolean insert(SanPham sanPham);

    public boolean delete(UUID id);

    public boolean update(UUID id, SanPham sanPham);

    public SanPham getById(UUID id);
}
