package org.fightteam.avalon.core.util;

import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 重新载入spring配置
 * User: faith
 * Date: 13-8-13
 * Time: 下午12:55
 * 实现spring 环境刷新
 */
public class ReloadSpringContext {
    private static ReloadSpringContext ourInstance = new ReloadSpringContext();

    public static ReloadSpringContext getInstance() {
        return ourInstance;
    }

    private ReloadSpringContext() {
        //创建spring环境
        FileSystemXmlApplicationContext fileSystemXmlApplicationContext = new FileSystemXmlApplicationContext();
        fileSystemXmlApplicationContext.refresh();
    }
}
