package iuh.fit.giuaKy_xe.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "loaixe")
public class Loaixe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_loai", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "ten_loai", length = 50)
    private String tenLoai;

    public Loaixe(Integer id) {
        this.id = id;
    }
}