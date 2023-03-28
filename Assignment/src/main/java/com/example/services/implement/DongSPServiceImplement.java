package com.example.services.implement;

import com.example.entities.DongSP;
import com.example.repositories.DongSPRepository;
import com.example.services.DongSPService;

import java.util.List;
import java.util.UUID;

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

    @Override
    public boolean delete(UUID id) {
        return dongSPRepository.delete(id);
    }

    @Override
    public boolean update(UUID id, DongSP dongSP) {
        return dongSPRepository.update(id, dongSP);
    }

    @Override
    public DongSP getById(UUID id) {
        return dongSPRepository.getById(id);
    }
}
