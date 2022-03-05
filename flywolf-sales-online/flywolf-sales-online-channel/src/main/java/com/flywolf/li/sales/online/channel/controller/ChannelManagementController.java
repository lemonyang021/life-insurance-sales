package com.flywolf.li.sales.online.channel.controller;

import com.flywolf.li.framework.dto.ClientServiceResponse;
import com.flywolf.li.sales.online.channel.dto.CreateChannelRequest;
import com.flywolf.li.sales.online.channel.dto.CreateChannelResponse;
import com.flywolf.li.sales.online.channel.service.ChannelService;
import com.flywolf.li.sales.online.channel.validator.ChannelRequestValidator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@CrossOrigin
@RestController
@Api(tags = "Channel Management")
@RequestMapping(value = "/channel")
public class ChannelManagementController {

    @Autowired
    private ChannelService channelService;

    @Autowired
    private ChannelRequestValidator channelRequestValidator;

    @Autowired
    private ApplicationEventPublisher publisher;


    /**
     * 校验request内容是否合规
     *
     * @param binder
     */
    @InitBinder("channelRequest")
    public void initChannelRequestBinder(DataBinder binder) {
        binder.setValidator(channelRequestValidator);
    }


    @ApiOperation(value = "Create", notes = "Sales Channel Create", response = CreateChannelResponse.class)
    @RequestMapping(value = "/{insurerCode}/create", method = RequestMethod.POST)
    /*@ApiImplicitParams(value = {@ApiImplicitParam(name = ServiceInterceptor.TenantCodeKey,
            paramType = "header", dataType = "string", required = true)})*/
    public CreateChannelResponse create(@PathVariable("insurerCode") @ApiParam(value = "Insurer code") String insurerCode,
                                        @RequestBody @Validated CreateChannelRequest request, HttpServletRequest httpRequest,
                                        HttpServletResponse httpResponse, BindingResult result) {
        //.traceRequest(request);

        channelService.create(insurerCode, request);
        CreateChannelResponse response = new CreateChannelResponse();
        response.setResult(ClientServiceResponse.ServiceResultCode.SUCCEEDED);
        // CreateChannelEvent event = new CreateChannelEvent(new CreateChannelEventObject(request,response));
        // publisher.publishEvent(event);
        return response;
    }

