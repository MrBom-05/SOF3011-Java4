package com.example.services.implement;

import com.example.entities.ChiTietSP;
import com.example.models.ChiTietSPCustom;
import com.example.models.SanPhamChiTietCustom;
import com.example.models.SanPhamCustom;
import com.example.repositories.ChiTietSPRepository;
import com.example.services.ChiTietSPService;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

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
    public boolean delete(UUID id) {
        return chiTietSPRepository.delete(id);
    }

    @Override
    public boolean update(ChiTietSP chiTietSP) {
        return chiTietSPRepository.update(chiTietSP);
    }

    @Override
    public UUID getIdSanPhamById(UUID id) {
        return chiTietSPRepository.getIdById(id, chiTietSPRepository.getIdSanPhamById);
    }

    @Override
    public UUID getIdMauSacById(UUID id) {
        return chiTietSPRepository.getIdById(id, chiTietSPRepository.getIdMauSacById);
    }

    @Override
    public UUID getIdDongSPById(UUID id) {
        return chiTietSPRepository.getIdById(id, chiTietSPRepository.getIdDongSPById);
    }

    @Override
    public UUID getIdNSXById(UUID id) {
        return chiTietSPRepository.getIdById(id, chiTietSPRepository.getIdNSXById);
    }

    @Override
    public ChiTietSP getById(UUID id) {
        return chiTietSPRepository.getById(id);
    }

    @Override
    public List<SanPhamCustom> getListSP() {
        return chiTietSPRepository.getListSP();
    }

    @Override
    public SanPhamChiTietCustom getProductById(UUID id) {
        return chiTietSPRepository.getProductById(id);
    }

    @Override
    public BigDecimal getGiaBanById(UUID id) {
        return chiTietSPRepository.getGiaBanById(id);
    }

    @Override
    public boolean updateProductQuantity(UUID id, int newQuantity, int oldQuantity) {
        return chiTietSPRepository.updateProductQuantity(id, newQuantity, oldQuantity);
    }

    @Override
    public boolean updateProductQuantityByDeleteGioHang(UUID id, int oldQuantity) {
        return chiTietSPRepository.updateProductQuantityByDeleteGioHang(id, oldQuantity);
    }
}
