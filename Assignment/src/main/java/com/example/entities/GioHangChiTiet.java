package com.example.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class GioHangChiTiet implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "idGioHang")
    private GioHang gioHang;

    @Id
    @ManyToOne
    @JoinColumn(name = "idChiTietSP")
    private ChiTietSP chiTietSP;

    @Column(name = "SoLuong")
    private int soLuong;

    @Column(name = "DonGia", columnDefinition = "Decimal(20,0)")
    private BigDecimal donGia;

    @Column(name = "DonGiaKhiGiam", columnDefinition = "Decimal(20,0)")
    private BigDecimal donGiaKhiGiam;

    public GioHangChiTiet(GioHang gioHang, ChiTietSP chiTietSP, int soLuong, BigDecimal donGia) {
        this.gioHang = gioHang;
        this.chiTietSP = chiTietSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }
}
