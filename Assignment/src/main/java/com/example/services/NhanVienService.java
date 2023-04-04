package com.example.services;

import com.example.entities.ChiTietSP;
import com.example.entities.NhanVien;
import com.example.models.NhanVienCustom;

import java.util.List;
import java.util.UUID;

public interface NhanVienService {
    public List<NhanVienCustom> getListNhanVien();

    public boolean insert(NhanVien nhanVien);

    public boolean delete(String ma);

    public boolean update(String ma, NhanVien nhanVien);

    public UUID getIdCuaHangByMa(String ma);

    public UUID getIdChucVuByMa(String ma);

    public NhanVien getByMa(String ma);

    public NhanVien login(String email, String matKhau);
}
