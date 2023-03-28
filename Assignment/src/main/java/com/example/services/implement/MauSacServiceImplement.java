package com.example.services.implement;

import com.example.entities.MauSac;
import com.example.repositories.MauSacRepository;
import com.example.services.MauSacService;

import java.util.List;
import java.util.UUID;

public class MauSacServiceImplement implements MauSacService {

    private MauSacRepository mauSacRepository = new MauSacRepository();

    @Override
    public List<MauSac> getListMauSac() {
        return mauSacRepository.getListMauSac();
    }

    @Override
    public boolean insert(MauSac mauSac) {
        return mauSacRepository.insert(mauSac);
    }

    @Override
    public boolean delete(UUID id) {
        return mauSacRepository.delete(id);
    }

    @Override
    public boolean update(UUID id, MauSac mauSac) {
        return mauSacRepository.update(id, mauSac);
    }

    @Override
    public MauSac getById(UUID id) {
        return mauSacRepository.getById(id);
    }
}
