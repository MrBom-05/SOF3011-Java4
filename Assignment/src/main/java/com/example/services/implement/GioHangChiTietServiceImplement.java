package com.example.services.implement;

import com.example.entities.GioHangChiTiet;
import com.example.models.GioHangChiTietCustom;
import com.example.repositories.GioHangChiTietRepository;
import com.example.services.GioHangChiTietService;

import java.util.List;

public class GioHangChiTietServiceImplement implements GioHangChiTietService {

    private GioHangChiTietRepository gioHangChiTietRepository = new GioHangChiTietRepository();

    @Override
    public List<GioHangChiTietCustom> getList(String id) {
        return gioHangChiTietRepository.getList(id);
    }

    @Override
    public boolean insert(GioHangChiTiet gioHangChiTiet) {
        return gioHangChiTietRepository.insert(gioHangChiTiet);
    }

    @Override
    public boolean delete(String idSP, String idGH) {
        return gioHangChiTietRepository.delete(idSP, idGH);
    }
}
