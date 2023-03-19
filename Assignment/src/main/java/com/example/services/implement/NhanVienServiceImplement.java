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

    @Override
    public boolean delete(String ma) {
        return nhanVienRepository.delete(ma);
    }

    @Override
    public boolean update(String ma, NhanVien nhanVien) {
        return nhanVienRepository.update(ma, nhanVien);
    }

    @Override
    public String getIdCuaHangByMa(String ma) {
        return nhanVienRepository.getIdByMa(ma, nhanVienRepository.getIdCuaHangByMa);
    }

    @Override
    public String getIdChucVuByMa(String ma) {
        return nhanVienRepository.getIdByMa(ma, nhanVienRepository.getIdChucVuByMa);
    }

    @Override
    public NhanVien getByMa(String ma) {
        return nhanVienRepository.getByMa(ma);
    }
}
