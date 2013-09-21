package org.fightteam.avalon.config;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 数据连接变量
 * User: excalibur
 * Date: 13-9-7
 * Time: 下午4:15
 *
 */
@Component
@PropertySource("classpath:/props/application.properties")
public class ApplicationConstant {

//    @Setter(onMethod = @_(@Value("${dataSource.driverClassName}")))
//    public static String driver;
//
//    @Setter(onMethod = @_(@Value("${dataSource.url}")))
//    public static String url;
//
//    @Setter(onMethod = @_(@Value("${dataSource.username}")))
//    public static String username;
//
//    @Setter(onMethod = @_(@Value("${dataSource.password}")))
//    public static String password;
//
//    //@Setter(onMethod = @_(@Value("${hibernate.generateddl}")))
//    public static boolean generateDdl = true;
//
//    @Setter(onMethod = @_(@Value("${hibernate.hbm2ddl.auto}")))
//    public static String hbm2ddlAuto;


}
