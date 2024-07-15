package hosi.procure2pay.mapper;

import hosi.procure2pay.entity.RequisitionEntity;
import hosi.procure2pay.model.response.Requisition.CreateRequisitionResponse;
import hosi.procure2pay.model.response.Requisition.GetRequisitionInfoResponse;
import hosi.procure2pay.model.response.User.UserInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
@RequiredArgsConstructor
// function to change type to ideal result
public class RequisitionMapper {
    private final UserMapper userMapper;
    private final RequisitionItemMapper requisitionItemMapper;

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

    public GetRequisitionInfoResponse toRequisitionInfoResponse (RequisitionEntity requisitionEntity) {
        UserInfoResponse userInfoResponse = userMapper.toUserInfoResponse(requisitionEntity.getCreatedByUser());

        GetRequisitionInfoResponse getRequisitionInfoResponse = new GetRequisitionInfoResponse();
        getRequisitionInfoResponse.setCreatedBy(userInfoResponse);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        getRequisitionInfoResponse.setCreatedOn(requisitionEntity.getCreatedOn().format(formatter));
        getRequisitionInfoResponse.setState(requisitionEntity.getState().getStateName());
        getRequisitionInfoResponse.setItems(requisitionItemMapper.toRequisitionItemResponses(requisitionEntity.getRequisitionItemEntityList()));
        return getRequisitionInfoResponse;
    }
}
