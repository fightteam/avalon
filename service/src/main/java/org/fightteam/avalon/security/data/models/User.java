package org.fightteam.avalon.security.data.models;

import lombok.Getter;
import lombok.Setter;
import org.fightteam.join.dao.entity.AbstractEntity;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * RBAC权限模型 用户
 *
 * @author faith
 * @since 0.0.1
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "userType")
@DiscriminatorValue("user")
@Setter
@Getter
public class User extends AbstractEntity<Long> {

    private String username;
    private String password;
    private String email;
    // 账号是否过期(true 没过期 false 过期)
    private boolean accountNonExpired = true;
    // 账号 是否锁定(true 没锁定 false 锁定)
    private boolean accountNonLocked = true;
    // 证书是否过期 (true 没过期 false 过期)
    private boolean credentialsNonExpired = true;
    // 账号是否可用 (true 可以用 false 不可以用)
    private boolean enabled = true;
    // 用户注册时间
    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime registeTime;
    // 用户注册时ip
    private String ip;
    // 用户最近登录时间
    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime loginTime;
    // 用户最近注销时间
    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime logoutTime;
    // 最近一次用户登录ip
    private String loginIp;
    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime lastLogoutTime;
    // 默认密码时间 -1 表示不限制
    private Integer passwordExpiredDays = -1;
    // 更改密码时间
    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime passwordChangeTime;
    // 能否同时登录
    private boolean loginAtSameTime = false;
    // 登陆尝试次数
    private int loginAttempt = 0;
    // 记录用户状态 0:正常 1：锁定
    private int status = 0;
    // 记录用户状态问题
    private String problem;
    // 记录问题解决方法
    private String solution;

    // 用户角色
    @ManyToMany
    private List<Role> roles = new ArrayList<>();

    // 用户权限
    @ManyToMany
    private List<Permission> permissions = new ArrayList<>();

    @ManyToOne
    private RoleGroup roleGroup;
    @ManyToOne
    private PermissionGroup permissionGroup;


}
