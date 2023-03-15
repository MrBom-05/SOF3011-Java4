package com.example.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class MauSac implements Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private String id;

    @Column(name = "Ma", columnDefinition = "Varchar(20)", unique = true)
    private String ma;

    @Column(name = "Ten", columnDefinition = "Nvarchar(30)")
    private String ten;

    @OneToMany(mappedBy = "mauSac", fetch = FetchType.LAZY)
    private List<ChiTietSP> listChiTietSP;
}
