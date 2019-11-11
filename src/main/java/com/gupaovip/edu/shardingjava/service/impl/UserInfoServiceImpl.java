package com.gupaovip.edu.shardingjava.service.impl;

import com.gupaovip.edu.shardingjava.dao.UserInfoMapper;
import com.gupaovip.edu.shardingjava.entity.UserInfoDO;
import com.gupaovip.edu.shardingjava.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:UserInfoServiceImpl
 * Package:com.gupaovip.edu.shardingjava.service.impl
 * description
 * Created by zhangbin on 2019/11/11.
 *
 * @author: zhangbin q243132465@163.com
 * @Version 1.0.0
 * @CreateTime： 2019/11/11 11:14
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;


    @Override
    public List<UserInfoDO> getUserInfo() {
        return userInfoMapper.getAll();
    }

    @Override
    public int insert(UserInfoDO userInfoDO) {
        return userInfoMapper.insert(userInfoDO);
    }
}
