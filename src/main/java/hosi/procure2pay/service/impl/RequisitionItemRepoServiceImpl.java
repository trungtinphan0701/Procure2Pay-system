package hosi.procure2pay.service.impl;

import hosi.procure2pay.entity.RequisitionEntity;
import hosi.procure2pay.entity.RequisitionItemEntity;
import hosi.procure2pay.entity.SupplierItemEntity;
import hosi.procure2pay.exception.BadRequestError;
import hosi.procure2pay.exception.ResponseException;
import hosi.procure2pay.repository.RequisitionItemRepository;
import hosi.procure2pay.repository.RequisitionRepository;
import hosi.procure2pay.repository.SupplierItemRepository;
import hosi.procure2pay.service.repo.RequisitionItemRepoService;
import hosi.procure2pay.service.repo.RequisitionRepoService;
import hosi.procure2pay.service.repo.SupplierItemRepoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RequisitionItemRepoServiceImpl implements RequisitionItemRepoService {
    private final RequisitionItemRepository requisitionItemRepository;
    private final RequisitionRepoService requisitionRepoService;
    private final SupplierItemRepoService supplierItemRepoService;

    @Override
    public RequisitionItemEntity save(RequisitionItemEntity requisitionItemEntity) {
        return requisitionItemRepository.save(requisitionItemEntity);
    }

    @Override
    public RequisitionItemEntity findByRequisitionIdAndSupplierItemId(Integer requisitionId, Integer supplierItemId) {
        if (requisitionId == null) {
            throw new ResponseException(BadRequestError.REQUISITION_ID_NULL);
        }
        if (supplierItemId == null) {
            throw new ResponseException(BadRequestError.SUPPLIER_ITEM_ID_NULL);
        }
        RequisitionEntity requisition = requisitionRepoService.findById(requisitionId);
        SupplierItemEntity supplierItem = supplierItemRepoService.findById(supplierItemId);

        Optional<RequisitionItemEntity> requisitionItemEntityOptional = requisitionItemRepository.findByRequisitionAndSupplierItem(requisition, supplierItem);
        if (requisitionItemEntityOptional.isPresent()) {
            return requisitionItemEntityOptional.get();
        } else {
            throw new ResponseException(BadRequestError.ITEM_NOT_FOUND_IN_THIS_REQUISITION_SUPPLIER);
        }
    }

    @Override
    public RequisitionItemEntity findById(Integer id) {
        if (id == null) {
            throw new ResponseException(BadRequestError.REQUISITION_ITEM_ID_IS_NULL);
        }
        Optional<RequisitionItemEntity> requisitionItemEntityOptional = requisitionItemRepository.findById(id);
        if (requisitionItemEntityOptional.isPresent()) {
            return requisitionItemEntityOptional.get();
        } else throw new ResponseException(BadRequestError.ITEM_NOT_FOUND_IN_THIS_REQUISITION_SUPPLIER);
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            throw new ResponseException(BadRequestError.REQUISITION_ITEM_ID_IS_NULL);
        }
        requisitionItemRepository.deleteById(id);
    }
}
