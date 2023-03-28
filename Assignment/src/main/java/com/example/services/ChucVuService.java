package com.example.services;

import com.example.entities.ChucVu;

import java.util.List;
import java.util.UUID;

public interface ChucVuService {
    public List<ChucVu> getListChucVu();

    public boolean insert(ChucVu chucVu);

    public boolean delete(UUID id);

    public boolean update(UUID id, ChucVu chucVu);

    public ChucVu getById(UUID id);
}
