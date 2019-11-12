package com.gupaovip.edu.shardingjava.config;

import com.google.common.collect.Range;
import io.shardingjdbc.core.api.algorithm.sharding.RangeShardingValue;
import io.shardingjdbc.core.api.algorithm.sharding.standard.RangeShardingAlgorithm;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * ClassName:TblRangeShardAlgo
 * Package:com.gupaovip.edu.shardingjava.config
 * description
 * Created by zhangbin on 2019/11/11.
 * 范围查询所使用的分片算法
 * @author: zhangbin q243132465@163.com
 * @Version 1.0.0
 * @CreateTime： 2019/11/11 15:07
 */
public class TblRangeShardAlgo implements RangeShardingAlgorithm<Long> {
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<Long> rangeShardingValue) {
        System.out.println("范围_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*___________________"+availableTargetNames);
        System.out.println("范围_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*___________________"+rangeShardingValue);
        Collection<String> collect = new LinkedHashSet<>();
        Range<Long> valueRange = rangeShardingValue.getValueRange();
        for (Long i = valueRange.lowerEndpoint(); i <= valueRange.upperEndpoint(); i++) {
            for (String each : availableTargetNames) {
                if (each.endsWith(i % availableTargetNames.size() + "")) {
                    collect.add(each);
                }
            }
        }
        //
        return collect;
    }
}