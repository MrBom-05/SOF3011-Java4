package com.example.services;

import com.example.entities.CuaHang;

import java.util.List;

public interface CuaHangService {
    public List<CuaHang> getListCuaHang();

    public boolean insert(CuaHang cuaHang);

    public boolean delete(String id);

    public boolean update(String id, CuaHang cuaHang);

    public CuaHang getById(String id);
}
