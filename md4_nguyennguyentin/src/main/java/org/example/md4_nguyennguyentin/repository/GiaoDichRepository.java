package org.example.md4_nguyennguyentin.repository;

import org.example.md4_nguyennguyentin.entity.GiaoDich;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GiaoDichRepository extends JpaRepository<GiaoDich, String> {
    List<GiaoDich> findByKhachHang_TenKhachHangContaining(String name);
    List<GiaoDich> findByKhachHang_TenKhachHangAndLoaiDichVu_TenLoaiDichVuContaining(String name,String loaiDichVu);
    List<GiaoDich> findByLoaiDichVu_TenLoaiDichVuContaining(String name);


}
