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
}
