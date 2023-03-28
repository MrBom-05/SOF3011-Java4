package com.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GioHangChiTietCustom {
    private String id;
    private String ten;
    private String anh;
    private String mauSac;
    private BigDecimal giaBan;
    private int soLuong;
}
