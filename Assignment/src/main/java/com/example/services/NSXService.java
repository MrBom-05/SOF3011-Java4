package com.example.services;

import com.example.entities.NSX;

import java.util.List;
import java.util.UUID;

public interface NSXService {
    public List<NSX> getListNSX();

    public boolean insert(NSX nsx);

    public boolean delete(UUID id);

    public boolean update(UUID id, NSX nsx);

    public NSX getById(UUID id);
}
