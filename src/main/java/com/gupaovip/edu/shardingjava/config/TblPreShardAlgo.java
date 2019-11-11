package com.gupaovip.edu.shardingjava.config;

import io.shardingjdbc.core.api.algorithm.sharding.PreciseShardingValue;
import io.shardingjdbc.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

import java.util.Collection;

/**
 * ClassName:TblPreShardAlgo
 * Package:com.gupaovip.edu.shardingjava.config
 * description
 * Created by zhangbin on 2019/11/11.
 * 等值查询使用的分片算法，包括in
 * @author: zhangbin q243132465@163.com
 * @Version 1.0.0
 * @CreateTime： 2019/11/11 11:36
 */
public class TblPreShardAlgo implements PreciseShardingAlgorithm<Long> {
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
        // 不分表
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-availableTargetNames:" + availableTargetNames);
        for (String tbname : availableTargetNames) {
            return tbname;
        }
        throw new IllegalArgumentException();
    }
}
