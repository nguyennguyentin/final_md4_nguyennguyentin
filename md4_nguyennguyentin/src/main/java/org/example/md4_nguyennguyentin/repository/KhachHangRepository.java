package org.example.md4_nguyennguyentin.repository;

import org.example.md4_nguyennguyentin.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KhachHangRepository extends JpaRepository<KhachHang, Long> {
}
