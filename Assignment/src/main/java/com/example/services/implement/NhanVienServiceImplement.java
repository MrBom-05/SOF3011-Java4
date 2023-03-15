package com.example.services.implement;

import com.example.entities.NhanVien;
import com.example.models.NhanVienCustom;
import com.example.repositories.NhanVienRepository;
import com.example.services.NhanVienService;

import java.util.List;

public class NhanVienServiceImplement implements NhanVienService {

    private NhanVienRepository nhanVienRepository = new NhanVienRepository();

    @Override
    public List<NhanVienCustom> getListNhanVien() {
        return nhanVienRepository.getListNhanVien();
    }

    @Override
    public boolean insert(NhanVien nhanVien) {
        return nhanVienRepository.insert(nhanVien);
    }
}
