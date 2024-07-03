package hosi.procure2pay.service.impl;

import hosi.procure2pay.entity.RequisitionEntity;
import hosi.procure2pay.entity.UserEntity;
import hosi.procure2pay.mapper.RequisitionMapper;
import hosi.procure2pay.model.enums.RequisitionState;
import hosi.procure2pay.model.request.CreateRequisitionRequest;
import hosi.procure2pay.model.response.CreateRequisitionResponse;
import hosi.procure2pay.service.RequisitionRepoService;
import hosi.procure2pay.service.RequisitionService;
import hosi.procure2pay.service.UserRepoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RequisitionServiceImpl implements RequisitionService {
    private RequisitionRepoService requisitionRepoService;
    private UserRepoService userRepoService;
    private RequisitionMapper requisitionMapper;

    @Override
    public CreateRequisitionResponse createRequisition(CreateRequisitionRequest requisitionRequest) {
        // Find user entity by id:
        UserEntity userEntity = userRepoService.findById(requisitionRequest.getUserId());

        // Map user entity to requisition entity:
        RequisitionEntity requisitionEntity = requisitionMapper.fromUserToRequisition(userEntity);
        // Default values:
        requisitionEntity.setCreatedOn(LocalDateTime.now());
        requisitionEntity.setTotalCost(0.0f);
        requisitionEntity.setState(RequisitionState.AWAITING_APPROVAL);

        // Create requisition entity:
        RequisitionEntity createdRequisitionEntity = requisitionRepoService.save(requisitionEntity);

        CreateRequisitionResponse response = requisitionMapper.toResponse(createdRequisitionEntity);

        return response;
    }
}
