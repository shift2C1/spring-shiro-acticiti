package com.pipichao.web;

import com.pipichao.dao.BaseCustomerDao;
import com.pipichao.dao.entity.BaseCustomer;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.servlet.ShiroFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class TestHandler {
    @Autowired
    private BaseCustomerDao baseCustomerDao;
    @RequestMapping("index")
    @ResponseBody
    public BaseCustomer index(){
        BaseCustomer baseCustomer = baseCustomerDao.selectByPrimaryKey("KH20200317KH4");
        System.out.println(baseCustomer);
        return baseCustomer;
    }
    @PostMapping("subLogin")
    @ResponseBody
    public String subLogin(@RequestParam("username")String username,@RequestParam("password") String password){
        log.info("login....");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken();
        token.setUsername(username);
        token.setPassword(password.toCharArray());
        subject.login(token);
        return "success";
    }
    @ResponseBody
    @RequestMapping("test")
    @RequiresRoles("admin1")//如果过滤器配置了需要权限，这里注解也配置了权限，则shiro会验证两次
    public String test(){

        log.info("testing...");

        return "testing...";
    }
}
