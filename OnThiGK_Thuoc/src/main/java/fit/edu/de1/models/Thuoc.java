package fit.edu.de1.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "thuoc")
public class Thuoc {
    @Id
    @Size(max = 255)
    @Column(name = "ma_thuoc", nullable = false)
    private String maThuoc;

    @Column(name = "GIA")
    private Double gia;

    @Column(name = "nam_sx")
    private Integer namSx;

    @Size(max = 255)
    @Column(name = "ten_thuoc")
    private String tenThuoc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_loai")
    private LoaiThuoc maLoai;

}