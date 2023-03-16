package com.example.services;

import com.example.entities.ChiTietSP;
import com.example.entities.NhanVien;
import com.example.models.NhanVienCustom;

import java.util.List;

public interface NhanVienService {
    public List<NhanVienCustom> getListNhanVien();

    public boolean insert(NhanVien nhanVien);

    public boolean delete(String ma);

    public String getIdCuaHangByMa(String ma);

    public String getIdChucVuByMa(String ma);

    public NhanVien getByMa(String ma);
}
