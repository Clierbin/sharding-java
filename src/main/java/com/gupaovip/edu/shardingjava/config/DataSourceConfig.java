package com.gupaovip.edu.shardingjava.config;

import io.shardingjdbc.core.api.config.ShardingRuleConfiguration;
import io.shardingjdbc.core.api.config.TableRuleConfiguration;
import io.shardingjdbc.core.api.config.strategy.StandardShardingStrategyConfiguration;
import io.shardingjdbc.core.jdbc.core.datasource.ShardingDataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:DataSourceConfig
 * Package:com.gupaovip.edu.shardingjava.config
 * description
 * Created by zhangbin on 2019/11/11.
 *
 * @author: zhangbin q243132465@163.com
 * @Version 1.0.0
 * @CreateTime： 2019/11/11 11:28
 */
@Configuration
public class DataSourceConfig {

    @Bean
    @Primary
    public DataSource shardingDataSource() throws SQLException {
        ShardingRuleConfiguration src = new ShardingRuleConfiguration();
        // 默认的分库策略
        src.setDefaultDatabaseShardingStrategyConfig(new StandardShardingStrategyConfiguration("user_id", DBShardAlgo.class.getName()));
        // 默认的分表策略
        src.setDefaultTableShardingStrategyConfig(new StandardShardingStrategyConfiguration("user_id", TblPreShardAlgo.class.getName(),TblRangeShardAlgo.class.getName()));
        // 为user_info表设置分库分表策略,算法
        src.getTableRuleConfigs().add(getUserTableRuleConfiguration());
        // 数据源名和数据源的映射表
        return new ShardingDataSource(src.build(createDataSrouceMap()));
    }
    // 配置数据源
    private Map<String, DataSource> createDataSrouceMap() {
        HashMap<String, DataSource> dataSourceHashMap = new HashMap<>();
        dataSourceHashMap.put("ds0", createDataSrouce("jdbc:mysql://192.168.5.178:3306/ds0?characterEncoding=utf8&useSSL=false&serverTimezone=UTC"));
        dataSourceHashMap.put("ds1", createDataSrouce("jdbc:mysql://192.168.5.178:3306/ds1?characterEncoding=utf8&useSSL=false&serverTimezone=UTC"));
        return dataSourceHashMap;
    }
    // 根据数据源地址创建 DataSource
    private DataSource createDataSrouce(final String url) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("jhemr");
        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource shardingDataSource) {
        return new DataSourceTransactionManager(shardingDataSource);
    }

    private TableRuleConfiguration getUserTableRuleConfiguration() {
        TableRuleConfiguration tableRuleConfiguration = new TableRuleConfiguration();
        tableRuleConfiguration.setLogicTable("user_info");
        tableRuleConfiguration.setActualDataNodes("ds${0..1}.user_info");
        tableRuleConfiguration.setDatabaseShardingStrategyConfig(new StandardShardingStrategyConfiguration("user_id", DBShardAlgo.class.getName()));
        tableRuleConfiguration.setTableShardingStrategyConfig(new StandardShardingStrategyConfiguration("user_id", TblPreShardAlgo.class.getName(), TblRangeShardAlgo.class.getName()));
        return tableRuleConfiguration;
    }

}
