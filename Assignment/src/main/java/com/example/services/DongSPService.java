package com.example.services;

import com.example.entities.DongSP;

import java.util.List;

public interface DongSPService {
    public List<DongSP> getListDongSP();

    public boolean insert(DongSP dongSP);
}
