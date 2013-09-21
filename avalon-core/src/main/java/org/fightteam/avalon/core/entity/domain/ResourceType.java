package org.fightteam.avalon.core.entity.domain;

/**
 * 系统资源类型泛型
 *
 * ACL并未使用，但是为了扩展定义了
 *
 * @author excalibur
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