   /* @ApiOperation(value = "ReAccept", notes = "Re-accept claim case after cancellation", response = com.ebao.li.mobs.agency.dto.CaseGenericResponse.class)
    @RequestMapping(value = "/{insurerCode}/reAccept", method = RequestMethod.POST)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @ApiImplicitParams(value = {@ApiImplicitParam(name = ServiceInterceptor.TenantCodeKey,
            paramType = "header", dataType = "string", required = true)})
    @ExternalDocs(url = "http://apidoc.ebaocloud.life/")
    public com.ebao.li.mobs.agency.dto.CaseGenericResponse reAccept(
            @PathVariable("insurerCode") @ApiParam(value = "Insurer code") String insurerCode,
            @RequestBody @Valid com.ebao.li.mobs.agency.dto.CaseReAcceptRequest request, HttpServletRequest httpRequest,
            HttpServletResponse httpResponse, BindingResult result) {
        ServiceHeader serviceHeader = serviceInterceptor.parseHeader(httpRequest, httpResponse);
        serviceInterceptor.traceRequest(request);
        return caseManageService.reAccept(serviceHeader, insurerCode, request);
    }

    @ApiOperation(value = "Approve", notes = "Claim Case Approve",
            response = com.ebao.li.mobs.agency.dto.CaseGenericResponse.class)
    @RequestMapping(value = "/{insurerCode}/approve", method = RequestMethod.POST)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @ApiImplicitParams(value = {@ApiImplicitParam(name = ServiceInterceptor.TenantCodeKey,
            paramType = "header", dataType = "string", required = true)})
    @ExternalDocs(url = "http://apidoc.ebaocloud.life/")
    public com.ebao.li.mobs.agency.dto.CaseGenericResponse approve(
            @PathVariable("insurerCode") @ApiParam(value = "Insurer code") String insurerCode,
            @RequestBody @Valid com.ebao.li.mobs.agency.dto.CaseApproveRequest request, HttpServletRequest httpRequest,
            HttpServletResponse httpResponse, BindingResult result) {
        ServiceHeader serviceHeader = serviceInterceptor.parseHeader(httpRequest, httpResponse);
        serviceInterceptor.traceRequest(request);
        return caseManageService.approve(serviceHeader, insurerCode, request);
    }

    @ApiOperation(value = "Cancel", notes = "Claim Case Cancel", response = com.ebao.li.mobs.agency.dto.CaseGenericResponse.class)
    @RequestMapping(value = "/{insurerCode}/cancel", method = RequestMethod.POST)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @ApiImplicitParams(value = {@ApiImplicitParam(name = ServiceInterceptor.TenantCodeKey,
            paramType = "header", dataType = "string", required = true)})
    @ExternalDocs(url = "http://apidoc.ebaocloud.life/")
    public com.ebao.li.mobs.agency.dto.CaseGenericResponse cancel(
            @PathVariable("insurerCode") @ApiParam(value = "Insurer code") String insurerCode,
            @RequestBody @Valid com.ebao.li.mobs.agency.dto.CaseCancelRequest request, HttpServletRequest httpRequest,
            HttpServletResponse httpResponse, BindingResult result) {
        ServiceHeader serviceHeader = serviceInterceptor.parseHeader(httpRequest, httpResponse);
        serviceInterceptor.traceRequest(request);
        return caseManageService.cancel(serviceHeader, insurerCode, request);
    }


    @RequestMapping(value = "/{insurerCode}/detail/{caseNo}", method = RequestMethod.GET)
    @ApiOperation(value = "Claim Case Detail Get", notes = "Claim Case Detail Get",
            httpMethod = "GET", response = com.ebao.li.mobs.agency.dto.ClaimCaseDetailResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @ApiImplicitParams(value = {@ApiImplicitParam(name = ServiceInterceptor.TenantCodeKey,
            paramType = "header", dataType = "string", required = true)})
    @ExternalDocs(url = "http://apidoc.ebaocloud.life/")
    public com.ebao.li.mobs.agency.dto.ClaimCaseDetailResponse get(
            @PathVariable("insurerCode") @ApiParam(value = "Insurer code") String insurerCode, @ApiParam(
            required = true, name = "caseNo", value = "案件号") @PathVariable("caseNo") String caseNo,
            HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        return caseManageService.get(serviceInterceptor.parseHeader(httpRequest, httpResponse),
                insurerCode, caseNo);
    }

    @ApiOperation(value = "Search", notes = "Claim Case Search",
            response = com.ebao.li.mobs.agency.dto.ClaimCaseQueryResponse.class)
    @RequestMapping(value = "/{insurerCode}/search", method = RequestMethod.POST)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @ApiImplicitParams(value = {@ApiImplicitParam(name = ServiceInterceptor.TenantCodeKey,
            paramType = "header", dataType = "string", required = true)})
    @ExternalDocs(url = "http://apidoc.ebaocloud.life/")
    public ClaimCaseQueryResponse search(@PathVariable("insurerCode") @ApiParam(
            value = "Insurer code") String insurerCode,
                                         @RequestBody @Valid com.ebao.li.mobs.agency.dto.ClaimCaseQueryRequest request, HttpServletRequest httpRequest,
                                         HttpServletResponse httpResponse, BindingResult result) {
        ServiceHeader serviceHeader = serviceInterceptor.parseHeader(httpRequest, httpResponse);
        serviceInterceptor.traceRequest(request);
        return caseManageService.search(serviceHeader, insurerCode, request);
    }*/
}
