package com.pipichao.dao;

import com.pipichao.dao.entity.BaseCustomer;

public interface BaseCustomerDao {
    int deleteByPrimaryKey(String customerNo);

    int insert(BaseCustomer record);

    int insertSelective(BaseCustomer record);

    BaseCustomer selectByPrimaryKey(String customerNo);

    int updateByPrimaryKeySelective(BaseCustomer record);

    int updateByPrimaryKey(BaseCustomer record);
}