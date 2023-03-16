package com.example.services.implement;

import com.example.entities.ChiTietSP;
import com.example.models.ChiTietSPCustom;
import com.example.repositories.ChiTietSPRepository;
import com.example.services.ChiTietSPService;

import java.util.List;

public class ChiTietSPServiceImplement implements ChiTietSPService {

    private ChiTietSPRepository chiTietSPRepository = new ChiTietSPRepository();

    @Override
    public List<ChiTietSPCustom> getListChiTietSP() {
        return chiTietSPRepository.getListChiTietSP();
    }

    @Override
    public boolean insert(ChiTietSP chiTietSP) {
        return chiTietSPRepository.insert(chiTietSP);
    }

    @Override
    public boolean delete(String id) {
        return chiTietSPRepository.delete(id);
    }

    @Override
    public String getIdSanPhamById(String id) {
        return chiTietSPRepository.getIdById(id, chiTietSPRepository.getIdSanPhamById);
    }

    @Override
    public String getIdMauSacById(String id) {
        return chiTietSPRepository.getIdById(id, chiTietSPRepository.getIdMauSacById);
    }

    @Override
    public String getIdDongSPById(String id) {
        return chiTietSPRepository.getIdById(id, chiTietSPRepository.getIdDongSPById);
    }

    @Override
    public String getIdNSXById(String id) {
        return chiTietSPRepository.getIdById(id, chiTietSPRepository.getIdNSXById);
    }

    @Override
    public ChiTietSP getById(String id) {
        return chiTietSPRepository.getById(id);
    }
}
