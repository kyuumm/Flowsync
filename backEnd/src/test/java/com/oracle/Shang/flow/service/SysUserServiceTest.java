package com.oracle.Shang.flow.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.oracle.Shang.flow.domain.SysUser;
import com.oracle.Shang.flow.dto.LoginRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 类：SysUserServiceTest
 * 描述：TODO
 *
 * @author Shang
 * @version 1.0
 * @date 2026-07-14 09:40:06
 */
@SpringBootTest
public class SysUserServiceTest {
    @Autowired
    private SysUserService sysUserService;
    @Test
    public void testLogin() {
        //构建查询条件
        QueryWrapper<SysUser> qw = new QueryWrapper<>();
        qw.eq("username", "leader");
        qw.eq("password", "123456");
        SysUser user = sysUserService.getOne(qw);
        System.out.println(user);
    }
}
