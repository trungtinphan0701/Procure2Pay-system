package hosi.procure2pay.entity;

import hosi.procure2pay.model.enums.RequisitionState;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "requisitions")
@RequiredArgsConstructor
public class RequisitionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="created_by")
    private UserEntity createdByUser;

    @ManyToOne
    @JoinColumn(name="supplier_id")
    private SupplierEntity supplierEntity;

    @Column(name="created_on")
    private LocalDateTime createdOn;

    @Column(name="state")
    @Enumerated(EnumType.STRING)
    private RequisitionState state;

    @Column(name="total_cost")
    private Float totalCost;
}

// many requisitions can be owned by 1 user - many to one with userentity