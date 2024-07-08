package hosi.procure2pay.repository;

import hosi.procure2pay.entity.RequisitionEntity;
import hosi.procure2pay.entity.RequisitionItemEntity;
import hosi.procure2pay.entity.SupplierItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RequisitionItemRepository extends JpaRepository<RequisitionItemEntity, Integer> {
    Optional<RequisitionItemEntity> findByRequisitionAndSupplierItem (RequisitionEntity requisition, SupplierItemEntity supplierItem);
    void deleteById(Integer id);
}
