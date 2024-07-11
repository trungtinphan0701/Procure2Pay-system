package hosi.procure2pay.entity;

import hosi.procure2pay.model.enums.SupplierItemState;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@Entity
@Table(name="supplier_items")
@RequiredArgsConstructor
public class SupplierItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    @Column(name="unit_cost")
    private Float unitCost;

    private String type;

    @Column(name="availability")
    @Enumerated(EnumType.STRING)
    private SupplierItemState state;

    @ManyToOne
    @JoinColumn(name="supplier")
    private SupplierEntity supplier;

    @OneToOne(mappedBy = "supplierItem")
    private RequisitionItemEntity requisitionItem;

}
