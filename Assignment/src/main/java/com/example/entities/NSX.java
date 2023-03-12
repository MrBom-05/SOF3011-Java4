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
public class NSX implements Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private String id;

    @Column(name = "Ma", columnDefinition = "Varchar(20)", unique = true)
    private String ma;

    @Column(name = "Ten", columnDefinition = "Nvarchar(30)")
    private String ten;

    @OneToMany(mappedBy = "nsx", fetch = FetchType.EAGER)
    private List<ChiTietSP> listChiTietSP;

    public NSX(String id, String ma, String ten, List<ChiTietSP> listChiTietSP) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.listChiTietSP = listChiTietSP;
    }

    public NSX(String id, String ma, String ten) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
    }

    public NSX(String id) {
        this.id = id;
    }

    public NSX() {
    }

    @Override
    public String toString() {
        return ten;
    }
}
