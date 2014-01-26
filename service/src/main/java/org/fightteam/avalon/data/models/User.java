package org.fightteam.avalon.data.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.hateoas.Identifiable;

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
public class User extends AbstractEntity<Long>{

    private String username;
    private String password;
    private String email;
    private String name;
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
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime registeTime;
    // 用户注册时ip
    private String ip;
    // 用户最近登录时间
    @Temporal(TemporalType.TIMESTAMP)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime loginTime;
    // 用户最近注销时间
    @Temporal(TemporalType.TIMESTAMP)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime logoutTime;
    // 最近一次用户登录ip
    private String loginIp;
    @Temporal(TemporalType.TIMESTAMP)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime lastLogoutTime;
    // 默认密码时间 -1 表示不限制
    private Integer passwordExpiredDays = -1;
    // 更改密码时间
    @Temporal(TemporalType.TIMESTAMP)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public DateTime getRegisteTime() {
        return registeTime;
    }

    public void setRegisteTime(DateTime registeTime) {
        this.registeTime = registeTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public DateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(DateTime loginTime) {
        this.loginTime = loginTime;
    }

    public DateTime getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(DateTime logoutTime) {
        this.logoutTime = logoutTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public DateTime getLastLogoutTime() {
        return lastLogoutTime;
    }

    public void setLastLogoutTime(DateTime lastLogoutTime) {
        this.lastLogoutTime = lastLogoutTime;
    }

    public Integer getPasswordExpiredDays() {
        return passwordExpiredDays;
    }

    public void setPasswordExpiredDays(Integer passwordExpiredDays) {
        this.passwordExpiredDays = passwordExpiredDays;
    }

    public DateTime getPasswordChangeTime() {
        return passwordChangeTime;
    }

    public void setPasswordChangeTime(DateTime passwordChangeTime) {
        this.passwordChangeTime = passwordChangeTime;
    }

    public boolean isLoginAtSameTime() {
        return loginAtSameTime;
    }

    public void setLoginAtSameTime(boolean loginAtSameTime) {
        this.loginAtSameTime = loginAtSameTime;
    }

    public int getLoginAttempt() {
        return loginAttempt;
    }

    public void setLoginAttempt(int loginAttempt) {
        this.loginAttempt = loginAttempt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
