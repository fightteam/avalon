package org.fightteam.avalon.core.entity.domain;

/**
 * 系统资源类型泛型
 * User: faith
 * Date: 13-7-1
 * Time: 下午6:01
 * ACL并未使用，但是为了扩展定义了
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
