package com.example.services.implement;

import com.example.entities.CuaHang;
import com.example.repositories.CuaHangRepository;
import com.example.services.CuaHangService;

import java.util.List;

public class CuaHangServiceImplement implements CuaHangService {

    private CuaHangRepository cuaHangRepository = new CuaHangRepository();


    @Override
    public List<CuaHang> getListCuaHang() {
        return cuaHangRepository.getListCuaHang();
    }

    @Override
    public boolean insert(CuaHang cuaHang) {
        return cuaHangRepository.insert(cuaHang);
    }

    @Override
    public boolean delete(String id) {
        return cuaHangRepository.delete(id);
    }

    @Override
    public CuaHang getById(String id) {
        return cuaHangRepository.getById(id);
    }
}
