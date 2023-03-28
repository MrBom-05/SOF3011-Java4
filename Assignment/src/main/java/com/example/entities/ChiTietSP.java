package com.example.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class ChiTietSP implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "idSP")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "idNSX")
    private NSX nsx;

    @ManyToOne
    @JoinColumn(name = "idMauSac")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "idDongSP")
    private DongSP dongSP;

    @Column(name = "NamSX")
    private int namSX;

    @Column(name = "MoTa", columnDefinition = "Nvarchar(MAX)")
    private String moTa;

    @Column(name = "SoLuongTon")
    private int soLuongTon;

    @Column(name = "GiaNhap", columnDefinition = "Decimal(20,0)")
    private BigDecimal giaNhap;

    @Column(name = "GiaBan", columnDefinition = "Decimal(20,0)")
    private BigDecimal giaBan;

    @OneToMany(mappedBy = "chiTietSP", fetch = FetchType.LAZY)
    private List<GioHangChiTiet> listGioHangChiTiet;

    @OneToMany(mappedBy = "chiTietSP", fetch = FetchType.LAZY)
    private List<HoaDonChiTiet> listHoaDonChiTiet;
}
