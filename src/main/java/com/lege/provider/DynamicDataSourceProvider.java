package com.lege.provider;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @author lege
 * @Description
 * @create 2022-06-06 11:21
 */
public interface DynamicDataSourceProvider {

    String DEFAULT_DATASOURCE = "master";
    /**
     * 加载所有的数据源
     * @return
     */
    Map<String, DataSource> loadDataSources();
}
