package org.fightteam.avalon.security.service.impl;

import org.fightteam.avalon.security.data.ResourceRepository;
import org.fightteam.avalon.security.data.models.Operation;
import org.fightteam.avalon.security.data.models.Permission;
import org.fightteam.avalon.security.data.models.Resource;
import org.fightteam.avalon.security.data.models.ResourceType;
import org.fightteam.avalon.security.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@Service
@Transactional
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    public Resource add(Resource resource) {
        return resourceRepository.save(resource);
    }

    @Override
    public Resource update(Resource resource) {
        return resourceRepository.save(resource);
    }

    @Override
    public void delete(Long id) {
        resourceRepository.delete(id);
    }

    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    @Override
    public Resource findById(Long id) {
        return resourceRepository.findOne(id);
    }

    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    @Override
    public Resource findByTitle(String title) {
        return resourceRepository.findByTitle(title);
    }

    @Override
    @Transactional(readOnly = true)
    public Map<String, String> findAllURL() {
        Map<String, String> map = new HashMap<>();
        List<Resource> resources = resourceRepository.findAll();
        for(Resource resource : resources){
            if (resource.getResourceType() != ResourceType.URL || !resource.isEnable()){
                continue;
            }
            StringBuffer requestMatcher = new StringBuffer("");
            StringBuffer configAttributes = null;

            List<Permission> permissions = resource.getPermissions();
            System.out.println(permissions);
            for(Permission permission : permissions){
                if (!permission.isEnable()){
                    continue;
                }
                Operation operation = permission.getOperation();
                if (!operation.isEnable()){
                    continue;
                }
                requestMatcher.append(resource.getName());
                requestMatcher.append(",");
                requestMatcher.append(operation.getName());

                String tmp = map.get(requestMatcher.toString());
                if (tmp == null){
                    configAttributes = new StringBuffer("");

                }else{
                    configAttributes = new StringBuffer(tmp);
                    configAttributes.append(",");
                }
                configAttributes.append(permission.getName());
                map.put(requestMatcher.toString(), configAttributes.toString());
            }

        }
        return map;
    }
}
