package hosi.procure2pay.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
public class Requisition {
    @Id
    private int id;
    private int supplierId;
}
