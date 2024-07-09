package hosi.procure2pay.repository;

import hosi.procure2pay.entity.SupplierItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierItemRepository extends JpaRepository<SupplierItemEntity, Integer> {
}
