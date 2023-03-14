package com.example.services.implement;

import com.example.entities.DongSP;
import com.example.repositories.DongSPRepository;
import com.example.services.DongSPService;

import java.util.List;

public class DongSPServiceImplement implements DongSPService {

    private DongSPRepository dongSPRepository = new DongSPRepository();

    @Override
    public List<DongSP> getListDongSP() {
        return dongSPRepository.getListDongSP();
    }

    @Override
    public boolean insert(DongSP dongSP) {
        return dongSPRepository.insert(dongSP);
    }
}
