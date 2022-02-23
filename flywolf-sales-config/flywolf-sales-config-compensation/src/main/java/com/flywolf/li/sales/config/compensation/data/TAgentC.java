package com.flywolf.li.sales.config.compensation.data;

import com.flywolf.li.framework.entity.ExtendableAuditEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "T_AGENT_C")
@EqualsAndHashCode(callSuper = true)
public class TAgentC extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "AGENT_ID", nullable = false)
    private String agentId;

    @Column(name = "REAL_NAME")
    private String realName;

    @Column(name = "GENDER")
    private String GENDER;

    @Column(name = "BIRTHDAY")
    private LocalDate BIRTHDAY;

    @Column(name = "CERTI_TYPE")
    private String certiType;

    @Column(name = "CERTI_CODE")
    private String certiCode;

    @Column(name = "AGENT_CODE", nullable = false)
    private String agentCode;

    @Column(name = "ORGAN_ID")
    private String organId;

    @Column(name = "HEAD_ID")
    private String headId;

    @Column(name = "BRANCH_ID")
    private String branchId;

    @Column(name = "DEPT_ID")
    private String deptId;

    @Column(name = "AGENT_STATUS", nullable = false)
    private String agentStatus;

    @Column(name = "UPDATER_ID")
    private String updaterId;

    @Column(name = "ADDRESS_ID")
    private String addressId;

    @Column(name = "COMM_ACCOUNT_ID")
    private String commAccountId;

    @Column(name = "PREM_ACCOUNT_ID")
    private String premAccountId;

    @Column(name = "AGENT_CATE", nullable = false)
    private String agentCate;

    @Column(name = "AGENT_SUBSTATUS")
    private String agentSubstatus;

    @Column(name = "STATUS_REASON")
    private String statusReason;

    @Column(name = "APPOINMENT_DATE")
    private LocalDate appoinmentDate;

    @Column(name = "MAIL_BOX")
    private String mailBox;

    @Column(name = "SPECIAL_GROUP")
    private String specialGroup;

    @Column(name = "TITLE")
    private String TITLE;

    @Column(name = "NATIONALITY")
    private String NATIONALITY;

    @Column(name = "MARRIAGE_ID")
    private String marriageId;

    @Column(name = "LANG_ID")
    private String langId;

    @Column(name = "NATION_CODE")
    private String nationCode;

    @Column(name = "BUMI_INDI")
    private String bumiIndi;

    @Column(name = "ALIAS_NAME")
    private String aliasName;

    @Column(name = "APPOINTMENT_TYPE")
    private String appointmentType;

    @Column(name = "ASU_TYPE")
    private String asuType;

    @Column(name = "AGENT_GRADE")
    private String agentGrade;

    @Column(name = "STATUS_DATE")
    private LocalDate statusDate;

    @Column(name = "SUBSTATUS_DATE")
    private LocalDate substatusDate;

    @Column(name = "AGENT_PT_INDI", nullable = false)
    private String agentPtIndi;

    @Column(name = "HRCHY_LVL")
    private String hrchyLvl;

    @Column(name = "HRCHY_EFF_DATE")
    private LocalDate hrchyEffDate;

    @Column(name = "UNFAVORABLE_INDI")
    private String unfavorableIndi;

    @Column(name = "GREEN_PASSPORT")
    private String greenPassport;

    @Column(name = "REENTER_FLAG")
    private String reenterFlag;

    @Column(name = "INIT_AGENT_GRADE")
    private String initAgentGrade;

    @Column(name = "ENTER_COMPANY_DATE")
    private LocalDate enterCompanyDate;

    @Column(name = "LEAVE_COMPANY_DATE")
    private LocalDate leaveCompanyDate;

    @Column(name = "PROBATION_DATE")
    private LocalDate probationDate;

    @Column(name = "TURN_DATE")
    private LocalDate turnDate;

    @Column(name = "SIGN_DATE")
    private LocalDate signDate;

    @Column(name = "SIGN_END_DATE")
    private LocalDate signEndDate;

    @Column(name = "RECOMMENDER_ID")
    private String recommenderId;

    @Column(name = "TRAINER_ID")
    private String trainerId;

    @Column(name = "IND_TRAINER_ID")
    private String indTrainerId;

    @Column(name = "DEPT_TRAINER_ID")
    private String deptTrainerId;

    @Column(name = "IND_DEPT_TRAINER_ID")
    private String indDeptTrainerId;

    @Column(name = "DEPT_TRAIN_DATE")
    private LocalDate deptTrainDate;

    @Column(name = "GROUP_TRAINER_ID")
    private String groupTrainerId;

    @Column(name = "IND_GROUP_TRAINER_ID")
    private String indGroupTrainerId;

    @Column(name = "GROUP_TRAIN_DATE")
    private LocalDate groupTrainDate;

    @Column(name = "AREA_TRAINER_ID")
    private String areaTrainerId;

    @Column(name = "AREA_TRAIN_DATE")
    private LocalDate areaTrainDate;

    @Column(name = "CHK_PAYEE_NAME")
    private String chkPayeeName;

    @Column(name = "EXPERIENCE_YEAR")
    private String experienceYear;

    @Column(name = "RECRUIT_SOURCE")
    private String recruitSource;

    @Column(name = "RESIGN_NOTIFY_DATE")
    private LocalDate resignNotifyDate;

    @Column(name = "PROBATION_MONTH")
    private String probationMonth;

    @Column(name = "PRD_WAIVER_START")
    private LocalDate prdWaiverStart;

    @Column(name = "PRD_WAIVER_END")
    private LocalDate prdWaiverEnd;

    @Column(name = "WELFARE_CLASS")
    private String welfareClass;

    @Column(name = "WELFARE_STATUS")
    private String welfareStatus;

    @Column(name = "WELFARE_EFFECT_DATE")
    private LocalDate welfareEffectDate;

    @Column(name = "WELFARE_TERMINATE_DATE")
    private LocalDate welfareTerminateDate;

    @Column(name = "ADIS_CLASS")
    private String adisClass;

    @Column(name = "ADIS_EFFECT_DATE")
    private LocalDate adisEffectDate;

    @Column(name = "ADIS_TERMINATE_DATE")
    private LocalDate adisTerminateDate;

    @Column(name = "CATCH_START")
    private LocalDate catchStart;

    @Column(name = "CATCH_END")
    private LocalDate catchEnd;

    @Column(name = "GUARANTOR_ID")
    private String guarantorId;

    @Column(name = "HOLDBACK_REASON")
    private String holdbackReason;

    @Column(name = "AGREEMENT_DATE")
    private LocalDate agreementDate;

    @Column(name = "BANK_BRANCH_CODE")
    private String bankBranchCode;

    @Column(name = "BEGIN_JOB_DATE")
    private LocalDate beginJobDate;

    @Column(name = "COMPANY_AGENT")
    private String companyAgent;

    @Column(name = "COMPANY_DIRECT_INDI", nullable = false)
    private String companyDirectIndi;

    @Column(name = "COMPUTER_LEVEL")
    private String computerLevel;

    @Column(name = "DEGREE_ID")
    private String degreeId;

    @Column(name = "DIRECT_APPOINTMENT")
    private String directAppointment;

    @Column(name = "EDUCATION_ID")
    private String educationId;

    @Column(name = "HOLDBACK_INDI")
    private String holdbackIndi;

    @Column(name = "HOLDBACK_PERIOD")
    private String holdbackPeriod;

    @Column(name = "HONOR_GRADE")
    private String honorGrade;

    @Column(name = "INVEST_CERTI_CODE")
    private String investCertiCode;

    @Column(name = "LANGUAGE_LEVEL_ID")
    private String languageLevelId;

    @Column(name = "MAJOR")
    private String MAJOR;

    @Column(name = "OLD_JOB_COMPANY")
    private String oldJobCompany;

    @Column(name = "OLD_JOB_ID")
    private String oldJobId;

    @Column(name = "PARTY_ID")
    private String partyId;

    @Column(name = "PAYMENT_METHOD")
    private String paymentMethod;

    @Column(name = "PAYMENT_MODE")
    private String paymentMode;

    @Column(name = "PAYMENT_PERIOD")
    private String paymentPeriod;

    @Column(name = "PRACTICE_CERTI_CODE")
    private String practiceCertiCode;

    @Column(name = "QUALIFICATION_CERTI_CODE")
    private String qualificationCertiCode;

    @Column(name = "RECRUITER_ID")
    private String recruiterId;

    @Column(name = "SCHOOL")
    private String SCHOOL;

    @Column(name = "SENIOR_AGENT")
    private String seniorAgent;

    @Column(name = "SPECIAL_FAVOR")
    private String specialFavor;

    @Column(name = "SPOUSE_ID")
    private String spouseId;

    @Column(name = "HOLDBACK_RATE")
    private String holdbackRate;

    @Column(name = "CHK_REASON")
    private String chkReason;

    @Column(name = "RECEIVE_SMS_INDI", nullable = false)
    private String receiveSmsIndi;

    @Column(name = "WAIVER_REASON")
    private String waiverReason;

    @Column(name = "CONTRACT_COMMENT")
    private String contractComment;

    @Column(name = "BENEFICIARY")
    private String BENEFICIARY;

    @Column(name = "THRESHOLD")
    private String THRESHOLD;

    @Column(name = "GRADING_FACTOR")
    private String gradingFactor;

    @Column(name = "RECRUITER_BONUS_INDI")
    private String recruiterBonusIndi;

    @Column(name = "OLD_JOB_START")
    private LocalDate oldJobStart;

    @Column(name = "OLD_JOB_END")
    private LocalDate oldJobEnd;

    @Column(name = "TIER_GROUP")
    private String tierGroup;

    @Column(name = "MDRT_SERV_INDI")
    private String mdrtServIndi;

    @Column(name = "ADIS_WAIVER_INDI")
    private String adisWaiverIndi;

    @Column(name = "GCAI_INDI")
    private String gcaiIndi;

    @Column(name = "PROBATION_START")
    private String probationStart;

    @Column(name = "PROBATION_REASON")
    private String probationReason;

    @Column(name = "HOLDBACK_END")
    private LocalDate holdbackEnd;

    @Column(name = "HOLDBACK_START")
    private LocalDate holdbackStart;

    @Column(name = "INSTALLMENT_NUM")
    private String installmentNum;

    @Column(name = "PAYMENT_START")
    private LocalDate paymentStart;

    @Column(name = "SIMPLE_HOLDBACK")
    private String simpleHoldback;

    @Column(name = "TERMINATE_DATE")
    private LocalDate terminateDate;

    @Column(name = "GRADE_DATE")
    private LocalDate gradeDate;

    @Column(name = "TERMINATE_CLAUSE")
    private String terminateClause;

    @Column(name = "DEPENDENT_INDI")
    private String dependentIndi;

    @Column(name = "RECORDER_ID")
    private String recorderId;

    @Column(name = "EXP_INDI", nullable = false)
    private String expIndi;

    @Column(name = "COMPLAINT_DATE")
    private LocalDate complaintDate;

    @Column(name = "PAIDOFF_DATE")
    private LocalDate paidoffDate;

    @Column(name = "BANKRUPTCY_DATE")
    private LocalDate bankruptcyDate;

    @Column(name = "REPLACED")
    private String REPLACED;

    @Column(name = "REPLACE_DATE")
    private LocalDate replaceDate;

    @Column(name = "SELF_OVERRIDE_INDI", nullable = false)
    private String selfOverrideIndi;

    @Column(name = "AF_AGENT_ID")
    private String afAgentId;

    @Column(name = "AF_EFFECTIVE_DATE")
    private LocalDate afEffectiveDate;

    @Column(name = "SMS_AND_EMAIL")
    private String smsAndEmail;

    @Column(name = "VISA_TYPE")
    private String visaType;

    @Column(name = "VISA_EXPIRY_DATE")
    private LocalDate visaExpiryDate;

    @Column(name = "RECRUIT_TYPE")
    private String recruitType;

    @Column(name = "RATE_TIER")
    private String rateTier;

    @Column(name = "RATE_TIER_EFFECTIVE_DATE")
    private LocalDate rateTierEffectiveDate;

    @Column(name = "AGENT_ROLE")
    private String agentRole;

    @Column(name = "ROLE_EXPIRY_PERIOD")
    private LocalDate roleExpiryPeriod;

    @Column(name = "DRAGON_NETWORK")
    private String dragonNetwork;

    @Column(name = "BUSINESS_LINE_CODE")
    private String businessLineCode;

    @Column(name = "CHANNEL_ANLYSIS_CODE")
    private String channelAnlysisCode;

    @Column(name = "TR_TRAINING")
    private String trTraining;

}
