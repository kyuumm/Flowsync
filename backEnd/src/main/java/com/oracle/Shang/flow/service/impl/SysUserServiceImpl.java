package com.oracle.Shang.flow.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oracle.Shang.flow.domain.SysUser;
import com.oracle.Shang.flow.service.SysUserService;
import com.oracle.Shang.flow.mapper.SysUserMapper;
import org.springframework.stereotype.Service;

/**
* @author kyuu
* @description 针对表【sys_user(用户表)】的数据库操作Service实现
* @createDate 2026-07-13 15:53:00
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService{

}




