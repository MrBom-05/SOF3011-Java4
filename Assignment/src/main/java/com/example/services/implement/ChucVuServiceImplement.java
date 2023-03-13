package com.example.services.implement;

import com.example.entities.ChucVu;
import com.example.repositories.ChucVuRepository;
import com.example.services.ChucVuService;

import java.util.List;

public class ChucVuServiceImplement implements ChucVuService {

    private ChucVuRepository chucVuRepository = new ChucVuRepository();


    @Override
    public List<ChucVu> getListChucVu() {
        return chucVuRepository.getListChucVu();
    }

    @Override
    public boolean insert(ChucVu chucVu) {
        return chucVuRepository.insert(chucVu);
    }
}
