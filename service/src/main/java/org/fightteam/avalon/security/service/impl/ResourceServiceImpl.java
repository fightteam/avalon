package org.fightteam.avalon.security.service.impl;

import org.fightteam.avalon.data.ConsumerRepository;
import org.fightteam.avalon.data.ManagerRepository;
import org.fightteam.avalon.data.models.Consumer;
import org.fightteam.avalon.data.models.Manager;
import org.fightteam.avalon.security.data.*;
import org.fightteam.avalon.security.data.models.*;
import org.fightteam.avalon.security.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
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

    private final static String ROLE_prefix = "hasRole";
    private final static String PERMISSION_EXPRESSION = "hasAuthority";

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

    @Autowired
    private ConsumerRepository consumerRepository;

    @Autowired
    private ManagerRepository managerRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init(){
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

        Resource userRepositoryResource = new Resource();
        userRepositoryResource.setEnable(true);
        userRepositoryResource.setName("/users");
        userRepositoryResource.setResourceType(ResourceType.URL);
        userRepositoryResource.setTitle("用户Repository资源");
        userRepositoryResource.setDescription("用户Repository资源，配合操作定义权限，主要是GET和POST");
        resourceRepository.save(userRepositoryResource);

        Resource roleRepositoryResource = new Resource();
        roleRepositoryResource.setEnable(true);
        roleRepositoryResource.setName("/roles");
        roleRepositoryResource.setResourceType(ResourceType.URL);
        roleRepositoryResource.setTitle("角色Repository资源");
        roleRepositoryResource.setDescription("角色Repository资源，配合操作定义权限，主要是GET和POST");
        resourceRepository.save(roleRepositoryResource);

        Resource roleGroupRepositoryResource = new Resource();
        roleGroupRepositoryResource.setEnable(true);
        roleGroupRepositoryResource.setName("/rolesGroups");
        roleGroupRepositoryResource.setResourceType(ResourceType.URL);
        roleGroupRepositoryResource.setTitle("用户组Repository资源");
        roleGroupRepositoryResource.setDescription("用户组Repository资源，配合操作定义权限，主要是GET和POST");
        resourceRepository.save(roleGroupRepositoryResource);

        Resource permissionRepositoryResource = new Resource();
        permissionRepositoryResource.setEnable(true);
        permissionRepositoryResource.setName("/permissions");
        permissionRepositoryResource.setResourceType(ResourceType.URL);
        permissionRepositoryResource.setTitle("权限Repository资源");
        permissionRepositoryResource.setDescription("权限Repository资源，配合操作定义权限，主要是GET和POST");
        resourceRepository.save(permissionRepositoryResource);

        Resource permissionGroupRepositoryResource = new Resource();
        permissionGroupRepositoryResource.setEnable(true);
        permissionGroupRepositoryResource.setName("/permissionGroups");
        permissionGroupRepositoryResource.setResourceType(ResourceType.URL);
        permissionGroupRepositoryResource.setTitle("权限组Repository资源");
        permissionGroupRepositoryResource.setDescription("权限组Repository资源，配合操作定义权限，主要是GET和POST");
        resourceRepository.save(permissionGroupRepositoryResource);


        Resource resourceRepositoryResource = new Resource();
        resourceRepositoryResource.setEnable(true);
        resourceRepositoryResource.setName("/resources");
        resourceRepositoryResource.setResourceType(ResourceType.URL);
        resourceRepositoryResource.setTitle("资源Repository资源");
        resourceRepositoryResource.setDescription("资源Repository资源，配合操作定义权限，主要是GET和POST");
        resourceRepository.save(resourceRepositoryResource);

        Resource opterationRepositoryResource = new Resource();
        opterationRepositoryResource.setEnable(true);
        opterationRepositoryResource.setName("/operations");
        opterationRepositoryResource.setResourceType(ResourceType.URL);
        opterationRepositoryResource.setTitle("操作Repository资源");
        opterationRepositoryResource.setDescription("操作Repository资源，配合操作定义权限，主要是GET和POST");
        resourceRepository.save(opterationRepositoryResource);


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


        Resource registerResource = new Resource();
        registerResource.setEnable(true);
        registerResource.setName("/register");
        registerResource.setResourceType(ResourceType.URL);
        registerResource.setTitle("注册");
        registerResource.setDescription("注册权限，配合操作定义权限，注意只支持POST");
        resourceRepository.save(registerResource);


        // ============================================

        Permission getRepository = new Permission();
        getRepository.setEnable(true);
        getRepository.setName("GETRESPOSITORY");
        getRepository.setDefinition("hasAuthority('GETRESPOSITORY')");
        getRepository.setTitle("Repository权限");
        getRepository.setDescription("获取Repository的权限");
        getRepository.setOperation(getOperation);
        List<Resource> resources = new ArrayList<>();
        resources.add(userRepositoryResource);
        resources.add(roleRepositoryResource);
        resources.add(roleGroupRepositoryResource);
        resources.add(permissionRepositoryResource);
        resources.add(permissionGroupRepositoryResource);
        resources.add(opterationRepositoryResource);
        resources.add(resourceRepositoryResource);
        getRepository.setResources(resources);
        permissionRepository.save(getRepository);

        Permission getIndex = new Permission();
        getIndex.setDefinition("permitAll()");
        getIndex.setTitle("首页权限");
        getIndex.setDescription("查看首页的权限");
        getIndex.setOperation(getOperation);
        resources = new ArrayList<>();
        resources.add(indexResource);
        getIndex.setResources(resources);
        permissionRepository.save(getIndex);

        Permission login = new Permission();
        login.setDefinition("permitAll()");
        login.setTitle("登陆权限");
        login.setDescription("登陆的权限");
        login.setOperation(postOperation);
        resources = new ArrayList<>();
        resources.add(loginResource);
        login.setResources(resources);

        permissionRepository.save(login);

        Permission register = new Permission();
        register.setDefinition("permitAll()");
        register.setTitle("注册权限");
        register.setDescription("注册的权限");
        register.setOperation(postOperation);
        resources = new ArrayList<>();
        resources.add(registerResource);
        register.setResources(resources);

        permissionRepository.save(register);

        Role admin = new Role();
        admin.setTitle("管理员");
        admin.setName("ADMIN");
        admin.setDefinition("hasRole('ADMIN')");
        admin.setDescription("管理员可以进行登录后台进行用户、角色管理、权限管理等等");
        List<Permission> permissions = new ArrayList<>();
        permissions.add(getRepository);
        admin.setPermissions(permissions);

        Role sysAdmin = new Role();
        sysAdmin.setTitle("系统管理员");
        sysAdmin.setName("SYSTEM_ADMIN");
        sysAdmin.setDefinition("hasRole('SYSTEM_ADMIN')");
        sysAdmin.setDescription("系统管理员可以进行管理员的操作，还能进行资源，操作的管理");


        Role user = new Role();
        user.setTitle("普通用户");
        user.setName("USER");
        user.setDefinition("hasRole('USER')");
        user.setDescription("普通用户可以进行登陆");

        RoleGroup managerGroup = new RoleGroup();
        managerGroup.setTitle("管理组");
        managerGroup.setName("GROUP_MANAGER");

        roleGroupRepository.save(managerGroup);

        RoleGroup userGroup = new RoleGroup();
        userGroup.setTitle("普通用户组");
        userGroup.setName("GROUP_USER");

        roleGroupRepository.save(userGroup);

        user.setRoleGroup(userGroup);
        roleRepository.save(user);
        sysAdmin.setRoleGroup(managerGroup);
        roleRepository.save(sysAdmin);
        admin.setRoleGroup(managerGroup);
        roleRepository.save(admin);


        Manager faith = new Manager();
        faith.setPassword(passwordEncoder.encode("123456"));
        faith.setUsername("faith");
        faith.setRoleGroup(managerGroup);

        userRepository.save(faith);


        Consumer consumer = new Consumer();
        consumer.setUsername("user");
        consumer.setPassword(passwordEncoder.encode("123456"));
        consumer.setNickname("生命大树");
        consumer.setName("刘真源");
        consumer.setRoleGroup(userGroup);
        consumerRepository.save(consumer);

    }

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

    @Transactional(readOnly = true)
    @Override
    public Resource findByTitle(String title) {
        return resourceRepository.findByTitle(title);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
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
                requestMatcher.append("@");
                requestMatcher.append(operation.getName());

                String tmp = map.get(requestMatcher.toString());
                if (tmp == null){
                    configAttributes = new StringBuffer("");

                }else{
                    configAttributes = new StringBuffer(tmp);
                    configAttributes.append(" or ");
                }
                configAttributes.append(permission.getDefinition());
                if (permission.getName() != null && !permission.getName().equals("")){
                    List<Role> roles = permission.getRoles();
                    for(Role role : roles){
                        configAttributes.append(" or ");
                        configAttributes.append(role.getDefinition());
                    }
                }

                map.put(requestMatcher.toString(), configAttributes.toString());
            }

        }
        return map;
    }

    /**
     * 添加值放入web表达式中
     * @param expression
     * @param value
     * @return
     */
    private String buildWebExpression(String expression, String value){
        StringBuffer buffer = new StringBuffer(expression);
        buffer.append("('");
        buffer.append(value);
        buffer.append("'");
        buffer.append(")");

        return buffer.toString();
    }
}
