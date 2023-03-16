package com.example.services;

import com.example.entities.ChucVu;

import java.util.List;

public interface ChucVuService {
    public List<ChucVu> getListChucVu();

    public boolean insert(ChucVu chucVu);

    public boolean delete(String id);

    public ChucVu getById(String id);
}
