package com.example.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class HoaDon implements Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private String id;

    @ManyToOne
    @JoinColumn(name = "idKH")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "idNV")
    private NhanVien nhanVien;

    @Column(name = "Ma", columnDefinition = "Varchar(20)", unique = true)
    private String ma;

    @Column(name = "NgayTao")
    private Date ngayTao;

    @Column(name = "NgayThanhToan")
    private Date ngayThanhToan;

    @Column(name = "NgayShip")
    private Date ngayShip;

    @Column(name = "NgayNhan")
    private Date ngayNhan;

    @Column(name = "TrangThai")
    private int trangThai;

    @Column(name = "TenNguoiNhan", columnDefinition = "Nvarchar(50)")
    private String tenNguoiNhan;

    @Column(name = "DiaChi", columnDefinition = "Nvarchar(100)")
    private String diaChi;

    @Column(name = "Sdt", columnDefinition = "Varchar(30)")
    private String sdt;

    @OneToMany(mappedBy = "hoaDon", fetch = FetchType.EAGER)
    private List<HoaDonChiTiet> listHoaDonChiTiet;

    public HoaDon(String id, KhachHang khachHang, NhanVien nhanVien, String ma, Date ngayTao, Date ngayThanhToan, Date ngayShip, Date ngayNhan, int trangThai, String tenNguoiNhan, String diaChi, String sdt, List<HoaDonChiTiet> listHoaDonChiTiet) {
        this.id = id;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.ngayShip = ngayShip;
        this.ngayNhan = ngayNhan;
        this.trangThai = trangThai;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.listHoaDonChiTiet = listHoaDonChiTiet;
    }

    public HoaDon(String id, KhachHang khachHang, String ma, Date ngayTao, int trangThai) {
        this.id = id;
        this.khachHang = khachHang;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public HoaDon(String id, NhanVien nhanVien, String ma, Date ngayTao, int trangThai) {
        this.id = id;
        this.nhanVien = nhanVien;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public HoaDon(String id, NhanVien nhanVien, Date ngayThanhToan, int trangThai) {
        this.id = id;
        this.nhanVien = nhanVien;
        this.ngayThanhToan = ngayThanhToan;
        this.trangThai = trangThai;
    }

    public HoaDon(String id) {
        this.id = id;
    }

    public HoaDon() {
    }
}
