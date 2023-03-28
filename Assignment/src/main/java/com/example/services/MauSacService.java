package com.example.services;

import com.example.entities.MauSac;

import java.util.List;
import java.util.UUID;

public interface MauSacService {
    public List<MauSac> getListMauSac();

    public boolean insert(MauSac mauSac);

    public boolean delete(UUID id);

    public boolean update(UUID id, MauSac mauSac);

    public MauSac getById(UUID id);
}
