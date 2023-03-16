package com.example.services.implement;

import com.example.entities.SanPham;
import com.example.repositories.SanPhamRepository;
import com.example.services.SanPhamService;

import java.util.List;

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
    public boolean delete(String id) {
        return sanPhamRepository.delete(id);
    }

    @Override
    public SanPham getById(String id) {
        return sanPhamRepository.getById(id);
    }
}
