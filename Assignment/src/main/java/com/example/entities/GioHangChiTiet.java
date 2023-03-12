package com.example.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
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
    private Float donGia;

    @Column(name = "DonGiaKhiGiam", columnDefinition = "Decimal(20,0)")
    private Float donGiaKhiGiam;

    public GioHangChiTiet(GioHang gioHang, ChiTietSP chiTietSP, int soLuong, Float donGia, Float donGiaKhiGiam) {
        this.gioHang = gioHang;
        this.chiTietSP = chiTietSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.donGiaKhiGiam = donGiaKhiGiam;
    }

    public GioHangChiTiet(GioHang gioHang, ChiTietSP chiTietSP, int soLuong, Float donGia) {
        this.gioHang = gioHang;
        this.chiTietSP = chiTietSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public GioHangChiTiet() {
    }
}
