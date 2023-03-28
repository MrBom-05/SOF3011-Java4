package com.example.services;

import com.example.entities.DongSP;

import java.util.List;
import java.util.UUID;

public interface DongSPService {
    public List<DongSP> getListDongSP();

    public boolean insert(DongSP dongSP);

    public boolean delete(UUID id);

    public boolean update(UUID id, DongSP dongSP);

    public DongSP getById(UUID id);
}
