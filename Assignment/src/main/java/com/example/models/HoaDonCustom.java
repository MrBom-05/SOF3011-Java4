package com.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HoaDonCustom {
    private String id;
    private String ma;
    private String tenNV;
    private String tenKH;
    private String sdtKH;
    private String diaChiKH;
    private Date ngayTao;
    private Date ngayShip;
    private Date ngayNhan;
    private Date ngayThanhToan;
    private int trangThai;

    public String getTrangThai() {
        if (trangThai == 1){
            return "Đã Ship";
        } else if (trangThai == 2) {
            return "Đã Nhận";
        } else if (trangThai == 3) {
            return "Đã Thanh Toán";
        }
        return "Chưa Thanh Toán";
    }
}
