package com.example.services;

import com.example.entities.CuaHang;

import java.util.List;
import java.util.UUID;

public interface CuaHangService {
    public List<CuaHang> getListCuaHang();

    public boolean insert(CuaHang cuaHang);

    public boolean delete(UUID id);

    public boolean update(UUID id, CuaHang cuaHang);

    public CuaHang getById(UUID id);
}
