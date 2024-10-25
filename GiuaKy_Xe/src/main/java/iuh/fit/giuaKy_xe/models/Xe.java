package iuh.fit.giuaKy_xe.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "xe")
public class Xe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_xe", nullable = false)
    private Integer id;

    @Size(max = 225)
    @Column(name = "ten_xe", length = 225)
    private String tenXe;

    @Column(name = "gia")
    private Double gia;

    @Column(name = "nam_sx")
    private Integer namSx;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ma_loai")
    private Loaixe maLoai;

    public Xe(String tenXe, Double gia, Integer namSx, Loaixe maLoai) {
        this.tenXe = tenXe;
        this.gia = gia;
        this.namSx = namSx;
        this.maLoai = maLoai;
    }
}