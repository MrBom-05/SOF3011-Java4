package com.example.services.implement;

import com.example.entities.SanPham;
import com.example.repositories.SanPhamRepository;
import com.example.services.SanPhamService;

import java.util.List;
import java.util.UUID;

public class SanPhamServiceImplement implements SanPhamService {

    private SanPhamRepository sanPhamRepository = new SanPhamRepository();

    @Override
    public List<SanPham> getListSanPham() {
        return sanPhamRepository.getListSanPham();
    }

    @Override
    public boolean insert(SanPham sanPham) {
        return sanPhamRepository.insert(sanPham);
    }

    @Override
    public boolean delete(UUID id) {
        return sanPhamRepository.delete(id);
    }

    @Override
    public boolean update(UUID id, SanPham sanPham) {
        return sanPhamRepository.update(id, sanPham);
    }

    @Override
    public SanPham getById(UUID id) {
        return sanPhamRepository.getById(id);
    }
}
