package com.example.services.implement;

import com.example.entities.MauSac;
import com.example.repositories.MauSacRepository;
import com.example.services.MauSacService;

import java.util.List;

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
}
