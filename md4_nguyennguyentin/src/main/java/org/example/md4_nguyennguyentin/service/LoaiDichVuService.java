package org.example.md4_nguyennguyentin.service;

import org.example.md4_nguyennguyentin.entity.KhachHang;
import org.example.md4_nguyennguyentin.entity.LoaiDichVu;
import org.example.md4_nguyennguyentin.repository.ILoaiDichVuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaiDichVuService {
    @Autowired
    private ILoaiDichVuRepository loaiDichVuRepository;

    public List<LoaiDichVu> getAll() {
        return loaiDichVuRepository.findAll();
    }


    public void save(LoaiDichVu s) {
        loaiDichVuRepository.save(s);
    }


    public void update(Long id, LoaiDichVu s) {

    }

    public void remove(Long id) {
        loaiDichVuRepository.deleteById(id);
    }


    public LoaiDichVu findById(Long id) {
        return loaiDichVuRepository.findById(id).orElse(null);
    }


    public List<LoaiDichVu> findByName(String name) {
        return null;
    }

}
