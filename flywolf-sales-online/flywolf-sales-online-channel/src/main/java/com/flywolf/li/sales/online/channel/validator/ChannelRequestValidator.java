package com.flywolf.li.sales.online.channel.validator;

import com.flywolf.li.framework.validator.AbstractValidator;
import com.flywolf.li.sales.online.channel.dto.CreateChannelRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class ChannelRequestValidator extends AbstractValidator {

  @Override
  public boolean supports(Class<?> clazz) {
    return CreateChannelRequest.class.equals(clazz);
  }

 /* @Autowired
  ClaimCaseAcceptInputValidator claimCaseAcceptInputValidator;*/

  @Override
  public void validate(Object target, Errors errors) {
    CreateChannelRequest request = (CreateChannelRequest) target;
    rejectIfEmptyOrWhitespace(errors, "caseNo");
    rejectIfEmpty(errors, "claimCaseInfo");

    /*ClaimCaseAcceptInput caseInput = request.getClaimCaseInfo();
    if (caseInput != null) {
      errors.pushNestedPath("claimCaseInfo");
      ValidationUtils.invokeValidator(claimCaseAcceptInputValidator, caseInput, errors);
      errors.popNestedPath();
    }*/
  }

}
