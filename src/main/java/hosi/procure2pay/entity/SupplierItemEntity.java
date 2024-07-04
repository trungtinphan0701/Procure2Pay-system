package hosi.procure2pay.entity;

import hosi.procure2pay.model.enums.ItemAvailability;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@Table(name="supplier_items")
public class SupplierItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private SupplierEntity supplier;

    private String name;

    private String description;

    @Column(name = "unit_cost", nullable = false)
    private Float unitCost;

    @Enumerated(EnumType.STRING)
    private ItemAvailability availability;

    @OneToOne(mappedBy = "supplierItem")
    private RequisitionItemEntity requisitionItem;
}
