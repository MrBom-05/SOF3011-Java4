package com.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HoaDonUserCustom {
    private UUID id;
    private String ma;
    private Date ngayTao;
    private long tongSoLuong;
    private BigDecimal tongTien;
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
