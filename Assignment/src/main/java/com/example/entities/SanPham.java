package com.example.entities;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class SanPham implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "Ma", columnDefinition = "Varchar(20)", unique = true)
    private String ma;

    @Column(name = "Ten", columnDefinition = "Nvarchar(30)")
    private String ten;

    @Column(name = "Anh", columnDefinition = "Nvarchar(max)")
    private String anh;
    @OneToMany(mappedBy = "sanPham", fetch = FetchType.LAZY)
    private List<ChiTietSP> listChiTietSP;
}
