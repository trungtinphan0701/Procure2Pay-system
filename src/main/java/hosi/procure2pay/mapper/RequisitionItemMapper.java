package hosi.procure2pay.mapper;

import hosi.procure2pay.entity.RequisitionItemEntity;
import hosi.procure2pay.model.response.CreateRequisitionItemResponse;
import hosi.procure2pay.model.response.UpdateRequisitionItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RequisitionItemMapper {
    public CreateRequisitionItemResponse toRequisitionItemResponse (RequisitionItemEntity requisitionItemEntity) {
        CreateRequisitionItemResponse createRequisitionItemResponse = new CreateRequisitionItemResponse();
        createRequisitionItemResponse.setRequisitionItemId(requisitionItemEntity.getId());
        createRequisitionItemResponse.setRequisitionId(requisitionItemEntity.getRequisition().getId());
        createRequisitionItemResponse.setSupplierName(requisitionItemEntity.getSupplierItem().getSupplier().getName());
        createRequisitionItemResponse.setQuantity(requisitionItemEntity.getQuantity());
        createRequisitionItemResponse.setUnitCost(requisitionItemEntity.getSupplierItem().getUnitCost());
        createRequisitionItemResponse.setTotalCost(requisitionItemEntity.getTotalCost());
        return createRequisitionItemResponse;
    }

    public List<CreateRequisitionItemResponse> toRequisitionItemResponses (List<RequisitionItemEntity> requisitionItemEntityList) {
        List<CreateRequisitionItemResponse> createRequisitionItemResponses = new ArrayList<>();
        for (RequisitionItemEntity requisitionItemEntity : requisitionItemEntityList) {
            createRequisitionItemResponses.add(toRequisitionItemResponse(requisitionItemEntity));
        }
        return createRequisitionItemResponses;
    }

    public UpdateRequisitionItemResponse toUpdateRequisitionItemResponse (RequisitionItemEntity requisitionItemEntity) {
        UpdateRequisitionItemResponse updateRequisitionItemResponse = new UpdateRequisitionItemResponse();
        updateRequisitionItemResponse.setSupplierItemId(
                requisitionItemEntity.getSupplierItem().getId()
        );
        updateRequisitionItemResponse.setQuantity(requisitionItemEntity.getQuantity());
        updateRequisitionItemResponse.setRequisitionId(requisitionItemEntity.getRequisition().getId());
        updateRequisitionItemResponse.setTotalCost(requisitionItemEntity.getTotalCost());
        return updateRequisitionItemResponse;
    }
}
