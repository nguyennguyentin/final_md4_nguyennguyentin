package org.example.md4_nguyennguyentin.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoaiDichVu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maLoaiDichVu;
    @Column(nullable = false)
    private String tenLoaiDichVu;
}
