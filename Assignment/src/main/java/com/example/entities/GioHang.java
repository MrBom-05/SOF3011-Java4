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
public class GioHang implements Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private String id;

    @ManyToOne
    @JoinColumn(name = "idKH")
    private KhachHang khachHang;

    @Column(name = "idNV", columnDefinition = "uniqueidentifier")
    private String idNV;

    @Column(name = "Ma", columnDefinition = "Varchar(20)", unique = true)
    private String ma;

    @Column(name = "NgayTao")
    private Date ngayTao;

    @Column(name = "NgayThanhToan")
    private Date ngayThanhToan;

    @Column(name = "TenNguoiNhan", columnDefinition = "Nvarchar(50)")
    private String tenNguoiNhan;

    @Column(name = "DiaChi", columnDefinition = "Nvarchar(100)")
    private String diaChi;

    @Column(name = "Sdt", columnDefinition = "Varchar(30)")
    private String sdt;

    @Column(name = "TrangThai")
    private int trangThai;

    @OneToMany(mappedBy = "gioHang", fetch = FetchType.EAGER)
    private List<GioHangChiTiet> listGioHangChiTiet;

    public GioHang(String id, KhachHang khachHang, String idNV, String ma, Date ngayTao, Date ngayThanhToan, String tenNguoiNhan, String diaChi, String sdt, int trangThai, List<GioHangChiTiet> listGioHangChiTiet) {
        this.id = id;
        this.khachHang = khachHang;
        this.idNV = idNV;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.trangThai = trangThai;
        this.listGioHangChiTiet = listGioHangChiTiet;
    }

    public GioHang(String id, KhachHang khachHang, String ma, Date ngayTao, int trangThai) {
        this.id = id;
        this.khachHang = khachHang;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public GioHang(String id, String idNV, String ma, Date ngayTao, int trangThai) {
        this.id = id;
        this.idNV = idNV;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public GioHang(String id) {
        this.id = id;
    }

    public GioHang() {
    }
}
