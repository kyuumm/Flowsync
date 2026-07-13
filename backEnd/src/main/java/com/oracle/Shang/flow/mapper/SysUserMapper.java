package com.oracle.Shang.flow.mapper;

import com.oracle.Shang.flow.domain.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author kyuu
* @description 针对表【sys_user(用户表)】的数据库操作Mapper
* @createDate 2026-07-13 15:53:00
* @Entity com.oracle.Shang.flow.domain.SysUser
*/
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

}




