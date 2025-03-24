package org.example.md4_nguyennguyentin.service;


import org.example.md4_nguyennguyentin.entity.GiaoDich;
import org.example.md4_nguyennguyentin.repository.GiaoDichRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GiaoDichService {



    public GiaoDichService(GiaoDichRepository repository) {
        this.repository = repository;
    }

    public List<GiaoDich> getAll() {
        return repository.findAll();
    }

    public GiaoDich save(GiaoDich giaoDich) {
        return repository.save(giaoDich);
    }

    public void delete(String id) {
    }

    public List<GiaoDich> search(String ten, String loai) {
        return repository.findByKhachHang_TenKhachHangContainingAndLoaiDichVuContaining(ten, loai);
    }

}
