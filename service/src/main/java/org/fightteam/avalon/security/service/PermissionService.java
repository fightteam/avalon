package org.fightteam.avalon.security.service;

import org.fightteam.avalon.security.data.models.Permission;
import org.springframework.security.access.ConfigAttribute;

import java.util.List;
import java.util.Map;

/**
 * 权限业务逻辑接口
 *
 * @author faith
 * @since 0.0.1
 */
public interface PermissionService {

    /**
     * 获取所有权限
     *
     * @return
     */
    Map<String, String> findAll();

    /**
     * 增加权限
     *
     * @param permission
     * @param resourceId
     */
    void addPermission(Permission permission, Long resourceId);


}
