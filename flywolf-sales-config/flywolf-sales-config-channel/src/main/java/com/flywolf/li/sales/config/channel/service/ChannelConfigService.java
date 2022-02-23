package com.flywolf.li.sales.config.channel.service;


import com.ebao.li.framework.web.ServiceHeader;
import com.ebao.li.mobs.agency.dto.ClaimContext;
import com.ebao.li.mobs.agency.dto.RegisterRequest;
import com.ebao.li.mobs.agency.dto.RegisterResponse;
import com.ebao.li.mobs.agency.dto.UploadCaseDocumentsResponse;

public interface ChannelConfigService {
    
    com.ebao.li.mobs.agency.dto.RegisterResponse register(ClaimContext<RegisterRequest, RegisterResponse> context);

    com.ebao.li.mobs.agency.dto.ClaimCaseResponse getClaimCase(ServiceHeader parseHeader, String insurerCode,
                                                               Long caseId);

    com.ebao.li.mobs.agency.dto.ClaimSearchResponse search(ServiceHeader parseHeader, String insurerCode,
                                                           com.ebao.li.mobs.agency.dto.ClaimSearchRequest request);

    com.ebao.li.mobs.agency.dto.BankAccountUpdateResponse bankAccountUpdate(ServiceHeader parseHeader, String insurerCode,
                                                                            com.ebao.li.mobs.agency.dto.BankAccountUpdateRequest request);

    com.ebao.li.mobs.agency.dto.AcceptancePolicyResponse getAcceptancePolicies(ServiceHeader parseHeader,
                                                                               String insurerCode, String caseNo);

    com.ebao.li.mobs.agency.dto.ClaimPolicyResponse getPolicyInfoOnEventDate(ServiceHeader parseHeader, String insurerCode,
                                                                             com.ebao.li.mobs.agency.dto.ClaimPolicyRequest request);

    com.ebao.li.mobs.agency.dto.ClaimPolicyAdditionPremResponse reverseAdditionPrems(ServiceHeader parseHeader,
                                                                                     String insurerCode, com.ebao.li.mobs.agency.dto.ClaimPolicyRequest request);

    com.ebao.li.mobs.agency.dto.ReassignCaseTaskResponse reassignCaseTask(ServiceHeader parseHeader, String insurerCode,
                                                                          com.ebao.li.mobs.agency.dto.ReassignCaseTaskRequest request);

    com.ebao.li.mobs.agency.dto.ClaimCandidateUsersResponse queryCandidateUsers(ServiceHeader parseHeader,
                                                                                String insurerCode, com.ebao.li.mobs.agency.dto.CandidateUsersQueryRequest request);

    com.ebao.li.mobs.agency.dto.ClaimCaseCommonResponse updateCase(ServiceHeader parseHeader, String insurerCode,
                                                                   com.ebao.li.mobs.agency.dto.UpdateCaseRequest request);

    com.ebao.li.mobs.agency.dto.ClaimLiabilityEvaluationResponse evaluate(ServiceHeader parseHeader, String insurerCode,
                                                                          com.ebao.li.mobs.agency.dto.ClaimLiabilityEvaluationRequest request);

    com.ebao.li.mobs.agency.dto.ClaimCoverageEvaluationResponse evaluateCoverage(ServiceHeader parseHeader,
                                                                                 String insurerCode, com.ebao.li.mobs.agency.dto.ClaimCoverageEvaluationRequest request);

    com.ebao.li.mobs.agency.dto.DisbursementAmountResponse getDisbursementAmounts(ServiceHeader parseHeader,
                                                                                  String insurerCode, String caseNo);

    com.ebao.li.mobs.agency.dto.DisbursementPlanInfo getDisbursementPlans(ServiceHeader parseHeader, String insurerCode,
                                                                          String caseNo);

    com.ebao.li.mobs.agency.dto.DisbursementPlanResponse disbursementPlan(ServiceHeader parseHeader, String insurerCode,
                                                                          com.ebao.li.mobs.agency.dto.DisbursementPlanRequest request);

    com.ebao.li.mobs.agency.dto.ClaimCaseEvaluationResponse evaluate(ServiceHeader parseHeader, String insurerCode,
                                                                     com.ebao.li.mobs.agency.dto.ClaimCaseEvaluationRequest request);

    com.ebao.li.mobs.agency.dto.ClaimTaskQueryResponse queryClaimTasks(ServiceHeader parseHeader, String insurerCode,
                                                                       com.ebao.li.mobs.agency.dto.ClaimTaskQueryRequest request);

    com.ebao.li.mobs.agency.dto.ClaimCaseApprovalResponse approve(ServiceHeader parseHeader, String insurerCode,
                                                                  com.ebao.li.mobs.agency.dto.ClaimCaseApprovalRequest request);

    com.ebao.li.mobs.agency.dto.AppendCaseCommentsResponse appendCaseComments(ServiceHeader parseHeader,
                                                                              String insurerCode, com.ebao.li.mobs.agency.dto.AppendCaseCommentsRequest request);

    com.ebao.li.mobs.agency.dto.ClaimCaseCancelResponse cancel(ServiceHeader parseHeader, String insurerCode,
                                                               com.ebao.li.mobs.agency.dto.ClaimCaseCancelRequest request);

    com.ebao.li.mobs.agency.dto.ClaimAcceptResponse accept(ServiceHeader parseHeader, String insurerCode,
                                                           com.ebao.li.mobs.agency.dto.ClaimAcceptRequest request);

    com.ebao.li.mobs.agency.dto.PolicyRenewalExtractionResponse osPremiums(ServiceHeader parseHeader, String insurerCode,
                                                                           com.ebao.li.mobs.agency.dto.ClaimPolicyOsPremiumsRequest request);

    UploadCaseDocumentsResponse uploadCaseDocuments(ServiceHeader parseHeader,
                                                    String insurerCode, com.ebao.li.mobs.agency.dto.UploadCaseDocumentsRequest request);

    com.ebao.li.mobs.agency.dto.ClaimCheckListResponse saveCheckList(ServiceHeader parseHeader, String insurerCode,
                                                                     com.ebao.li.mobs.agency.dto.ClaimCheckListRequest request);

    com.ebao.li.mobs.agency.dto.ClaimCheckListResponse loadCheckList(ServiceHeader parseHeader, String insurerCode,
                                                                     Long caseId);

    com.ebao.li.mobs.agency.dto.ClaimCheckListResponse initCheckList(ServiceHeader parseHeader, String insurerCode,
                                                                     Long caseId, Long claimType);

    com.ebao.li.mobs.agency.dto.InsuredQueryResponse searchClaimInsureds(ServiceHeader serviceHeader, String insurerCode, com.ebao.li.mobs.agency.dto.InsuredQueryRequest request);
}
