package org.example.md4_nguyennguyentin.service;

import org.example.md4_nguyennguyentin.entity.GiaoDich;
import org.example.md4_nguyennguyentin.repository.GiaoDichRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiaoDichService implements IGiaoDichService{
    @Autowired
    private GiaoDichRepository giaoDichRepository;

    @Override
    public List<GiaoDich> getAll() {
        return giaoDichRepository.findAll();
    }

    @Override
    public void save(GiaoDich s) {
        giaoDichRepository.save(s);
    }

    @Override
    public void update(String id, GiaoDich s) {

    }

    @Override
    public void remove(String id) {
        giaoDichRepository.deleteById(id);
    }

    @Override
    public GiaoDich findById(String id) {
        return giaoDichRepository.findById(id).orElse(null);
    }

    @Override
    public List<GiaoDich> findByName(String name) {
        return giaoDichRepository.findByKhachHang_TenKhachHangContaining(name);
    }

    public List<GiaoDich> search(String tenkhachHang,String loaiDichVu) {
        if ((loaiDichVu == null || loaiDichVu.isEmpty()) && (tenkhachHang == null || tenkhachHang.isEmpty())) {
            return giaoDichRepository.findAll();
        }else if ((loaiDichVu != null || !loaiDichVu.isEmpty()) && (tenkhachHang == null || tenkhachHang.isEmpty()))  {
            return giaoDichRepository.findByLoaiDichVu_TenLoaiDichVuContaining(loaiDichVu);
        }else if ((loaiDichVu == null || loaiDichVu.isEmpty()) && (tenkhachHang != null || !tenkhachHang.isEmpty())) {
            return giaoDichRepository.findByKhachHang_TenKhachHangContaining(tenkhachHang);
        }else {
            return giaoDichRepository.findByKhachHang_TenKhachHangAndLoaiDichVu_TenLoaiDichVuContaining(tenkhachHang,loaiDichVu);
        }
    }
}
