package org.example.md4_nguyennguyentin.service;

import org.example.md4_nguyennguyentin.entity.KhachHang;
import org.example.md4_nguyennguyentin.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class KhachHangService   {
    @Autowired
    private KhachHangRepository khachHangRepository;


    public List<KhachHang> getAll() {
        return khachHangRepository.findAll();
    }


    public void save(KhachHang s) {
        khachHangRepository.save(s);
    }


    public void update(Long id, KhachHang s) {

    }

    public void remove(Long id) {
        khachHangRepository.deleteById(id);
    }


    public KhachHang findById(Long id) {
        return khachHangRepository.findById(id).orElse(null);
    }


    public List<KhachHang> findByName(String name) {
        return null;
    }


}
