package hosi.procure2pay.repository;

import hosi.procure2pay.entity.RequisitionItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequisitionItemRepository extends JpaRepository<RequisitionItemEntity, Integer> {
}
