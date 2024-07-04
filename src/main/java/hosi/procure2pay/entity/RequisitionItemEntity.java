package hosi.procure2pay.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "requisition_items")
public class RequisitionItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "requisition_id")
    private RequisitionEntity requisition;

    @OneToOne
    @JoinColumn(name = "supplier_item_id")
    private SupplierItemEntity supplierItem;

    private Integer quantity;

    @Column(name = "total_item_cost")
    private Float totalItemCost;
}
