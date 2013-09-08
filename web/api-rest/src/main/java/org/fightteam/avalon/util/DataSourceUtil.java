package org.fightteam.avalon.util;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.dialect.H2Dialect;
import org.hibernate.dialect.MySQL5InnoDBDialect;
import org.hibernate.dialect.Oracle10gDialect;
import org.springframework.orm.jpa.vendor.Database;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 数据工具类
 * User: excalibur
 * Date: 13-9-7
 * Time: 下午3:25
 * To change this template use File | Settings | File Templates.
 */
public class DataSourceUtil {

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
        // 根据jdbc url判断Database
        if (StringUtils.contains(jdbcUrl, ":h2:")) {
            return Database.H2;
        } else if (StringUtils.contains(jdbcUrl, ":mysql:")) {
            return Database.MYSQL;
        } else if (StringUtils.contains(jdbcUrl, ":oracle:")) {
            return Database.ORACLE;
        } else {
            throw new IllegalArgumentException("Unknown Database of " + jdbcUrl);
        }
    }
}
