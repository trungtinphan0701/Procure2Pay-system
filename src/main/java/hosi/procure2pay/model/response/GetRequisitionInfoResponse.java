package hosi.procure2pay.model.response;

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
