package com.example.services.implement;

import com.example.entities.KhachHang;
import com.example.repositories.KhachHangRepository;
import com.example.services.KhachHangService;

import java.util.List;
import java.util.UUID;

public class KhachHangServiceImplement implements KhachHangService {

    private KhachHangRepository khachHangRepository = new KhachHangRepository();


    @Override
    public List<KhachHang> getListKhachHang() {
        return khachHangRepository.getListKhachHang();
    }

    @Override
    public boolean insert(KhachHang khachHang) {
        return khachHangRepository.insert(khachHang);
    }

    @Override
    public boolean delete(UUID id) {
        return khachHangRepository.delete(id);
    }

    @Override
    public boolean update(UUID id, KhachHang khachHang) {
        return khachHangRepository.update(id, khachHang);
    }

    @Override
    public KhachHang getById(UUID id) {
        return khachHangRepository.getById(id);
    }

    @Override
    public KhachHang login(String email, String matKhau) {
        return khachHangRepository.login(email, matKhau);
    }
}
