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

    @Override
    public boolean delete(String id) {
        return chucVuRepository.delete(id);
    }

    @Override
    public ChucVu getById(String id) {
        return chucVuRepository.getById(id);
    }
}
