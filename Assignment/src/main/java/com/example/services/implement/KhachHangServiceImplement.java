package com.example.services.implement;

import com.example.entities.KhachHang;
import com.example.repositories.KhachHangRepository;
import com.example.services.KhachHangService;

import java.util.List;

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
    public boolean delete(String id) {
        return khachHangRepository.delete(id);
    }

    @Override
    public boolean update(String id, KhachHang khachHang) {
        return khachHangRepository.update(id, khachHang);
    }

    @Override
    public KhachHang getById(String id) {
        return khachHangRepository.getById(id);
    }
}
