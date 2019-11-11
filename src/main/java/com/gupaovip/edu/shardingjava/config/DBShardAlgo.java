package com.gupaovip.edu.shardingjava.config;

import io.shardingjdbc.core.api.algorithm.sharding.PreciseShardingValue;
import io.shardingjdbc.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

import java.util.Collection;

/**
 * ClassName:DBShardAlgo
 * Package:com.gupaovip.edu.shardingjava.config
 * description
 * Created by zhangbin on 2019/11/11.
 * 数据库分库的策略,根据分片键,返回数据库名称
 * @author: zhangbin q243132465@163.com
 * @Version 1.0.0
 * @CreateTime： 2019/11/11 11:22
 */
public class DBShardAlgo implements PreciseShardingAlgorithm<Long> {
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
        String db_name = "ds";
        Long num = preciseShardingValue.getValue() % 2;
        db_name = db_name + num;
        System.out.println("-----------------------db_name: " + db_name);

        for (String each : collection) {
            System.out.println("ds:"+each);
            if (each.equals(db_name)){
                return each;
            }
        }
        throw new IllegalArgumentException();
    }
}
