package hosi.procure2pay.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "requisition_items")
@RequiredArgsConstructor
public class RequisitionItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer quantity;

    @Column(name="total_cost")
    private Float totalCost;

    @ManyToOne
    @JoinColumn(name="requisition_id")
    private RequisitionEntity requisition;

    @OneToOne
    @JoinColumn(name="supplier_item_id")
    private SupplierItemEntity supplierItem;
}
