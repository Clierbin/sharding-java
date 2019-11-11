package com.gupaovip.edu.shardingjava.service;

import com.gupaovip.edu.shardingjava.entity.UserInfoDO;

import java.util.List;

/**
 * ClassName:UserInfoService
 * Package:com.gupaovip.edu.shardingjava.service
 * description
 * Created by zhangbin on 2019/11/11.
 *
 * @author: zhangbin q243132465@163.com
 * @Version 1.0.0
 * @CreateTime： 2019/11/11 11:14
 */
public interface UserInfoService {
    int insert(UserInfoDO userInfoDO);

    List<UserInfoDO> getUserInfo();
}
