package com.tiger.canstant;

/**
 * 接口请求类型
 *
 * @author wangheng
 * @date 2020-08-22
 */
public enum RequestType {

    /**
     * GET请求
     * <p>
     * 对应GetMapping
     */
    GET("GET"),

    /**
     * POST请求
     * <p>
     * 对应PostMapping
     */
    POST("POST"),

    /**
     * 不限制类型
     * <p>
     * 对应RequestMapping
     */
    ALL("GET/POST");

    RequestType(String desc) {
        this.desc = desc;
    }

    private final String desc;

    public String getDesc() {
        return this.desc;
    }
}
