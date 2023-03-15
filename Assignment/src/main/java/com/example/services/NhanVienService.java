package com.example.services;

import com.example.entities.NhanVien;
import com.example.models.NhanVienCustom;

import java.util.List;

public interface NhanVienService {
    public List<NhanVienCustom> getListNhanVien();

    public boolean insert(NhanVien nhanVien);
}
