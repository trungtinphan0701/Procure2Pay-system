package hosi.procure2pay.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "suppliers")
@RequiredArgsConstructor
public class SupplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String address;
    private String phoneNumber;

    @OneToMany(mappedBy="supplierEntity")
    private List<RequisitionEntity> requisitions;
}
