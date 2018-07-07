package com.xgn.fzc;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2018-07-07
 * Time: 7:47 PM
 *
 * @author: MarkFan
 * @since v1.0.0
 */
public class MultipleDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> dataSourceKey = new InheritableThreadLocal<String>();


    public static void setDataSourceKey(String dataSource) {
        dataSourceKey.set(dataSource);
    }


    @Override
    protected Object determineCurrentLookupKey() {
        return dataSourceKey.get();
    }
}
