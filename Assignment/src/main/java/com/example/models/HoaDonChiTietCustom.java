package com.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HoaDonChiTietCustom {
    private UUID id;
    private String ten;
    private String anh;
    private String mauSac;
    private BigDecimal giaBan;
    private int soLuong;
}
