package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class KhachHang {
    private String idKhachHang;

    private String maKhachHang;

    private String tenKhachHang;

    private String ngaySinhKhachHang;

    private String sdtKhachHang;

    private String diaChiKhachHang;

    private String thanhPhoKhachHang;

    private String quocGiaKhachHang;

    private String emailKhachHang;

    private String matKhauKhachHang;

}
