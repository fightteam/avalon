package org.fightteam.avalon.web.config;

/**
 * 程序URI全局定义
 * User: faith
 * Date: 13-7-3
 * Time: 上午11:17
 * 包括了全部的URI
 * 为了方便基于URI的权限和修改方便
 */
public final class Router {
    //============admin routers================
    public final static String dashboard = "/dashboard";
    public final static String login = "/login";

    // user
    public final static String userManager ="/users";

    // role
    public final static String roleManager ="/roles";

    // authority
    public final static String authorityManager ="/authorities";

    // resource
    public final static String resourceManager ="/resources";

    // article
    public final static String articleManager ="/articles";
}
