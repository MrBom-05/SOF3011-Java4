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
}
