package com.example.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class CuaHang implements Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private String id;

    @Column(name = "Ma", columnDefinition = "Varchar(20)", unique = true)
    private String ma;

    @Column(name = "Ten", columnDefinition = "Nvarchar(MAX)")
    private String ten;

    @Column(name = "DiaChi", columnDefinition = "Nvarchar(MAX)")
    private String diaChi;

    @Column(name = "ThanhPho", columnDefinition = "Nvarchar(MAX)")
    private String thanhPho;

    @Column(name = "QuocGia", columnDefinition = "Nvarchar(MAX)")
    private String quocGia;

    @OneToMany(mappedBy = "chucVu", fetch = FetchType.EAGER)
    private List<NhanVien> listNhanVien;

    public CuaHang(String id, String ma, String ten, String diaChi, String thanhPho, String quocGia, List<NhanVien> listNhanVien) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.diaChi = diaChi;
        this.thanhPho = thanhPho;
        this.quocGia = quocGia;
        this.listNhanVien = listNhanVien;
    }

    public CuaHang(String id, String ma, String ten, String diaChi, String thanhPho, String quocGia) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.diaChi = diaChi;
        this.thanhPho = thanhPho;
        this.quocGia = quocGia;
    }

    public CuaHang(String id) {
        this.id = id;
    }

    public CuaHang() {
    }

    @Override
    public String toString() {
        return ten;
    }
}
