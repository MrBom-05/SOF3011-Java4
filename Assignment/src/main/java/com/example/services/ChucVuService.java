package com.example.services;

import com.example.entities.ChucVu;

import java.util.List;

public interface ChucVuService {
    public List<ChucVu> getListChucVu();

    public boolean insert(ChucVu chucVu);
}
