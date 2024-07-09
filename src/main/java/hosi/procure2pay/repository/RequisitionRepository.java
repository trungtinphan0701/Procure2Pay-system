package hosi.procure2pay.repository;

import hosi.procure2pay.entity.RequisitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequisitionRepository extends JpaRepository<RequisitionEntity, Integer> {
}
