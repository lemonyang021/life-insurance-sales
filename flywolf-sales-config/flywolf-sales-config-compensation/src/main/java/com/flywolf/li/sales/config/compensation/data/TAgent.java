package com.flywolf.li.sales.config.compensation.data;

import com.flywolf.li.framework.entity.ExtendableAuditEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "T_AGENT")
@EqualsAndHashCode(callSuper = true)
public class TAgent extends ExtendableAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * AGENT_ID
     */
    @Id
    @Column(name = "AGENT_ID", nullable = false)
    private String agentId;

    /**
     * REAL_NAME
     */
    @Column(name = "REAL_NAME")
    private String realName;

    /**
     * GENDER
     */
    @Column(name = "GENDER")
    private String GENDER;

    /**
     * BIRTHDAY
     */
    @Column(name = "BIRTHDAY")
    private LocalDate BIRTHDAY;

    /**
     * CERTI_TYPE
     */
    @Column(name = "CERTI_TYPE")
    private String certiType;

    /**
     * CERTI_CODE
     */
    @Column(name = "CERTI_CODE")
    private String certiCode;

    /**
     * AGENT_CODE
     */
    @Column(name = "AGENT_CODE", nullable = false)
    private String agentCode;

    /**
     * ORGAN_ID
     */
    @Column(name = "ORGAN_ID")
    private String organId;

    /**
     * HEAD_ID
     */
    @Column(name = "HEAD_ID")
    private String headId;

    /**
     * BRANCH_ID
     */
    @Column(name = "BRANCH_ID")
    private String branchId;

    /**
     * DEPT_ID
     */
    @Column(name = "DEPT_ID")
    private String deptId;

    /**
     * AGENT_STATUS
     */
    @Column(name = "AGENT_STATUS", nullable = false)
    private String agentStatus;

    /**
     * UPDATER_ID
     */
    @Column(name = "UPDATER_ID")
    private String updaterId;

    /**
     * ADDRESS_ID
     */
    @Column(name = "ADDRESS_ID")
    private String addressId;

    /**
     * COMM_ACCOUNT_ID
     */
    @Column(name = "COMM_ACCOUNT_ID")
    private String commAccountId;

    /**
     * PREM_ACCOUNT_ID
     */
    @Column(name = "PREM_ACCOUNT_ID")
    private String premAccountId;

    /**
     * AGENT_CATE
     */
    @Column(name = "AGENT_CATE", nullable = false)
    private String agentCate;

    /**
     * AGENT_SUBSTATUS
     */
    @Column(name = "AGENT_SUBSTATUS")
    private String agentSubstatus;

    /**
     * STATUS_REASON
     */
    @Column(name = "STATUS_REASON")
    private String statusReason;

    /**
     * APPOINMENT_DATE
     */
    @Column(name = "APPOINMENT_DATE")
    private LocalDate appoinmentDate;

    /**
     * MAIL_BOX
     */
    @Column(name = "MAIL_BOX")
    private String mailBox;

    /**
     * SPECIAL_GROUP
     */
    @Column(name = "SPECIAL_GROUP")
    private String specialGroup;

    /**
     * TITLE
     */
    @Column(name = "TITLE")
    private String TITLE;

    /**
     * NATIONALITY
     */
    @Column(name = "NATIONALITY")
    private String NATIONALITY;

    /**
     * MARRIAGE_ID
     */
    @Column(name = "MARRIAGE_ID")
    private String marriageId;

    /**
     * LANG_ID
     */
    @Column(name = "LANG_ID")
    private String langId;

    /**
     * NATION_CODE
     */
    @Column(name = "NATION_CODE")
    private String nationCode;

    /**
     * BUMI_INDI
     */
    @Column(name = "BUMI_INDI")
    private String bumiIndi;

    /**
     * ALIAS_NAME
     */
    @Column(name = "ALIAS_NAME")
    private String aliasName;

    /**
     * APPOINTMENT_TYPE
     */
    @Column(name = "APPOINTMENT_TYPE")
    private String appointmentType;

    /**
     * ASU_TYPE
     */
    @Column(name = "ASU_TYPE")
    private String asuType;

    /**
     * AGENT_GRADE
     */
    @Column(name = "AGENT_GRADE")
    private String agentGrade;

    /**
     * STATUS_DATE
     */
    @Column(name = "STATUS_DATE")
    private LocalDate statusDate;

    /**
     * SUBSTATUS_DATE
     */
    @Column(name = "SUBSTATUS_DATE")
    private LocalDate substatusDate;

    /**
     * AGENT_PT_INDI
     */
    @Column(name = "AGENT_PT_INDI", nullable = false)
    private String agentPtIndi;

    /**
     * HRCHY_LVL
     */
    @Column(name = "HRCHY_LVL")
    private String hrchyLvl;

    /**
     * HRCHY_EFF_DATE
     */
    @Column(name = "HRCHY_EFF_DATE")
    private LocalDate hrchyEffDate;

    /**
     * UNFAVORABLE_INDI
     */
    @Column(name = "UNFAVORABLE_INDI")
    private String unfavorableIndi;

    /**
     * GREEN_PASSPORT
     */
    @Column(name = "GREEN_PASSPORT")
    private String greenPassport;

    /**
     * REENTER_FLAG
     */
    @Column(name = "REENTER_FLAG")
    private String reenterFlag;

    /**
     * INIT_AGENT_GRADE
     */
    @Column(name = "INIT_AGENT_GRADE")
    private String initAgentGrade;

    /**
     * ENTER_COMPANY_DATE
     */
    @Column(name = "ENTER_COMPANY_DATE")
    private LocalDate enterCompanyDate;

    /**
     * LEAVE_COMPANY_DATE
     */
    @Column(name = "LEAVE_COMPANY_DATE")
    private LocalDate leaveCompanyDate;

    /**
     * PROBATION_DATE
     */
    @Column(name = "PROBATION_DATE")
    private LocalDate probationDate;

    /**
     * TURN_DATE
     */
    @Column(name = "TURN_DATE")
    private LocalDate turnDate;

    /**
     * SIGN_DATE
     */
    @Column(name = "SIGN_DATE")
    private LocalDate signDate;

    /**
     * SIGN_END_DATE
     */
    @Column(name = "SIGN_END_DATE")
    private LocalDate signEndDate;

    /**
     * RECOMMENDER_ID
     */
    @Column(name = "RECOMMENDER_ID")
    private String recommenderId;

    /**
     * TRAINER_ID
     */
    @Column(name = "TRAINER_ID")
    private String trainerId;

    /**
     * IND_TRAINER_ID
     */
    @Column(name = "IND_TRAINER_ID")
    private String indTrainerId;

    /**
     * DEPT_TRAINER_ID
     */
    @Column(name = "DEPT_TRAINER_ID")
    private String deptTrainerId;

    /**
     * IND_DEPT_TRAINER_ID
     */
    @Column(name = "IND_DEPT_TRAINER_ID")
    private String indDeptTrainerId;

    /**
     * DEPT_TRAIN_DATE
     */
    @Column(name = "DEPT_TRAIN_DATE")
    private LocalDate deptTrainDate;

    /**
     * GROUP_TRAINER_ID
     */
    @Column(name = "GROUP_TRAINER_ID")
    private String groupTrainerId;

    /**
     * IND_GROUP_TRAINER_ID
     */
    @Column(name = "IND_GROUP_TRAINER_ID")
    private String indGroupTrainerId;

    /**
     * GROUP_TRAIN_DATE
     */
    @Column(name = "GROUP_TRAIN_DATE")
    private LocalDate groupTrainDate;

    /**
     * AREA_TRAINER_ID
     */
    @Column(name = "AREA_TRAINER_ID")
    private String areaTrainerId;

    /**
     * AREA_TRAIN_DATE
     */
    @Column(name = "AREA_TRAIN_DATE")
    private LocalDate areaTrainDate;

    /**
     * EDUCATION_ID
     */
    @Column(name = "EDUCATION_ID")
    private String educationId;

    /**
     * SCHOOL
     */
    @Column(name = "SCHOOL")
    private String SCHOOL;

    /**
     * MAJOR
     */
    @Column(name = "MAJOR")
    private String MAJOR;

    /**
     * DEGREE_ID
     */
    @Column(name = "DEGREE_ID")
    private String degreeId;

    /**
     * LANGUAGE_LEVEL_ID
     */
    @Column(name = "LANGUAGE_LEVEL_ID")
    private String languageLevelId;

    /**
     * SPOUSE_ID
     */
    @Column(name = "SPOUSE_ID")
    private String spouseId;

    /**
     * SPECIAL_FAVOR
     */
    @Column(name = "SPECIAL_FAVOR")
    private String specialFavor;

    /**
     * COMPUTER_LEVEL
     */
    @Column(name = "COMPUTER_LEVEL")
    private String computerLevel;

    /**
     * BEGIN_JOB_DATE
     */
    @Column(name = "BEGIN_JOB_DATE")
    private LocalDate beginJobDate;

    /**
     * OLD_JOB_ID
     */
    @Column(name = "OLD_JOB_ID")
    private String oldJobId;

    /**
     * OLD_JOB_COMPANY
     */
    @Column(name = "OLD_JOB_COMPANY")
    private String oldJobCompany;

    /**
     * SENIOR_AGENT
     */
    @Column(name = "SENIOR_AGENT")
    private String seniorAgent;

    /**
     * COMPANY_AGENT
     */
    @Column(name = "COMPANY_AGENT")
    private String companyAgent;

    /**
     * DIRECT_APPOINTMENT
     */
    @Column(name = "DIRECT_APPOINTMENT")
    private String directAppointment;

    /**
     * AGREEMENT_DATE
     */
    @Column(name = "AGREEMENT_DATE")
    private LocalDate agreementDate;

    /**
     * QUALIFICATION_CERTI_CODE
     */
    @Column(name = "QUALIFICATION_CERTI_CODE")
    private String qualificationCertiCode;

    /**
     * PRACTICE_CERTI_CODE
     */
    @Column(name = "PRACTICE_CERTI_CODE")
    private String practiceCertiCode;

    /**
     * INVEST_CERTI_CODE
     */
    @Column(name = "INVEST_CERTI_CODE")
    private String investCertiCode;

    /**
     * HOLDBACK_INDI
     */
    @Column(name = "HOLDBACK_INDI")
    private String holdbackIndi;

    /**
     * HOLDBACK_PERIOD
     */
    @Column(name = "HOLDBACK_PERIOD")
    private String holdbackPeriod;

    /**
     * HOLDBACK_RATE
     */
    @Column(name = "HOLDBACK_RATE")
    private String holdbackRate;

    /**
     * PAYMENT_MODE
     */
    @Column(name = "PAYMENT_MODE")
    private String paymentMode;

    /**
     * PAYMENT_PERIOD
     */
    @Column(name = "PAYMENT_PERIOD")
    private String paymentPeriod;

    /**
     * BANK_BRANCH_CODE
     */
    @Column(name = "BANK_BRANCH_CODE")
    private String bankBranchCode;

    /**
     * PARTY_ID
     */
    @Column(name = "PARTY_ID")
    private String partyId;

    /**
     * RECRUITER_ID
     */
    @Column(name = "RECRUITER_ID")
    private String recruiterId;

    /**
     * CHK_PAYEE_NAME
     */
    @Column(name = "CHK_PAYEE_NAME")
    private String chkPayeeName;

    /**
     * EXPERIENCE_YEAR
     */
    @Column(name = "EXPERIENCE_YEAR")
    private String experienceYear;

    /**
     * RECRUIT_SOURCE
     */
    @Column(name = "RECRUIT_SOURCE")
    private String recruitSource;

    /**
     * RESIGN_NOTIFY_DATE
     */
    @Column(name = "RESIGN_NOTIFY_DATE")
    private LocalDate resignNotifyDate;

    /**
     * PROBATION_MONTH
     */
    @Column(name = "PROBATION_MONTH")
    private String probationMonth;

    /**
     * PRD_WAIVER_START
     */
    @Column(name = "PRD_WAIVER_START")
    private LocalDate prdWaiverStart;

    /**
     * PRD_WAIVER_END
     */
    @Column(name = "PRD_WAIVER_END")
    private LocalDate prdWaiverEnd;

    /**
     * WELFARE_CLASS
     */
    @Column(name = "WELFARE_CLASS")
    private String welfareClass;

    /**
     * WELFARE_STATUS
     */
    @Column(name = "WELFARE_STATUS")
    private String welfareStatus;

    /**
     * WELFARE_EFFECT_DATE
     */
    @Column(name = "WELFARE_EFFECT_DATE")
    private LocalDate welfareEffectDate;

    /**
     * WELFARE_TERMINATE_DATE
     */
    @Column(name = "WELFARE_TERMINATE_DATE")
    private LocalDate welfareTerminateDate;

    /**
     * ADIS_CLASS
     */
    @Column(name = "ADIS_CLASS")
    private String adisClass;

    /**
     * ADIS_EFFECT_DATE
     */
    @Column(name = "ADIS_EFFECT_DATE")
    private LocalDate adisEffectDate;

    /**
     * ADIS_TERMINATE_DATE
     */
    @Column(name = "ADIS_TERMINATE_DATE")
    private LocalDate adisTerminateDate;

    /**
     * CATCH_START
     */
    @Column(name = "CATCH_START")
    private LocalDate catchStart;

    /**
     * CATCH_END
     */
    @Column(name = "CATCH_END")
    private LocalDate catchEnd;

    /**
     * GUARANTOR_ID
     */
    @Column(name = "GUARANTOR_ID")
    private String guarantorId;

    /**
     * HOLDBACK_REASON
     */
    @Column(name = "HOLDBACK_REASON")
    private String holdbackReason;

    /**
     * HONOR_GRADE
     */
    @Column(name = "HONOR_GRADE")
    private String honorGrade;

    /**
     * COMPANY_DIRECT_INDI
     */
    @Column(name = "COMPANY_DIRECT_INDI", nullable = false)
    private String companyDirectIndi;

    /**
     * PAYMENT_METHOD
     */
    @Column(name = "PAYMENT_METHOD")
    private String paymentMethod;

    /**
     * CHK_REASON
     */
    @Column(name = "CHK_REASON")
    private String chkReason;

    /**
     * RECEIVE_SMS_INDI
     */
    @Column(name = "RECEIVE_SMS_INDI", nullable = false)
    private String receiveSmsIndi;

    /**
     * WAIVER_REASON
     */
    @Column(name = "WAIVER_REASON")
    private String waiverReason;

    /**
     * CONTRACT_COMMENT
     */
    @Column(name = "CONTRACT_COMMENT")
    private String contractComment;

    /**
     * BENEFICIARY
     */
    @Column(name = "BENEFICIARY")
    private String BENEFICIARY;

    /**
     * THRESHOLD
     */
    @Column(name = "THRESHOLD")
    private String THRESHOLD;

    /**
     * GRADING_FACTOR
     */
    @Column(name = "GRADING_FACTOR")
    private String gradingFactor;

    /**
     * RECRUITER_BONUS_INDI
     */
    @Column(name = "RECRUITER_BONUS_INDI")
    private String recruiterBonusIndi;

    /**
     * OLD_JOB_START
     */
    @Column(name = "OLD_JOB_START")
    private LocalDate oldJobStart;

    /**
     * OLD_JOB_END
     */
    @Column(name = "OLD_JOB_END")
    private LocalDate oldJobEnd;

    /**
     * TIER_GROUP
     */
    @Column(name = "TIER_GROUP")
    private String tierGroup;

    /**
     * MDRT_SERV_INDI
     */
    @Column(name = "MDRT_SERV_INDI")
    private String mdrtServIndi;

    /**
     * ADIS_WAIVER_INDI
     */
    @Column(name = "ADIS_WAIVER_INDI")
    private String adisWaiverIndi;

    /**
     * GCAI_INDI
     */
    @Column(name = "GCAI_INDI")
    private String gcaiIndi;

    /**
     * PROBATION_START
     */
    @Column(name = "PROBATION_START")
    private String probationStart;

    /**
     * PROBATION_REASON
     */
    @Column(name = "PROBATION_REASON")
    private String probationReason;

    /**
     * SIMPLE_HOLDBACK
     */
    @Column(name = "SIMPLE_HOLDBACK")
    private String simpleHoldback;

    /**
     * HOLDBACK_START
     */
    @Column(name = "HOLDBACK_START")
    private LocalDate holdbackStart;

    /**
     * HOLDBACK_END
     */
    @Column(name = "HOLDBACK_END")
    private LocalDate holdbackEnd;

    /**
     * PAYMENT_START
     */
    @Column(name = "PAYMENT_START")
    private LocalDate paymentStart;

    /**
     * INSTALLMENT_NUM
     */
    @Column(name = "INSTALLMENT_NUM")
    private String installmentNum;

    /**
     * TERMINATE_DATE
     */
    @Column(name = "TERMINATE_DATE")
    private LocalDate terminateDate;

    /**
     * GRADE_DATE
     */
    @Column(name = "GRADE_DATE")
    private LocalDate gradeDate;

    /**
     * TERMINATE_CLAUSE
     */
    @Column(name = "TERMINATE_CLAUSE")
    private String terminateClause;

    /**
     * DEPENDENT_INDI
     */
    @Column(name = "DEPENDENT_INDI")
    private String dependentIndi;

    /**
     * RECORDER_ID
     */
    @Column(name = "RECORDER_ID")
    private String recorderId;

    /**
     * EXPERIENCE INDI
     */
    @Column(name = "EXP_INDI", nullable = false)
    private String expIndi;

    /**
     * Complaint Handling/ Completion Date
     */
    @Column(name = "COMPLAINT_DATE")
    private LocalDate complaintDate;

    /**
     * Debt paid-off/Written-off Date
     */
    @Column(name = "PAIDOFF_DATE")
    private LocalDate paidoffDate;

    /**
     * Bankruptcy/Winding-up Legal Completion Date
     */
    @Column(name = "BANKRUPTCY_DATE")
    private LocalDate bankruptcyDate;

    /**
     * agent info replaced or not
     */
    @Column(name = "REPLACED")
    private String REPLACED;

    /**
     * Replace date
     */
    @Column(name = "REPLACE_DATE")
    private LocalDate replaceDate;

    /**
     * self-override indicator
     */
    @Column(name = "SELF_OVERRIDE_INDI", nullable = false)
    private String selfOverrideIndi;

    /**
     * Advisory Fee Agent Id
     */
    @Column(name = "AF_AGENT_ID")
    private String afAgentId;

    /**
     * Advisory Fee Effective Date
     */
    @Column(name = "AF_EFFECTIVE_DATE")
    private LocalDate afEffectiveDate;

    /**
     * [201801][CM-666] sms and email
     */
    @Column(name = "SMS_AND_EMAIL")
    private String smsAndEmail;

    /**
     * [201804][CM-685]Visa_Expiry_Date
     */
    @Column(name = "VISA_EXPIRY_DATE")
    private LocalDate visaExpiryDate;

    /**
     * [201804][CM-685]visa type
     */
    @Column(name = "VISA_TYPE")
    private String visaType;

    /**
     * [201804][CM-685]recruit type
     */
    @Column(name = "RECRUIT_TYPE")
    private String recruitType;

    /**
     * [201807][IFA Override Rates by PPP]Rate tier id
     */
    @Column(name = "RATE_TIER")
    private String rateTier;

    /**
     * [201807][IFA Override Rates by PPP]Rate tier effective date
     */
    @Column(name = "RATE_TIER_EFFECTIVE_DATE")
    private LocalDate rateTierEffectiveDate;

    @Column(name = "AGENT_ROLE")
    private String agentRole;

    @Column(name = "ROLE_EXPIRY_PERIOD")
    private LocalDate roleExpiryPeriod;

    /**
     * [201901][CM-704]DRAGON_NETWORK
     */
    @Column(name = "DRAGON_NETWORK")
    private String dragonNetwork;

    /**
     * [202007][Premier Business][Business line code
     */
    @Column(name = "BUSINESS_LINE_CODE")
    private String businessLineCode;

    /**
     * [202007][Premier Business]Channel anlysis code
     */
    @Column(name = "CHANNEL_ANLYSIS_CODE")
    private String channelAnlysisCode;

    /**
     * [202009][GL26]tr training
     */
    @Column(name = "TR_TRAINING")
    private String trTraining;

}
