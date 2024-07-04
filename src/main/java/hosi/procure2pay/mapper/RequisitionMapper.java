package hosi.procure2pay.mapper;

import hosi.procure2pay.entity.RequisitionEntity;
import hosi.procure2pay.entity.UserEntity;
import hosi.procure2pay.model.response.RequisitionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RequisitionMapper {
    public RequisitionResponse toResponse(RequisitionEntity requisitionEntity) {
        RequisitionResponse response = new RequisitionResponse();
        response.setRequisitionId(requisitionEntity.getId());
        response.setCreatedByUserId(requisitionEntity.getCreatedBy().getId());
        response.setCreatedOn(requisitionEntity.getCreatedOn());
        response.setState(requisitionEntity.getState().name());
        response.setTotalCost(requisitionEntity.getTotalCost());

        return response;
    }
}
