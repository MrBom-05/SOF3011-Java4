package com.example.services;

import com.example.entities.CuaHang;

import java.util.List;

public interface CuaHangService {
    public List<CuaHang> getListCuaHang();

    public boolean insert(CuaHang cuaHang);
}
