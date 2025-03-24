package org.example.md4_nguyennguyentin.repository;


import org.example.md4_nguyennguyentin.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Long> {
}
