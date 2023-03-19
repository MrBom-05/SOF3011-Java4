package com.example.services;

import com.example.entities.NSX;

import java.util.List;

public interface NSXService {
    public List<NSX> getListNSX();

    public boolean insert(NSX nsx);

    public boolean delete(String id);

    public boolean update(String id, NSX nsx);

    public NSX getById(String id);
}
