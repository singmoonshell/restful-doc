package com.tiger.definition;

import java.util.List;

/**
 * 属性
 *
 * @author wangheng
 * @date 2020-08-22
 */
public class FieldDefinition {

    /**
     * 属性名字
     */
    private String name;

    /**
     * 描述
     */
    private String desc;

    /**
     * 类型
     */
    private String type;

    /**
     * 是否必须
     */
    private boolean require;

    /**
     * 层级
     */
    private Integer layer;

    /**
     * 子结构
     */
    private List<FieldDefinition> subFieldDefinitions;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isRequire() {
        return require;
    }

    public void setRequire(boolean require) {
        this.require = require;
    }

    public Integer getLayer() {
        return layer;
    }

    public void setLayer(Integer layer) {
        this.layer = layer;
    }

    public List<FieldDefinition> getSubFieldDefinitions() {
        return subFieldDefinitions;
    }

    public void setSubFieldDefinitions(List<FieldDefinition> subFieldDefinitions) {
        this.subFieldDefinitions = subFieldDefinitions;
    }
}
