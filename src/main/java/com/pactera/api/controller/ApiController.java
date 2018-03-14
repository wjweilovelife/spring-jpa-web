package com.pactera.api.controller;

import com.pactera.api.service.UserService;
import com.pactera.entity.seckillentity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author wjwei
 */
@Controller
@RequestMapping("/api/home")
@Api(value = "用户controller",description = "用户相关操作")
public class ApiController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/queryUserList",method = RequestMethod.GET)
    @ApiOperation(value = "集合",notes = "返回用户集合")
    public List<User> queryUserList(){
        return userService.queryUserList();
    }
}

