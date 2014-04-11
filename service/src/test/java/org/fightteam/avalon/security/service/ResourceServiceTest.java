package org.fightteam.avalon.security.service;

import org.fightteam.avalon.SpringTest;
import org.fightteam.avalon.security.data.*;
import org.fightteam.avalon.security.data.models.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.util.FieldUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public class ResourceServiceTest extends SpringTest {

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private PermissionGroupRepository permissionGroupRepository;

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleGroupRepository roleGroupRepository;

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
        if (resourceRepository.count() > 0){
            return;
        }

        Operation getOperation = new Operation();
        getOperation.setEnable(true);
        getOperation.setName("GET");
        getOperation.setTitle("GET操作");
        getOperation.setDescription("URL资源GET操作,只有针对URL权限有用");
        operationRepository.save(getOperation);

        Operation postOperation = new Operation();
        postOperation.setEnable(true);
        postOperation.setName("POST");
        postOperation.setTitle("POST操作");
        postOperation.setDescription("URL资源POST操作,只有针对URL权限有用");
        operationRepository.save(postOperation);

        Operation putOperation = new Operation();
        putOperation.setEnable(true);
        putOperation.setName("PUT");
        putOperation.setTitle("PUT操作");
        putOperation.setDescription("URL资源PUT操作,只有针对URL权限有用");
        operationRepository.save(putOperation);

        Operation deleteOperation = new Operation();
        deleteOperation.setEnable(true);
        deleteOperation.setName("DELETE");
        deleteOperation.setTitle("DELETE操作");
        deleteOperation.setDescription("URL资源DELETE操作,只有针对URL权限有用");
        operationRepository.save(deleteOperation);

        Operation patchOperation = new Operation();
        patchOperation.setEnable(true);
        patchOperation.setName("PATCH");
        patchOperation.setTitle("PATCH操作");
        patchOperation.setDescription("URL资源PATCH操作,只有针对URL权限有用");
        operationRepository.save(patchOperation);

        Operation optionsOperation = new Operation();
        optionsOperation.setEnable(true);
        optionsOperation.setName("OPTIONS");
        optionsOperation.setTitle("OPTIONS操作");
        optionsOperation.setDescription("URL资源OPTIONS操作,只有针对URL权限有用");
        operationRepository.save(optionsOperation);

        Operation headOperation = new Operation();
        headOperation.setEnable(true);
        headOperation.setName("HEAD");
        headOperation.setTitle("HEAD操作");
        headOperation.setDescription("URL资源HEAD操作,只有针对URL权限有用");
        operationRepository.save(headOperation);

        Operation traceOperation = new Operation();
        traceOperation.setEnable(true);
        traceOperation.setName("TRACE");
        traceOperation.setTitle("TRACE操作");
        traceOperation.setDescription("URL资源TRACE操作,只有针对URL权限有用");
        operationRepository.save(traceOperation);

        // ============================================

        Resource repositoryResource = new Resource();
        repositoryResource.setEnable(true);
        repositoryResource.setName("/*");
        repositoryResource.setResourceType(ResourceType.URL);
        repositoryResource.setTitle("Repository资源");
        repositoryResource.setDescription("所有Repository资源，配合操作定义权限");
        resourceRepository.save(repositoryResource);

        Resource schemaResource = new Resource();
        schemaResource.setEnable(true);
        schemaResource.setName("/*/schema");
        schemaResource.setResourceType(ResourceType.URL);
        schemaResource.setTitle("Schema资源");
        schemaResource.setDescription("所有Repository的Schema资源，配合操作定义权限，注意头信息只支持头信息application/schema+json");
        resourceRepository.save(schemaResource);

        Resource searchResource = new Resource();
        searchResource.setEnable(true);
        searchResource.setName("/*/search");
        searchResource.setResourceType(ResourceType.URL);
        searchResource.setTitle("Search资源");
        searchResource.setDescription("所有Repository的Search资源，配合操作定义权限");
        resourceRepository.save(searchResource);

        Resource loginResource = new Resource();
        loginResource.setEnable(true);
        loginResource.setName("/login");
        loginResource.setResourceType(ResourceType.URL);
        loginResource.setTitle("登陆");
        loginResource.setDescription("登陆系统的权限，配合操作定义权限，注意只支持POST");
        resourceRepository.save(loginResource);


        Resource indexResource = new Resource();
        indexResource.setEnable(true);
        indexResource.setName("/");
        indexResource.setResourceType(ResourceType.URL);
        indexResource.setTitle("首页");
        indexResource.setDescription("首页的权限，配合操作定义权限，注意只支持GET");
        resourceRepository.save(indexResource);
        // ============================================

        Permission getRepository = new Permission();
        getRepository.setEnable(true);
        getRepository.setName("GETRESPOSITORY");
        getRepository.setDefinition("hasAuthority([GETRESPOSITORY])");
        getRepository.setTitle("Repository权限");
        getRepository.setDescription("获取Repository的权限");
        getRepository.setOperation(getOperation);
        getRepository.setResource(repositoryResource);
        permissionRepository.save(getRepository);

        Permission getIndex = new Permission();
        getIndex.setEnable(true);

        getIndex.setDefinition("permitAll()");
        getIndex.setTitle("首页权限");
        getIndex.setDescription("查看首页的权限");
        getIndex.setOperation(getOperation);
        getIndex.setResource(indexResource);
        permissionRepository.save(getIndex);

        Role admin = new Role();
        admin.setTitle("管理员");
        admin.setName("ADMIN");
        admin.setDefinition("hasRole([ADMIN])");
        admin.setDescription("管理员可以进行登录后台进行用户、角色管理、权限管理等等");
        List<Permission> permissions = new ArrayList<>();
        permissions.add(getRepository);
        admin.setPermissions(permissions);
        roleRepository.save(admin);

        Role sysAdmin = new Role();
        sysAdmin.setTitle("系统管理员");
        sysAdmin.setName("SYSTEM_ADMIN");
        sysAdmin.setDefinition("hasRole([SYSTEM_ADMIN])");
        sysAdmin.setDescription("系统管理员可以进行管理员的操作，还能进行资源，操作的管理");

        RoleGroup manager = new RoleGroup();
        manager.setTitle("管理组");
        manager.setName("MANAGER");

        roleGroupRepository.save(manager);

        sysAdmin.setRoleGroup(manager);
        roleRepository.save(sysAdmin);


        User faith = new User();
        faith.setPassword("123456");
        faith.setUsername("faith");
        faith.setRoleGroup(manager);

        userRepository.save(faith);
    }

    @Test
    public void test01() throws Exception {
//        resourceService.add();
        Map<String, String> map = resourceService.findAllURL();

        for(String k : map.keySet()){
            System.out.println(k);
            System.out.println(map.get(k));
        }

    }
}
