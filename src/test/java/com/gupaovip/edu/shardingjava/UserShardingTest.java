package com.gupaovip.edu.shardingjava;

import com.gupaovip.edu.shardingjava.entity.UserInfoDO;
import com.gupaovip.edu.shardingjava.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * ClassName:UserShardingTest
 * Package:com.gupaovip.edu.shardingjava
 * description
 * Created by zhangbin on 2019/11/11.
 *
 * @author: zhangbin q243132465@163.com
 * @Version 1.0.0
 * @CreateTime： 2019/11/11 15:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserShardingTest {
    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void insert(){
        UserInfoDO userInfoDO = new UserInfoDO();
        userInfoDO.setUserId(1L);
        userInfoDO.setUserName("StringUtils.EMPTY");
        userInfoDO.setAccount("zhangbin");
        userInfoDO.setPassword("jhemr");
        int result = userInfoService.insert(userInfoDO);
    }

    @Test
    public void select(){
        List<UserInfoDO> userInfoList = userInfoService.getUserInfo();
        for (UserInfoDO userInfoDO : userInfoList) {
            System.out.println(userInfoDO);
        }
    }
}
