package com.example.services.implement;

import com.example.entities.NSX;
import com.example.repositories.NSXRepository;
import com.example.services.NSXService;

import java.util.List;
import java.util.UUID;

public class NSXServiceImplement implements NSXService {

    private NSXRepository nsxRepository = new NSXRepository();

    @Override
    public List<NSX> getListNSX() {
        return nsxRepository.getListNSX();
    }

    @Override
    public boolean insert(NSX nsx) {
        return nsxRepository.insert(nsx);
    }

    @Override
    public boolean delete(UUID id) {
        return nsxRepository.delete(id);
    }

    @Override
    public boolean update(UUID id, NSX nsx) {
        return nsxRepository.update(id, nsx);
    }

    @Override
    public NSX getById(UUID id) {
        return nsxRepository.getById(id);
    }
}
