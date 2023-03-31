package com.example.services.implement;

import com.example.entities.GioHangChiTiet;
import com.example.models.GioHangChiTietCustom;
import com.example.repositories.GioHangChiTietRepository;
import com.example.services.GioHangChiTietService;

import java.util.List;
import java.util.UUID;

public class GioHangChiTietServiceImplement implements GioHangChiTietService {

    private GioHangChiTietRepository gioHangChiTietRepository = new GioHangChiTietRepository();

    @Override
    public List<GioHangChiTietCustom> getList(UUID id) {
        return gioHangChiTietRepository.getList(id);
    }

    @Override
    public boolean insert(GioHangChiTiet gioHangChiTiet) {
        return gioHangChiTietRepository.insert(gioHangChiTiet);
    }

    @Override
    public boolean delete(UUID idSP, UUID idGH) {
        return gioHangChiTietRepository.delete(idSP, idGH);
    }

    @Override
    public boolean update(UUID idSP, UUID idGH, int soLuong) {
        return gioHangChiTietRepository.update(idSP, idGH, soLuong);
    }

    @Override
    public boolean check(UUID idSP, UUID idGH) {
        return gioHangChiTietRepository.check(idSP, idGH);
    }
}
