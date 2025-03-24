package org.example.md4_nguyennguyentin.service;


import org.example.md4_nguyennguyentin.entity.KhachHang;
import org.example.md4_nguyennguyentin.repository.KhachHangRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangService {
    private final KhachHangRepository repository;

    public KhachHangService(KhachHangRepository repository) {
        this.repository = repository;
    }

    public List<KhachHang> getAll() {
        return repository.findAll();
    }
}
