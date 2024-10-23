package fit.edu.de1.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name = "loai_thuoc")
public class LoaiThuoc {
    @Id
    @Size(max = 255)
    @Column(name = "ma_loai", nullable = false)
    private String maLoai;

    @Size(max = 255)
    @Column(name = "ten_loai")
    private String tenLoai;

    public LoaiThuoc(String maLoai) {
        this.maLoai = maLoai;
    }
}