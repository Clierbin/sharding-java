package com.gupaovip.edu.shardingjava.dao;

import com.gupaovip.edu.shardingjava.entity.UserInfoDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfoMapper {
    /**
     *
     * @mbg.generated Mon Nov 11 11:12:49 CST 2019
     */
    int deleteByPrimaryKey(Long userId);

    /**
     *
     * @mbg.generated Mon Nov 11 11:12:49 CST 2019
     */
    int insert(UserInfoDO record);

    /**
     *
     * @mbg.generated Mon Nov 11 11:12:49 CST 2019
     */
    int insertSelective(UserInfoDO record);

    /**
     *
     * @mbg.generated Mon Nov 11 11:12:49 CST 2019
     */
    UserInfoDO selectByPrimaryKey(Long userId);

    /**
     *
     * @mbg.generated Mon Nov 11 11:12:49 CST 2019
     */
    int updateByPrimaryKeySelective(UserInfoDO record);

    /**
     *
     * @mbg.generated Mon Nov 11 11:12:49 CST 2019
     */
    int updateByPrimaryKey(UserInfoDO record);

    List<UserInfoDO> getAll();
}