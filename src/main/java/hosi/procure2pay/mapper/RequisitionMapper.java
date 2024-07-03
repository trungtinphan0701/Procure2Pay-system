package hosi.procure2pay.mapper;

import hosi.procure2pay.entity.RequisitionEntity;
import hosi.procure2pay.model.response.CreateRequisitionResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RequisitionMapper {
    public CreateRequisitionResponse toRequisitionResponse (RequisitionEntity requisitionEntity) {
        CreateRequisitionResponse createRequisitionResponse = new CreateRequisitionResponse();
        createRequisitionResponse.setRequisitionId(requisitionEntity.getId());
        createRequisitionResponse.setCreatedOn(requisitionEntity.getCreatedOn());
        createRequisitionResponse.setTotalCost(requisitionEntity.getTotalCost());
        createRequisitionResponse.setUserFirstName(requisitionEntity.getCreatedByUser().getFirstName());
        createRequisitionResponse.setUserLastName(requisitionEntity.getCreatedByUser().getLastName());
        createRequisitionResponse.setSupplierName(requisitionEntity.getSupplierEntity().getName());
        return createRequisitionResponse;
    }
}
