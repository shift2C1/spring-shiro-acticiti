package com.pipichao.web;

import com.alibaba.fastjson.JSONObject;
import com.pipichao.vo.LoginVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@Slf4j
@RestController
public class UserController {
    @PostMapping("/login")
    public String userLogin(@RequestBody LoginVo loginVo){
        JSONObject resp=new JSONObject();
        System.out.println(loginVo.toString());
        UsernamePasswordToken token =new UsernamePasswordToken();
        Subject subject = SecurityUtils.getSubject();
        token.setUsername(loginVo.getUsername());
        token.setPassword(loginVo.getPassword().toCharArray());
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            resp.put("msg",e.getMessage());
            resp.put("code","1");
            return resp.toJSONString();
        }

        resp.put("msg","success");
        resp.put("code","0");
//        resp.put("data","");///将来存放用户的菜单权限角色的数据
        return resp.toJSONString();
    }

    @PostMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        log.info(subject.getPrincipals()+":退出");
        subject.logout();
        JSONObject resp =new JSONObject();
        resp.put("code","0");
        resp.put("msg","退出成功");
        return resp.toJSONString();
    }

}
