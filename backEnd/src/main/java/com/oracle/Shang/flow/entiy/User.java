package com.oracle.Shang.flow.entiy;

import jdk.jfr.DataAmount;
import lombok.Data;

/**
 * 类：User
 * 描述：TODO
 *
 * @author Shang
 * @version 1.0
 * @date 2026-07-10 11:20:56
 */
@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String realname;
}
