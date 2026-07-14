package com.oracle.Shang.flow.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.oracle.Shang.flow.domain.SysUser;
import com.oracle.Shang.flow.dto.LoginRequest;
import com.oracle.Shang.flow.entiy.User;
import com.oracle.Shang.flow.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import hgc.flowsyncapi.common.ApiResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 类：UserController
 * 描述：TODO
 *
 * @author Shang
 * @version 1.0
 * @date 2026-07-10 16:07:14
 */
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private SysUserService sysUserService;
    @PostMapping("/login")
    public ApiResponse<SysUser> login(@RequestBody LoginRequest loginRequest){
        QueryWrapper<SysUser> qw = new QueryWrapper<>();
        qw.eq("username", loginRequest.getUsername());
        qw.eq("password", loginRequest.getPassword());
        SysUser user = sysUserService.getOne(qw);
        if (user == null) {//登录失败
            return ApiResponse.fail("登录失败");
        }
        user.setPassword(null);//脱敏
        return ApiResponse.ok("登录成功",user);
    }

}
