package hosi.procure2pay.model.response.Requisition;

import hosi.procure2pay.model.response.RequisitionItem.CreateRequisitionItemResponse;
import hosi.procure2pay.model.response.User.UserInfoResponse;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class GetRequisitionInfoResponse {
    private UserInfoResponse createdBy;
    private String createdOn;
    private String state;
    private List<CreateRequisitionItemResponse> items;

}
