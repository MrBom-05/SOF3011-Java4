package com.example.services;

import com.example.models.GioHangChiTietCustom;

import java.util.List;

public interface GioHangChiTietService {
    public List<GioHangChiTietCustom> getList(String id);
}
