package com.example.services.implement;

import com.example.entities.NSX;
import com.example.repositories.NSXRepository;
import com.example.services.NSXService;

import java.util.List;

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
    public boolean delete(String id) {
        return nsxRepository.delete(id);
    }

    @Override
    public NSX getById(String id) {
        return nsxRepository.getById(id);
    }
}
