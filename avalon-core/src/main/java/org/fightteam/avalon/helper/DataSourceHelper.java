package org.fightteam.avalon.helper;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.orm.jpa.vendor.Database;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 数据工具类,辅助生成实体工厂。
 *
 * @author excalibur
 * @since 0.0.1
 */
@Slf4j
public class DataSourceHelper {

    /**
     * 根据数据源的url判断是什么类型的数据库
     * @param dataSource
     * @return
     */
    public static Database getDatabase(DataSource dataSource){
        // 从DataSource中取出jdbcUrl.
        String jdbcUrl = null;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            if (connection == null) {
                throw new IllegalStateException("Connection returned by DataSource [" + dataSource + "] was null");
            }
            jdbcUrl = connection.getMetaData().getURL();
        } catch (SQLException e) {
            throw new RuntimeException("Could not get database url", e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                }
            }
        }
        System.out.println("************************************");
        System.out.println(jdbcUrl);
        // 根据jdbc url判断Database
        if (StringUtils.contains(jdbcUrl, ":h2:")) {
            return Database.H2;
        } else if (StringUtils.contains(jdbcUrl, ":mysql:")) {
            return Database.MYSQL;
        } else if (StringUtils.contains(jdbcUrl, ":oracle:")) {
            return Database.ORACLE;
        } else if (StringUtils.contains(jdbcUrl, ":hsqldb:")) {
            return Database.HSQL;
        } else {
            throw new IllegalArgumentException("Unknown Database of " + jdbcUrl);
        }
    }
}
