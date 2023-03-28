package com.example.services.implement;

import com.example.entities.CuaHang;
import com.example.repositories.CuaHangRepository;
import com.example.services.CuaHangService;

import java.util.List;
import java.util.UUID;

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
    public boolean delete(UUID id) {
        return cuaHangRepository.delete(id);
    }

    @Override
    public boolean update(UUID id, CuaHang cuaHang) {
        return cuaHangRepository.update(id, cuaHang);
    }

    @Override
    public CuaHang getById(UUID id) {
        return cuaHangRepository.getById(id);
    }
}
