package hosi.procure2pay.entity;

import hosi.procure2pay.model.enums.RequisitionState;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@Entity
public class RequisitionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @Column(name="supplier")
//    private Supplier supplier;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private UserEntity createdBy;

    @Column(name="created_on")
    private LocalDateTime createdOn;

    @Column(name="state")
    @Enumerated(EnumType.STRING)
    private RequisitionState state;

    @Column(name="total_cost")
    private Float totalCost;
}
