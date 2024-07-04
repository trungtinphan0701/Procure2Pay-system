package hosi.procure2pay.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "suppliers")
public class SupplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy="supplier")
    private List<RequisitionEntity> requisitions;

    @OneToMany(mappedBy = "supplier")
    private List<SupplierItemEntity> items;
}