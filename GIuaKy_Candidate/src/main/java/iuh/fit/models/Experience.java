package iuh.fit.models;

import iuh.fit.enums.Roles;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "experience")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exp_id", nullable = false)
    private Long id;

    @Size(max = 120)
    @Column(name = "company", length = 120)
    private String company;

    @NotNull
    @Column(name = "from_date", nullable = false)
    private LocalDate fromDate;

    @NotNull
    @Column(name = "role", nullable = false)
    private Roles role;

    @NotNull
    @Column(name = "to_date", nullable = false)
    private LocalDate toDate;

    @Size(max = 400)
    @NotNull
    @Column(name = "work_desc", nullable = false, length = 400)
    private String workDesc;

    @ManyToOne
    @JoinColumn(name = "can_id", nullable = false)
    private Candidate candidate;

    public Experience(String company, LocalDate fromDate, Roles role, LocalDate toDate, String workDesc, Candidate candidate) {
        this.company = company;
        this.fromDate = fromDate;
        this.role = role;
        this.toDate = toDate;
        this.workDesc = workDesc;
        this.candidate = candidate;
    }
}