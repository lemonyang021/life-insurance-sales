package com.flywolf.li.framework.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum ResultCodeEnum {

    /**
     * 业务处理成功
     */
    SUCCESS("00000", "success"),
    /**
     * 参数错误
     */
    ILLEGAL_ARG("10000", "参数错误"),
    /**
     * 参数错误
     */
    P_ILLEGAL_ARG("10001", "参数错误，{0}"),

    /**
     * 业务异常
     */
    ERROR("20000", "业务异常"),
    /**
     * 尚未登录
     */
    NO_LOGIN("20001", "尚未登录"),
    /**
     * 没有权限访问该资源
     */
    UNAUTHORIZED("20002", "没有权限访问该资源"),
    /**
     * 资源不存在
     */
    RESOURCE_NOT_FOUND("20003", "资源不存在"),
    /**
     * 资源的当前状态不支持该操作
     */
    RESOURCE_NOT_SUPPORTED("20004", "资源的当前状态不支持该操作"),
    /**
     * 缺少必要的配置项
     */
    CONF_MISS("20005", "缺少必要的配置项"),
    /**
     * 业务处理失败
     */
    BUZ_ERROR("20006", "业务处理失败"),
    /**
     * 调用第三方接口失败
     */
    THIRD_ERROR("20007", "调用第三方接口失败"),
    /**
     * 资源已删除
     */
    RESOURCE_DELETED("20008", "资源已删除"),
    /**
     * 非法操作
     */
    ILLEGAL_OPERATION("20009", "非法操作"),
    /**
     * 持久层操作异常
     */
    REPOSITORY_ERROR("20010", "持久层操作异常"),
    /**
     * HSF调用异常
     */
    HSF_CONNECTION_ERR("20011", "HSF调用异常"),
    /**
     * Batch提交异常
     */
    BATCH_SUBMISSION_ERR("20012", "Batch提交异常"),
    /**
     * Batch执行异常
     */
    BATCH_EXEC_ERR("20013", "Batch执行异常"),
    /**
     * ONS消息发送异常
     */
    ONS_SEND_ERR("20014", "ONS消息发送异常"),
    /**
     * 初始化出错
     */
    INITIAL_ERR("20015", "初始化出错"),
    /**
     * 更新操作失败
     */
    UPDATE_ERROR("20016", "更新操作失败"),
    /**
     * 查询结果不存在
     */
    QUERY_RESULT_NULL("20017", "查询结果不存在"),
    /**
     * XML文件解析错误
     */
    XML_PARSE_ERROR("20018", "XML文件解析错误"),
    /**
     * 业务处理失败
     */
    P_BUZ_ERROR("20019", "业务处理失败，{0}"),

    /**
     * 系统繁忙
     */
    SYS_BUSY("30000", "系统繁忙"),

    /**
     * 方法未实现
     */
    METHOD_UN_IMPLEMENT("40000", "方法未实现"),

    /**
     * 系统异常
     */
    SYS_ERROR("90000", "系统异常"),
    /**
     * 系统维护中
     */
    SYS_MAINTAINING("90002", "系统维护中"),
    /**
     * 系统运行出错
     */
    SYS_RUNTIME_ERROR("90003", "系统运行出错"),
    /**
     * 系统初始化出错
     */
    SYS_INITIAL_ERROR("90004", "系统初始化出错"),
    ;

    private final String code;
    private final String desc;

    /**
     * 根据代码获取枚举
     *
     * @param code
     * @return RespCodeEnum
     */
    public static ResultCodeEnum getByCode(String code) {
        return Arrays.stream(values()).filter(v -> Objects.equals(code, v.getCode())).findAny().orElse(null);
    }
}
