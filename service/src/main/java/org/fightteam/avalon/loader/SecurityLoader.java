package org.fightteam.avalon.loader;

import org.fightteam.avalon.security.data.OperationRepository;
import org.fightteam.avalon.security.data.PermissionRepository;
import org.fightteam.avalon.security.data.ResourceRepository;
import org.fightteam.avalon.security.data.RoleRepository;
import org.fightteam.avalon.security.data.models.Operation;
import org.fightteam.avalon.security.data.models.Permission;
import org.fightteam.avalon.security.data.models.Resource;
import org.fightteam.avalon.security.data.models.ResourceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 初始化数据库权限
 *
 * @author faith
 * @since 0.0.1
 */
@Component
public class SecurityLoader {
    private static Logger logger = LoggerFactory.getLogger(SecurityLoader.class);
    private static boolean isStart = false;

//    @Transactional
    public void loadData(){

//        if (resourceRepository.count() > 0){
//            return;
//        }
//
//        Operation getOperation = new Operation();
//        getOperation.setEnable(true);
//        getOperation.setName("GET");
//        getOperation.setTitle("GET操作");
//        getOperation.setDescription("URL资源GET操作,只有针对URL权限有用");
//        operationRepository.save(getOperation);
//
//        Operation postOperation = new Operation();
//        postOperation.setEnable(true);
//        postOperation.setName("POST");
//        postOperation.setTitle("POST操作");
//        postOperation.setDescription("URL资源POST操作,只有针对URL权限有用");
//        operationRepository.save(postOperation);
//
//        Operation putOperation = new Operation();
//        putOperation.setEnable(true);
//        putOperation.setName("PUT");
//        putOperation.setTitle("PUT操作");
//        putOperation.setDescription("URL资源PUT操作,只有针对URL权限有用");
//        operationRepository.save(putOperation);
//
//        Operation deleteOperation = new Operation();
//        deleteOperation.setEnable(true);
//        deleteOperation.setName("DELETE");
//        deleteOperation.setTitle("DELETE操作");
//        deleteOperation.setDescription("URL资源DELETE操作,只有针对URL权限有用");
//        operationRepository.save(deleteOperation);
//
//        Operation patchOperation = new Operation();
//        patchOperation.setEnable(true);
//        patchOperation.setName("PATCH");
//        patchOperation.setTitle("PATCH操作");
//        patchOperation.setDescription("URL资源PATCH操作,只有针对URL权限有用");
//        operationRepository.save(patchOperation);
//
//        Operation optionsOperation = new Operation();
//        optionsOperation.setEnable(true);
//        optionsOperation.setName("OPTIONS");
//        optionsOperation.setTitle("OPTIONS操作");
//        optionsOperation.setDescription("URL资源OPTIONS操作,只有针对URL权限有用");
//        operationRepository.save(optionsOperation);
//
//        Operation headOperation = new Operation();
//        headOperation.setEnable(true);
//        headOperation.setName("HEAD");
//        headOperation.setTitle("HEAD操作");
//        headOperation.setDescription("URL资源HEAD操作,只有针对URL权限有用");
//        operationRepository.save(headOperation);
//
//        Operation traceOperation = new Operation();
//        traceOperation.setEnable(true);
//        traceOperation.setName("TRACE");
//        traceOperation.setTitle("TRACE操作");
//        traceOperation.setDescription("URL资源TRACE操作,只有针对URL权限有用");
//        operationRepository.save(traceOperation);
//
//        // ============================================
//
//        Resource repositoryResource = new Resource();
//        repositoryResource.setEnable(true);
//        repositoryResource.setName("/*");
//        repositoryResource.setResourceType(ResourceType.URL);
//        repositoryResource.setTitle("Repository资源");
//        repositoryResource.setDescription("所有Repository资源，配合操作定义权限");
//        resourceRepository.save(repositoryResource);
//
//        Resource schemaResource = new Resource();
//        schemaResource.setEnable(true);
//        schemaResource.setName("/*/schema");
//        schemaResource.setResourceType(ResourceType.URL);
//        schemaResource.setTitle("Schema资源");
//        schemaResource.setDescription("所有Repository的Schema资源，配合操作定义权限，注意头信息只支持头信息application/schema+json");
//        resourceRepository.save(schemaResource);
//
//        Resource searchResource = new Resource();
//        searchResource.setEnable(true);
//        searchResource.setName("/*/search");
//        searchResource.setResourceType(ResourceType.URL);
//        searchResource.setTitle("Search资源");
//        searchResource.setDescription("所有Repository的Search资源，配合操作定义权限");
//        resourceRepository.save(searchResource);
//
//        Resource loginResource = new Resource();
//        loginResource.setEnable(true);
//        loginResource.setName("/login");
//        loginResource.setResourceType(ResourceType.URL);
//        loginResource.setTitle("登陆");
//        loginResource.setDescription("登陆系统的权限，配合操作定义权限，注意只支持POST");
//        resourceRepository.save(loginResource);
//
//        // ============================================
//
//        Permission getRepository = new Permission();
//        getRepository.setEnable(true);
//        getRepository.setName("GETRESPOSITORY");
//        getRepository.setTitle("Repository权限");
//        getRepository.setDescription("获取Repository的权限");
//        getRepository.setOperation(getOperation);
//        getRepository.setResource(repositoryResource);
//        permissionRepository.save(getRepository);


    }



}
