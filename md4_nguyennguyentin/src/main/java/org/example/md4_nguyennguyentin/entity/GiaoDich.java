package org.example.md4_nguyennguyentin.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "giao_dich")
public class GiaoDich {
    @Id
    private String maGiaoDich;

    @ManyToOne
    @JoinColumn(name = "khach_hang_id", nullable = false)
    private KhachHang khachHang;

    private String loaiDichVu;
    private Date ngayGiaoDich;
    private double donGia;
    private double dienTich;
}
