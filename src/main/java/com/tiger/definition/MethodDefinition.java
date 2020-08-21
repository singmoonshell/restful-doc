package com.tiger.definition;


import com.tiger.canstant.RequestType;

import java.util.List;

/**
 * 方法
 *
 * @author wangheng
 * @date 2020-08-22
 */
public class MethodDefinition {

    /**
     * 方法名
     */
    private String methodName;

    /**
     * 方法描述
     */
    private String desc;

    /**
     * 请求类型
     */
    private RequestType requestType;

    /**
     * url
     */
    private String url;

    /**
     * 请求参数
     */
    private List<FieldDefinition> request;

    /**
     * 返回值
     */
    private List<FieldDefinition> response;


    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<FieldDefinition> getRequest() {
        return request;
    }

    public void setRequest(List<FieldDefinition> request) {
        this.request = request;
    }

    public List<FieldDefinition> getResponse() {
        return response;
    }

    public void setResponse(List<FieldDefinition> response) {
        this.response = response;
    }
}
