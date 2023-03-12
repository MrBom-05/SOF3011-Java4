package com.example.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class ChiTietSP implements Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private String id;

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

    @Column(name = "NamBH")
    private int namBH;

    @Column(name = "MoTa", columnDefinition = "Nvarchar(MAX)")
    private String moTa;

    @Column(name = "SoLuongTon")
    private int soLuongTon;

    @Column(name = "GiaNhap", columnDefinition = "Decimal(20,0)")
    private Float giaNhap;

    @Column(name = "GiaBan", columnDefinition = "Decimal(20,0)")
    private Float giaBan;

    @OneToMany(mappedBy = "chiTietSP", fetch = FetchType.EAGER)
    private List<GioHangChiTiet> listGioHangChiTiet;

    @OneToMany(mappedBy = "chiTietSP", fetch = FetchType.EAGER)
    private List<HoaDonChiTiet> listHoaDonChiTiet;

    public ChiTietSP(String id, SanPham sanPham, NSX nsx, MauSac mauSac, DongSP dongSP, int namBH, String moTa, int soLuongTon, Float giaNhap, Float giaBan, List<GioHangChiTiet> listGioHangChiTiet, List<HoaDonChiTiet> listHoaDonChiTiet) {
        this.id = id;
        this.sanPham = sanPham;
        this.nsx = nsx;
        this.mauSac = mauSac;
        this.dongSP = dongSP;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.listGioHangChiTiet = listGioHangChiTiet;
        this.listHoaDonChiTiet = listHoaDonChiTiet;
    }

    public ChiTietSP(String id, SanPham sanPham, NSX nsx, MauSac mauSac, DongSP dongSP, int namBH, String moTa, int soLuongTon, Float giaNhap, Float giaBan) {
        this.id = id;
        this.sanPham = sanPham;
        this.nsx = nsx;
        this.mauSac = mauSac;
        this.dongSP = dongSP;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public ChiTietSP(String id) {
        this.id = id;
    }

    public ChiTietSP() {
    }
}
