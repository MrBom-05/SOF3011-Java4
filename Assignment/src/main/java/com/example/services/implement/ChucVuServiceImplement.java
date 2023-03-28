package com.example.services.implement;

import com.example.entities.ChucVu;
import com.example.repositories.ChucVuRepository;
import com.example.services.ChucVuService;

import java.util.List;
import java.util.UUID;

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
    public boolean delete(UUID id) {
        return chucVuRepository.delete(id);
    }

    @Override
    public boolean update(UUID id, ChucVu chucVu) {
        return chucVuRepository.update(id, chucVu);
    }

    @Override
    public ChucVu getById(UUID id) {
        return chucVuRepository.getById(id);
    }
}
