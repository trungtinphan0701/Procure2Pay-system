package hosi.procure2pay.mapper;

import hosi.procure2pay.entity.RequisitionEntity;
import hosi.procure2pay.entity.UserEntity;
import hosi.procure2pay.model.request.CreateRequisitionRequest;
import hosi.procure2pay.model.response.CreateRequisitionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class RequisitionMapper {

    public RequisitionEntity fromUserToRequisition(UserEntity userEntity) {
        RequisitionEntity requisitionEntity = new RequisitionEntity();
        requisitionEntity.setCreatedBy(userEntity);

        return requisitionEntity;
    }

    public CreateRequisitionResponse toResponse(RequisitionEntity requisitionEntity) {
        CreateRequisitionResponse response = new CreateRequisitionResponse();
        response.setRequisitionId(requisitionEntity.getId());
        response.setCreatedByUserId(requisitionEntity.getCreatedBy().getId());
        response.setCreatedOn(requisitionEntity.getCreatedOn());
        response.setState(requisitionEntity.getState().name());
        response.setTotalCost(requisitionEntity.getTotalCost());

        return response;
    }
}
