package com.example.entities;

import lombok.*;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class ChucVu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "Ma", columnDefinition = "Varchar(20)", unique = true)
    private String ma;

    @Column(name = "Ten", columnDefinition = "Nvarchar(30)")
    private String ten;

    @OneToMany(mappedBy = "chucVu", fetch = FetchType.LAZY)
    private List<NhanVien> listNhanVien;

}
