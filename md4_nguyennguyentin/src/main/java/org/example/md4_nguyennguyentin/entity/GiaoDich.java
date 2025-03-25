    package org.example.md4_nguyennguyentin.entity;
    import jakarta.persistence.*;
    import lombok.*;
    import org.springframework.format.annotation.DateTimeFormat;

    import java.util.Date;

    @Entity
    @Table(name = "giao_dich")
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class GiaoDich {
        @Id
        @Column(name = "ma_giao_dich", unique = true, nullable = false)
        private String maGiaoDich;

        @ManyToOne
        @JoinColumn(name = "ma_khach_hang", nullable = false)
        private KhachHang khachHang;

        @Temporal(TemporalType.DATE)
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        @Column(nullable = false)
        private Date ngayGiaoDich;

        @ManyToOne
        @JoinColumn(name = "ma_loai_dich_vu", nullable = false)
        private LoaiDichVu loaiDichVu;

        @Column(nullable = false)
        private Double donGia;

        @Column(nullable = false)
        private Double dienTich;
    }

