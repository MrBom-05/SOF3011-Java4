package com.example.services;

import com.example.entities.MauSac;

import java.util.List;

public interface MauSacService {
    public List<MauSac> getListMauSac();

    public boolean insert(MauSac mauSac);

    public boolean delete(String id);

    public MauSac getById(String id);
}
