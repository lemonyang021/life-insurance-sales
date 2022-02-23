package com.flywolf.li.sales.config.channel.service;

import com.ebao.li.framework.dto.GenericLiResponse;
import com.ebao.li.framework.dto.LiResult;
import com.ebao.li.framework.user.AppUserContext;
import com.ebao.li.framework.web.ServiceHeader;
import com.ebao.li.framework.web.ServiceInterceptor;
import com.ebao.li.jdbc.ClaimBsId;
import com.ebao.li.mobs.agency.dto.ClaimContext;
import com.ebao.li.mobs.agency.dto.RegisterRequest;
import com.ebao.li.mobs.agency.dto.RegisterResponse;
import com.ebao.li.mobs.agency.dto.UploadCaseDocumentsResponse;
import com.ebao.li.mobs.agency.dto.view.input.CheckListItemInput;
import com.ebao.li.mobs.agency.dto.view.output.CheckListItemInfo;
import com.ebao.li.mobs.agency.dto.view.output.ClaimCaseDetailInfo;
import com.ebao.li.mobs.agency.dto.view.output.ClaimInsuredInfo;
import com.ebao.li.mobs.agency.dto.view.output.ClaimantInfo;
import com.ebao.li.mobs.agency.helper.RegisterConvertHelper;
import com.ebao.li.mobs.util.ConvertUtil;
import com.ebao.ls.foundation.service.GenericValidationResult;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChannelConfigServiceImpl implements ChannelConfigService {
    @Autowired
    private ApplicationEventPublisher publisher;
    @Autowired
    private ServiceInterceptor serviceInterceptor;
    @Autowired
    private AppUserContext appUserContext;

    @Autowired
    ClaimBsId claimBsId;

    @Resource
    com.ebao.li.mobs.agency.jpa.repository.ClaimChecklistRepository claimChecklistRepository;
    @Resource
    com.ebao.li.mobs.agency.jpa.repository.ClaimTypeChecklistRepository claimTypeChecklistRepository;
    @Resource
    ClaimCaseRepository claimCaseRepository;
    @Resource
    com.ebao.li.mobs.agency.jpa.repository.ClaimInsuredRepository claimInsuredRepository;
    @Resource
    com.ebao.li.mobs.agency.jpa.repository.ClaimReporterRepository claimReporterRepository;


    /************convert start*****************/
    private RegisterConvertHelper registerConvertHelper;

    /************convert end*****************/

    private void setGenericResult(GenericLiResponse response, LiResult result) {
        if (result.getMessages() != null && result.getMessages().length > 0) {
            for (GenericValidationResult message : result.getMessages()) {
                response.addMessage(message.getCode(), message.getMessage());
            }
        }

        if (result.getExceptions() != null && result.getExceptions().length > 0) {
            for (String exception : result.getExceptions()) {
                response.addException(exception);
            }
        }
        response.setResult(result.getResult());
        response.setServiceResTime(appUserContext.getCurrentUserLocalTime());
    }


    @Override
    @Transactional
    public com.ebao.li.mobs.agency.dto.RegisterResponse register(ClaimContext<RegisterRequest, RegisterResponse> context) {
        com.ebao.li.mobs.agency.dto.RegisterRequest request = context.getRequest();

        // 保存claim_case
        com.ebao.li.mobs.agency.jpa.bo.ClaimCase claimCase = ConvertUtil.convert(request, com.ebao.li.mobs.agency.jpa.bo.ClaimCase.class);
        ConvertUtil.initInsertEntity(claimCase);
        claimCase.setCaseId(claimBsId.id());
        claimCase.setCaseNo(String.format("%0" + 12 + "d", claimCase.getCaseId()));
        claimCaseRepository.save(claimCase);

        // 保存claim_insured
        com.ebao.li.mobs.agency.jpa.bo.ClaimInsured claimInsured = ConvertUtil.convert(request.getInsured(), com.ebao.li.mobs.agency.jpa.bo.ClaimInsured.class);
        ConvertUtil.initInsertEntity(claimInsured);
        claimInsured.setId(claimBsId.id());
        claimInsured.setCaseId(claimCase.getCaseId());
        claimInsuredRepository.save(claimInsured);

        // 保存claim_reporter
        com.ebao.li.mobs.agency.jpa.bo.ClaimReporter claimReporter = ConvertUtil.convert(request.getClaimant(), com.ebao.li.mobs.agency.jpa.bo.ClaimReporter.class);
        ConvertUtil.initInsertEntity(claimReporter);
        claimReporter.setId(claimBsId.id());
        claimReporter.setCaseId(claimCase.getCaseId());
        claimReporterRepository.save(claimReporter);

        // 初始化checklist
        initCheckList(null, null, claimCase.getCaseId(), claimCase.getClaimType());

        com.ebao.li.mobs.agency.dto.RegisterResponse response = new com.ebao.li.mobs.agency.dto.RegisterResponse();
        response.setClaimCaseId(claimCase.getCaseId());
        response.setClaimCaseNo(claimCase.getCaseNo());
        response.setClaimCaseStatus(claimCase.getCaseStatus());
        return response;
    }


    @Override
    public com.ebao.li.mobs.agency.dto.ClaimCaseResponse getClaimCase(ServiceHeader parseHeader, String insurerCode, Long caseId) {
        com.ebao.li.mobs.agency.jpa.bo.ClaimCase claimCase = claimCaseRepository.getOne(caseId);
        com.ebao.li.mobs.agency.jpa.bo.ClaimInsured claimInsured = claimInsuredRepository.findFirstByCaseId(caseId);
        com.ebao.li.mobs.agency.jpa.bo.ClaimReporter claimReporter = claimReporterRepository.findFirstByCaseId(caseId);

        com.ebao.li.mobs.agency.dto.ClaimCaseResponse response = new com.ebao.li.mobs.agency.dto.ClaimCaseResponse();
        response.setClaimCase(ConvertUtil.convert(claimCase, ClaimCaseDetailInfo.class));
        response.setInsured(ConvertUtil.convert(claimInsured, ClaimInsuredInfo.class));
        response.setClaimant(ConvertUtil.convert(claimReporter, ClaimantInfo.class));
        return response;
    }


    @Override
    public com.ebao.li.mobs.agency.dto.ClaimSearchResponse search(ServiceHeader parseHeader, String insurerCode,
                                                                  com.ebao.li.mobs.agency.dto.ClaimSearchRequest request) {
        ClaimCaseEventObject<com.ebao.li.mobs.agency.dto.ClaimSearchRequest, com.ebao.li.mobs.agency.dto.ClaimSearchResponse> claimCaseEventOject =
                new ClaimCaseEventObject<com.ebao.li.mobs.agency.dto.ClaimSearchRequest, com.ebao.li.mobs.agency.dto.ClaimSearchResponse>();
        claimCaseEventOject.setInsurerCode(insurerCode);
        claimCaseEventOject.setTenantCode(parseHeader.getXtenantId());
        claimCaseEventOject.setRequest(request);
        ClaimSearching event = new ClaimSearching(claimCaseEventOject);
        publisher.publishEvent(event);
        return claimCaseEventOject.getResponse();
    }

    @Override
    public com.ebao.li.mobs.agency.dto.BankAccountUpdateResponse bankAccountUpdate(ServiceHeader parseHeader, String insurerCode,
                                                                                   com.ebao.li.mobs.agency.dto.BankAccountUpdateRequest request) {
        ClaimCaseEventObject<com.ebao.li.mobs.agency.dto.BankAccountUpdateRequest, com.ebao.li.mobs.agency.dto.BankAccountUpdateResponse> claimCaseEventOject =
                new ClaimCaseEventObject<com.ebao.li.mobs.agency.dto.BankAccountUpdateRequest, com.ebao.li.mobs.agency.dto.BankAccountUpdateResponse>();
        claimCaseEventOject.setInsurerCode(insurerCode);
        claimCaseEventOject.setTenantCode(parseHeader.getXtenantId());
        claimCaseEventOject.setRequest(request);
        BankAccountUpdateEvent event = new BankAccountUpdateEvent(claimCaseEventOject);
        publisher.publishEvent(event);
        return claimCaseEventOject.getResponse();
    }

    @Override
    public com.ebao.li.mobs.agency.dto.AcceptancePolicyResponse getAcceptancePolicies(ServiceHeader parseHeader,
                                                                                      String insurerCode, String caseNo) {
        ClaimCaseEventObject<String, com.ebao.li.mobs.agency.dto.AcceptancePolicyResponse> claimCaseEventOject =
                new ClaimCaseEventObject<String, com.ebao.li.mobs.agency.dto.AcceptancePolicyResponse>();
        claimCaseEventOject.setClaimCaseNo(caseNo);
        claimCaseEventOject.setInsurerCode(insurerCode);
        claimCaseEventOject.setTenantCode(parseHeader.getXtenantId());
        ClaimCaseAcceptancePoliciesGettingEvent event =
                new ClaimCaseAcceptancePoliciesGettingEvent(claimCaseEventOject);
        publisher.publishEvent(event);
        return claimCaseEventOject.getResponse();
    }


    @Override
    public com.ebao.li.mobs.agency.dto.ClaimPolicyResponse getPolicyInfoOnEventDate(ServiceHeader parseHeader, String insurerCode,
                                                                                    com.ebao.li.mobs.agency.dto.ClaimPolicyRequest request) {
        ClaimCaseEventObject<com.ebao.li.mobs.agency.dto.ClaimPolicyRequest, com.ebao.li.mobs.agency.dto.ClaimPolicyResponse> claimCaseEventOject =
                new ClaimCaseEventObject<com.ebao.li.mobs.agency.dto.ClaimPolicyRequest, com.ebao.li.mobs.agency.dto.ClaimPolicyResponse>();
        claimCaseEventOject.setInsurerCode(insurerCode);
        claimCaseEventOject.setTenantCode(parseHeader.getXtenantId());
        claimCaseEventOject.setRequest(request);
        claimCaseEventOject.setResponse(new com.ebao.li.mobs.agency.dto.ClaimPolicyResponse());
        ClaimPolicyGetting event = new ClaimPolicyGetting(claimCaseEventOject);
        publisher.publishEvent(event);
        return claimCaseEventOject.getResponse();
    }

    @Override
    public com.ebao.li.mobs.agency.dto.ReassignCaseTaskResponse reassignCaseTask(ServiceHeader parseHeader, String insurerCode,
                                                                                 com.ebao.li.mobs.agency.dto.ReassignCaseTaskRequest request) {
        ClaimCaseEventObject<com.ebao.li.mobs.agency.dto.ReassignCaseTaskRequest, com.ebao.li.mobs.agency.dto.ReassignCaseTaskResponse> claimCaseEventOject =
                new ClaimCaseEventObject<com.ebao.li.mobs.agency.dto.ReassignCaseTaskRequest, com.ebao.li.mobs.agency.dto.ReassignCaseTaskResponse>();
        claimCaseEventOject.setInsurerCode(insurerCode);
        claimCaseEventOject.setTenantCode(parseHeader.getXtenantId());
        claimCaseEventOject.setRequest(request);
        ReassignCaseTaskEvent event = new ReassignCaseTaskEvent(claimCaseEventOject);
        publisher.publishEvent(event);
        return claimCaseEventOject.getResponse();
    }


    @Override
    public com.ebao.li.mobs.agency.dto.ClaimCandidateUsersResponse queryCandidateUsers(ServiceHeader parseHeader,
                                                                                       String insurerCode, com.ebao.li.mobs.agency.dto.CandidateUsersQueryRequest request) {
        ClaimCaseEventObject<com.ebao.li.mobs.agency.dto.CandidateUsersQueryRequest, com.ebao.li.mobs.agency.dto.ClaimCandidateUsersResponse> claimCaseEventOject =
                new ClaimCaseEventObject<com.ebao.li.mobs.agency.dto.CandidateUsersQueryRequest, com.ebao.li.mobs.agency.dto.ClaimCandidateUsersResponse>();
        claimCaseEventOject.setInsurerCode(insurerCode);
        claimCaseEventOject.setTenantCode(parseHeader.getXtenantId());
        claimCaseEventOject.setRequest(request);
        ClaimCandidateUsersGetting event = new ClaimCandidateUsersGetting(claimCaseEventOject);
        publisher.publishEvent(event);
        return claimCaseEventOject.getResponse();
    }

    @Override
    public com.ebao.li.mobs.agency.dto.ClaimCaseCommonResponse updateCase(ServiceHeader parseHeader, String insurerCode,
                                                                          com.ebao.li.mobs.agency.dto.UpdateCaseRequest request) {
        ClaimCaseEventObject<com.ebao.li.mobs.agency.dto.UpdateCaseRequest, com.ebao.li.mobs.agency.dto.ClaimCaseCommonResponse> claimCaseEventOject =
                new ClaimCaseEventObject<com.ebao.li.mobs.agency.dto.UpdateCaseRequest, com.ebao.li.mobs.agency.dto.ClaimCaseCommonResponse>();
        claimCaseEventOject.setInsurerCode(insurerCode);
        claimCaseEventOject.setTenantCode(parseHeader.getXtenantId());
        claimCaseEventOject.setRequest(request);
        UpdateCaseInformationEvent event = new UpdateCaseInformationEvent(claimCaseEventOject);
        publisher.publishEvent(event);
        return claimCaseEventOject.getResponse();
    }

    @Override
    public com.ebao.li.mobs.agency.dto.ClaimLiabilityEvaluationResponse evaluate(ServiceHeader parseHeader, String insurerCode,
                                                                                 com.ebao.li.mobs.agency.dto.ClaimLiabilityEvaluationRequest request) {
        ClaimCaseEventObject<com.ebao.li.mobs.agency.dto.ClaimLiabilityEvaluationRequest, com.ebao.li.mobs.agency.dto.ClaimLiabilityEvaluationResponse> claimCaseEventOject =
                new ClaimCaseEventObject<com.ebao.li.mobs.agency.dto.ClaimLiabilityEvaluationRequest, com.ebao.li.mobs.agency.dto.ClaimLiabilityEvaluationResponse>();
        claimCaseEventOject.setInsurerCode(insurerCode);
        claimCaseEventOject.setTenantCode(parseHeader.getXtenantId());
        claimCaseEventOject.setRequest(request);
        ClaimLiabilityEvaluationEvent event = new ClaimLiabilityEvaluationEvent(claimCaseEventOject);
        publisher.publishEvent(event);
        return claimCaseEventOject.getResponse();
    }


    @Override
    public com.ebao.li.mobs.agency.dto.ClaimCoverageEvaluationResponse evaluateCoverage(ServiceHeader parseHeader,
                                                                                        String insurerCode, com.ebao.li.mobs.agency.dto.ClaimCoverageEvaluationRequest request) {
        ClaimCaseEventObject<com.ebao.li.mobs.agency.dto.ClaimCoverageEvaluationRequest, com.ebao.li.mobs.agency.dto.ClaimCoverageEvaluationResponse> claimCaseEventOject =
                new ClaimCaseEventObject<com.ebao.li.mobs.agency.dto.ClaimCoverageEvaluationRequest, com.ebao.li.mobs.agency.dto.ClaimCoverageEvaluationResponse>();
        claimCaseEventOject.setInsurerCode(insurerCode);
        claimCaseEventOject.setTenantCode(parseHeader.getXtenantId());
        claimCaseEventOject.setRequest(request);
        ClaimCoverageEvaluationEvent event = new ClaimCoverageEvaluationEvent(claimCaseEventOject);
        publisher.publishEvent(event);
        return claimCaseEventOject.getResponse();
    }


    @Override
    public com.ebao.li.mobs.agency.dto.DisbursementAmountResponse getDisbursementAmounts(ServiceHeader parseHeader,
                                                                                         String insurerCode, String caseNo) {
        ClaimCaseEventObject<String, com.ebao.li.mobs.agency.dto.DisbursementAmountResponse> claimCaseEventOject =
                new ClaimCaseEventObject<>();
        claimCaseEventOject.setInsurerCode(insurerCode);
        claimCaseEventOject.setRequest(caseNo);
        claimCaseEventOject.setClaimCaseNo(caseNo);
        claimCaseEventOject.setTenantCode(parseHeader.getXtenantId());
        ClaimDisbursementAmountsGetting event =
                new ClaimDisbursementAmountsGetting(claimCaseEventOject);
        publisher.publishEvent(event);
        return claimCaseEventOject.getResponse();
    }


    @Override
    public com.ebao.li.mobs.agency.dto.DisbursementPlanInfo getDisbursementPlans(ServiceHeader parseHeader, String insurerCode,
                                                                                 String caseNo) {
        ClaimCaseEventObject<String, com.ebao.li.mobs.agency.dto.DisbursementPlanInfo> claimCaseEventOject =
                new ClaimCaseEventObject<String, com.ebao.li.mobs.agency.dto.DisbursementPlanInfo>();
        claimCaseEventOject.setInsurerCode(insurerCode);
        claimCaseEventOject.setRequest(caseNo);
        claimCaseEventOject.setClaimCaseNo(caseNo);
        claimCaseEventOject.setTenantCode(parseHeader.getXtenantId());
        ClaimDisbursementPlansGetting event = new ClaimDisbursementPlansGetting(claimCaseEventOject);
        publisher.publishEvent(event);
        return claimCaseEventOject.getResponse();
    }

    @Override
    public com.ebao.li.mobs.agency.dto.DisbursementPlanResponse disbursementPlan(ServiceHeader parseHeader, String insurerCode,
                                                                                 com.ebao.li.mobs.agency.dto.DisbursementPlanRequest request) {
        ClaimCaseEventObject<com.ebao.li.mobs.agency.dto.DisbursementPlanRequest, com.ebao.li.mobs.agency.dto.DisbursementPlanResponse> claimCaseEventOject =
                new ClaimCaseEventObject<com.ebao.li.mobs.agency.dto.DisbursementPlanRequest, com.ebao.li.mobs.agency.dto.DisbursementPlanResponse>();
        claimCaseEventOject.setInsurerCode(insurerCode);
        claimCaseEventOject.setTenantCode(parseHeader.getXtenantId());
        claimCaseEventOject.setRequest(request);
        ClaimDisbursementPlanEvent event = new ClaimDisbursementPlanEvent(claimCaseEventOject);
        publisher.publishEvent(event);
        return claimCaseEventOject.getResponse();
    }

    @Override
    public com.ebao.li.mobs.agency.dto.ClaimCaseEvaluationResponse evaluate(ServiceHeader parseHeader, String insurerCode,
                                                                            com.ebao.li.mobs.agency.dto.ClaimCaseEvaluationRequest request) {
        ClaimCaseEventObject<com.ebao.li.mobs.agency.dto.ClaimCaseEvaluationRequest, com.ebao.li.mobs.agency.dto.ClaimCaseEvaluationResponse> claimCaseEventOject =
                new ClaimCaseEventObject<com.ebao.li.mobs.agency.dto.ClaimCaseEvaluationRequest, com.ebao.li.mobs.agency.dto.ClaimCaseEvaluationResponse>();
        claimCaseEventOject.setInsurerCode(insurerCode);
        claimCaseEventOject.setTenantCode(parseHeader.getXtenantId());
        claimCaseEventOject.setRequest(request);
        ClaimCaseEvaluationResultEvent event = new ClaimCaseEvaluationResultEvent(claimCaseEventOject);
        publisher.publishEvent(event);
        return claimCaseEventOject.getResponse();
    }

    @Override
    public com.ebao.li.mobs.agency.dto.AppendCaseCommentsResponse appendCaseComments(ServiceHeader parseHeader,
                                                                                     String insurerCode, com.ebao.li.mobs.agency.dto.AppendCaseCommentsRequest request) {
        ClaimCaseEventObject<com.ebao.li.mobs.agency.dto.AppendCaseCommentsRequest, com.ebao.li.mobs.agency.dto.AppendCaseCommentsResponse> claimCaseEventOject =
                new ClaimCaseEventObject<com.ebao.li.mobs.agency.dto.AppendCaseCommentsRequest, com.ebao.li.mobs.agency.dto.AppendCaseCommentsResponse>();
        claimCaseEventOject.setInsurerCode(insurerCode);
        claimCaseEventOject.setTenantCode(parseHeader.getXtenantId());
        claimCaseEventOject.setRequest(request);
        ClaimCommentsAppendEvent event = new ClaimCommentsAppendEvent(claimCaseEventOject);
        publisher.publishEvent(event);
        return claimCaseEventOject.getResponse();
    }

    @Override
    public com.ebao.li.mobs.agency.dto.UploadCaseDocumentsResponse uploadCaseDocuments(ServiceHeader parseHeader,
                                                                                       String insurerCode, com.ebao.li.mobs.agency.dto.UploadCaseDocumentsRequest request) {
        ClaimCaseEventObject<com.ebao.li.mobs.agency.dto.UploadCaseDocumentsRequest, com.ebao.li.mobs.agency.dto.UploadCaseDocumentsResponse> claimCaseEventOject =
                new ClaimCaseEventObject<com.ebao.li.mobs.agency.dto.UploadCaseDocumentsRequest, UploadCaseDocumentsResponse>();
        claimCaseEventOject.setInsurerCode(insurerCode);
        claimCaseEventOject.setTenantCode(parseHeader.getXtenantId());
        claimCaseEventOject.setRequest(request);
        ClaimDocumentsUploadEvent event = new ClaimDocumentsUploadEvent(claimCaseEventOject);
        publisher.publishEvent(event);
        return claimCaseEventOject.getResponse();
    }

    @Override
    public com.ebao.li.mobs.agency.dto.ClaimTaskQueryResponse queryClaimTasks(ServiceHeader parseHeader, String insurerCode,
                                                                              com.ebao.li.mobs.agency.dto.ClaimTaskQueryRequest request) {
        ClaimCaseEventObject<com.ebao.li.mobs.agency.dto.ClaimTaskQueryRequest, com.ebao.li.mobs.agency.dto.ClaimTaskQueryResponse> claimCaseEventOject =
                new ClaimCaseEventObject<>();
        claimCaseEventOject.setInsurerCode(insurerCode);
        claimCaseEventOject.setTenantCode(parseHeader.getXtenantId());
        claimCaseEventOject.setRequest(request);
        ClaimTaskEvent event = new ClaimTaskEvent(claimCaseEventOject);
        publisher.publishEvent(event);
        return claimCaseEventOject.getResponse();
    }


    @Override
    public com.ebao.li.mobs.agency.dto.ClaimCaseApprovalResponse approve(ServiceHeader parseHeader, String insurerCode,
                                                                         com.ebao.li.mobs.agency.dto.ClaimCaseApprovalRequest request) {
        ClaimCaseEventObject<com.ebao.li.mobs.agency.dto.ClaimCaseApprovalRequest, com.ebao.li.mobs.agency.dto.ClaimCaseApprovalResponse> claimCaseEventOject =
                new ClaimCaseEventObject<com.ebao.li.mobs.agency.dto.ClaimCaseApprovalRequest, com.ebao.li.mobs.agency.dto.ClaimCaseApprovalResponse>();
        claimCaseEventOject.setInsurerCode(insurerCode);
        claimCaseEventOject.setTenantCode(parseHeader.getXtenantId());
        claimCaseEventOject.setRequest(request);
        ClaimCaseApprovalResultEvent event = new ClaimCaseApprovalResultEvent(claimCaseEventOject);
        publisher.publishEvent(event);
        return claimCaseEventOject.getResponse();
    }

    @Override
    public com.ebao.li.mobs.agency.dto.ClaimCaseCancelResponse cancel(ServiceHeader parseHeader, String insurerCode,
                                                                      com.ebao.li.mobs.agency.dto.ClaimCaseCancelRequest request) {
        Assert.notNull(request.getClaimCaseNo(), "ClaimCaseNo Cannot Be Null");
        ClaimCaseEventObject<com.ebao.li.mobs.agency.dto.ClaimCaseCancelRequest, com.ebao.li.mobs.agency.dto.ClaimCaseCancelResponse> claimCaseEventOject =
                new ClaimCaseEventObject<com.ebao.li.mobs.agency.dto.ClaimCaseCancelRequest, com.ebao.li.mobs.agency.dto.ClaimCaseCancelResponse>();
        claimCaseEventOject.setInsurerCode(insurerCode);
        claimCaseEventOject.setTenantCode(parseHeader.getXtenantId());
        claimCaseEventOject.setRequest(request);
        ClaimCaseCancelEvent event = new ClaimCaseCancelEvent(claimCaseEventOject);
        publisher.publishEvent(event);
        return claimCaseEventOject.getResponse();
    }

    @Override
    public com.ebao.li.mobs.agency.dto.ClaimAcceptResponse accept(ServiceHeader parseHeader, String insurerCode,
                                                                  com.ebao.li.mobs.agency.dto.ClaimAcceptRequest request) {
        ClaimCaseEventObject<com.ebao.li.mobs.agency.dto.ClaimAcceptRequest, com.ebao.li.mobs.agency.dto.ClaimAcceptResponse> claimCaseEventOject =
                new ClaimCaseEventObject<com.ebao.li.mobs.agency.dto.ClaimAcceptRequest, com.ebao.li.mobs.agency.dto.ClaimAcceptResponse>();
        claimCaseEventOject.setInsurerCode(insurerCode);
        claimCaseEventOject.setTenantCode(parseHeader.getXtenantId());
        claimCaseEventOject.setRequest(request);
        ClaimPolicyAcceptEvent event = new ClaimPolicyAcceptEvent(claimCaseEventOject);
        publisher.publishEvent(event);
        return claimCaseEventOject.getResponse();
    }

    @Override
    public com.ebao.li.mobs.agency.dto.ClaimPolicyAdditionPremResponse reverseAdditionPrems(ServiceHeader parseHeader,
                                                                                            String insurerCode, com.ebao.li.mobs.agency.dto.ClaimPolicyRequest request) {
        Assert.notNull(request.getPolicyNumber(), "PolicyNumber Cannot Be Null");
        ClaimCaseEventObject<com.ebao.li.mobs.agency.dto.ClaimPolicyRequest, com.ebao.li.mobs.agency.dto.ClaimPolicyAdditionPremResponse> claimCaseEventOject =
                new ClaimCaseEventObject<com.ebao.li.mobs.agency.dto.ClaimPolicyRequest, com.ebao.li.mobs.agency.dto.ClaimPolicyAdditionPremResponse>();
        claimCaseEventOject.setInsurerCode(insurerCode);
        claimCaseEventOject.setTenantCode(parseHeader.getXtenantId());
        claimCaseEventOject.setRequest(request);
        ClaimPolicyAdditionPremEvent event = new ClaimPolicyAdditionPremEvent(claimCaseEventOject);
        publisher.publishEvent(event);
        return claimCaseEventOject.getResponse();
    }

    @Override
    public com.ebao.li.mobs.agency.dto.PolicyRenewalExtractionResponse osPremiums(ServiceHeader parseHeader, String insurerCode,
                                                                                  com.ebao.li.mobs.agency.dto.ClaimPolicyOsPremiumsRequest request) {
        Assert.notNull(request.getPolicyNumber(), "PolicyNumber Cannot Be Null");
        ClaimCaseEventObject<com.ebao.li.mobs.agency.dto.ClaimPolicyOsPremiumsRequest, com.ebao.li.mobs.agency.dto.PolicyRenewalExtractionResponse> claimCaseEventOject =
                new ClaimCaseEventObject<com.ebao.li.mobs.agency.dto.ClaimPolicyOsPremiumsRequest, com.ebao.li.mobs.agency.dto.PolicyRenewalExtractionResponse>();
        claimCaseEventOject.setInsurerCode(insurerCode);
        claimCaseEventOject.setTenantCode(parseHeader.getXtenantId());
        claimCaseEventOject.setRequest(request);
        ClaimPolicyOsPremEvent event = new ClaimPolicyOsPremEvent(claimCaseEventOject);
        publisher.publishEvent(event);
        return claimCaseEventOject.getResponse();
    }

    @Override
    @Transactional
    public com.ebao.li.mobs.agency.dto.ClaimCheckListResponse saveCheckList(ServiceHeader parseHeader, String insurerCode,
                                                                            com.ebao.li.mobs.agency.dto.ClaimCheckListRequest request) {
        // delete additional
        claimChecklistRepository.deleteByCaseIdAndAndChecklistType(request.getCaseId(), "3");

        // required and optional
        List<Long> ids = Lists.newArrayList();
        ids.addAll(request.getRequiredCheckList().stream().map(a -> a.getListId()).collect(Collectors.toList()));
        ids.addAll(request.getOptionalCheckList().stream().map(a -> a.getListId()).collect(Collectors.toList()));
        List<com.ebao.li.mobs.agency.jpa.bo.ClaimChecklist> list = claimChecklistRepository.findByListIdIn(ids);
        for (com.ebao.li.mobs.agency.jpa.bo.ClaimChecklist data : list) {
            Optional<CheckListItemInput> input = request.getRequiredCheckList().stream().filter(a -> a.getListId().equals(data.getListId())).findFirst();
            if (!input.isPresent()) {
                input = request.getOptionalCheckList().stream().filter(a -> a.getListId().equals(data.getListId())).findFirst();
            }
            data.setCompleteness(input.get().getCompleteness());
            data.setWaive(input.get().getWaive());
            data.setSubmissionDate(input.get().getSubmissionDate());
            ConvertUtil.initUpdateEntity(data);
        }

        // additional
        List<com.ebao.li.mobs.agency.jpa.bo.ClaimChecklist> additionalCheckList = ConvertUtil.convert(request.getAdditionalCheckList(), com.ebao.li.mobs.agency.jpa.bo.ClaimChecklist.class);
        for (com.ebao.li.mobs.agency.jpa.bo.ClaimChecklist data : additionalCheckList) {
            ConvertUtil.initInsertEntity(data);
        }
        list.addAll(additionalCheckList);

        // save
        claimChecklistRepository.saveAll(list);

        com.ebao.li.mobs.agency.dto.ClaimCheckListResponse resp = new com.ebao.li.mobs.agency.dto.ClaimCheckListResponse();
        resp.setCaseId(request.getCaseId());
        return resp;
    }

    @Override
    public com.ebao.li.mobs.agency.dto.ClaimCheckListResponse loadCheckList(ServiceHeader parseHeader, String insurerCode,
                                                                            Long caseId) {
        List<com.ebao.li.mobs.agency.jpa.bo.ClaimChecklist> list = claimChecklistRepository.findByCaseId(caseId);
        List<CheckListItemInfo> responseList = ConvertUtil.convert(list, CheckListItemInfo.class);

        com.ebao.li.mobs.agency.dto.ClaimCheckListResponse resp = new com.ebao.li.mobs.agency.dto.ClaimCheckListResponse();
        resp.setCaseId(caseId);
        resp.setRequiredCheckList(responseList.stream().filter(a -> a.getChecklistType().equals("1")).collect(Collectors.toList()));
        resp.setOptionalCheckList(responseList.stream().filter(a -> a.getChecklistType().equals("2")).collect(Collectors.toList()));
        resp.setAdditionalCheckList(responseList.stream().filter(a -> a.getChecklistType().equals("3")).collect(Collectors.toList()));
        return resp;
    }

    @Override
    @Transactional
    public com.ebao.li.mobs.agency.dto.ClaimCheckListResponse initCheckList(ServiceHeader parseHeader, String insurerCode,
                                                                            Long caseId, Long claimType) {
        // 清空checklist
        claimChecklistRepository.deleteByCaseId(caseId);

        // 初始化checklist
        List<com.ebao.li.mobs.agency.jpa.bo.ClaimTypeChecklist> claimTypeChecklist = claimTypeChecklistRepository.findByClaimType(claimType);
        List<ClaimChecklist> list = ConvertUtil.convert(claimTypeChecklist, caseId);
        claimChecklistRepository.saveAll(list);

        com.ebao.li.mobs.agency.dto.ClaimCheckListResponse resp = new com.ebao.li.mobs.agency.dto.ClaimCheckListResponse();
        resp.setCaseId(caseId);
        return resp;
    }

    @Override
    public com.ebao.li.mobs.agency.dto.InsuredQueryResponse searchClaimInsureds(ServiceHeader parseHeader, String insurerCode, com.ebao.li.mobs.agency.dto.InsuredQueryRequest request) {
        com.ebao.li.mobs.agency.dto.InsuredQueryResponse response = new com.ebao.li.mobs.agency.dto.InsuredQueryResponse();
        return response;
    }
}
