package com.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class NhanVienCustom {
    private String ma;
    private String ten;
    private String tenDem;
    private String ho;
    private String gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String sdt;
    private String cuaHang;
    private String chucVu;
    private String email;
    private String matKhau;
    private int trangThai;
}
