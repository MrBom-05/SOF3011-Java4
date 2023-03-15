package com.example.services.implement;

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
}
