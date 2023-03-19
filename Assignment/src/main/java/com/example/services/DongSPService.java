package com.example.services;

import com.example.entities.DongSP;

import java.util.List;

public interface DongSPService {
    public List<DongSP> getListDongSP();

    public boolean insert(DongSP dongSP);

    public boolean delete(String id);

    public boolean update(String id, DongSP dongSP);

    public DongSP getById(String id);
}
