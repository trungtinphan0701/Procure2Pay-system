package hosi.procure2pay.repository;

import hosi.procure2pay.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<SupplierEntity, Integer> {
}
