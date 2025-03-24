package org.example.md4_nguyennguyentin.repository;

import org.example.md4_nguyennguyentin.entity.GiaoDich;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GiaoDichRepository extends JpaRepository<GiaoDich, Long> {

    List<GiaoDich> findByKhachHang_TenKhachHangContainingAndLoaiDichVuContaining(String ten, String loai);
}
