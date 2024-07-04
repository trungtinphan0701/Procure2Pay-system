package hosi.procure2pay.entity;

import hosi.procure2pay.model.enums.RequisitionState;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "requisitions")
public class RequisitionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="supplier_id")
    private SupplierEntity supplier;

    @ManyToOne
    @JoinColumn(name="created_by")
    private UserEntity createdBy;

    @Column(name="created_on")
    private LocalDateTime createdOn;

    @Column(name="state")
    @Enumerated(EnumType.STRING)
    private RequisitionState state;

    @Column(name="total_cost")
    private Float totalCost;

    @OneToMany(mappedBy = "requisition")
    private List<RequisitionItemEntity> items;
}
