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
    GET("GET", "org.springframework.web.bind.annotation.GetMapping"),

    /**
     * POST请求
     * <p>
     * 对应PostMapping
     */
    POST("POST", "org.springframework.web.bind.annotation.PostMapping"),

    /**
     * 不限制类型
     * <p>
     * 对应RequestMapping
     */
    ALL("GET/POST", "org.springframework.web.bind.annotation.RequestMapping");

    private final String desc;

    private final String annotation;

    public String getDesc() {
        return this.desc;
    }

    public String getAnnotation() {
        return this.annotation;
    }


    RequestType(String desc, String annotation) {
        this.desc = desc;
        this.annotation = annotation;
    }
}
