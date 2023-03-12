package com.example.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table
public class HoaDonChiTiet implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "idHoaDon")
    private HoaDon hoaDon;

    @Id
    @ManyToOne
    @JoinColumn(name = "idChiTietSP")
    private ChiTietSP chiTietSP;

    @Column(name = "SoLuong")
    private int soLuongTon;

    @Column(name = "DonGia", columnDefinition = "Decimal(20,0)")
    private Float donGia;

    public HoaDonChiTiet(HoaDon hoaDon, ChiTietSP chiTietSP, int soLuongTon, Float donGia) {
        this.hoaDon = hoaDon;
        this.chiTietSP = chiTietSP;
        this.soLuongTon = soLuongTon;
        this.donGia = donGia;
    }

    public HoaDonChiTiet() {
    }
}
