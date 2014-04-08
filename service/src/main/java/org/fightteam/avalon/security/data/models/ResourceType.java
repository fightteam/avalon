package org.fightteam.avalon.security.data.models;

/**
 * 基于RBAC权限模型 资源定义
 *
 * @author faith
 * @since 0.0.1
 */
public enum ResourceType {

    URL, METHOD, ACL, MODULE;

    public String toString() {
        if (this == URL) return "URL限制";
        if (this == METHOD) return "方法限制";
        if (this == ACL) return "ACL限制";
        if (this == MODULE) return "模块限制";
        return super.toString();
    }
}
