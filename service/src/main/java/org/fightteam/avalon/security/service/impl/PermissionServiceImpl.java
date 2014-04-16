package org.fightteam.avalon.security.service.impl;

import org.fightteam.avalon.security.data.PermissionRepository;
import org.fightteam.avalon.security.data.ResourceRepository;
import org.fightteam.avalon.security.data.models.Permission;
import org.fightteam.avalon.security.data.models.Resource;
import org.fightteam.avalon.security.service.PermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 权限业务逻辑实现
 *
 * @author faith
 * @since 0.0.1
 */
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {
    private static final Logger log = LoggerFactory.getLogger(PermissionServiceImpl.class);

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private ResourceRepository resourceRepository;




    @Override
    public void addPermission(Permission permission, Long resourceId) {

        Resource resource = new Resource();
        resource.setId(resourceId);

//        permission.setResource(resource);
        permissionRepository.save(permission);
    }

    @Override
    public Map<String, String> findAll() {
        List<Resource> resources = resourceRepository.findAll();
        for(Resource resource : resources){
            System.out.println(resource.getName());
            for(Permission permission : resource.getPermissions()){
                System.out.println(permission.getId());
                System.out.println(permission.getName());
            }
        }
        return null;
    }
}