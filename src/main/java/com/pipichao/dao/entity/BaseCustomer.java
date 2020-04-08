package com.pipichao.dao.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * base_customer
 * @author 
 */
@Data
public class BaseCustomer implements Serializable {
    /**
     * ID
     */
    private String customerNo;

    /**
     * 客户名称
     */
    private String name;

    /**
     * 地址
     */
    private String address;

    /**
     * 联系人
     */
    private String contact;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 部门片区
     */
    private String deptId;

    /**
     * 所属行业
     */
    private String trade;

    /**
     * 性质
     */
    private String nature;

    /**
     * 开户银行
     */
    private String bank;

    /**
     * 账号
     */
    private String account;

    /**
     * 税号
     */
    private String taxNum;

    /**
     * 备注
     */
    private String remark;

    /**
     * 删除标识
     */
    private Short deleteFlag;

    /**
     * 录入人id
     */
    private String opBy;

    /**
     * 操作日期
     */
    private Date opAt;

    private static final long serialVersionUID = 1L;
}