package org.fightteam.avalon.rest.web.processor;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.fightteam.avalon.core.entity.domain.Role;
import org.fightteam.avalon.core.entity.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Controller;

/**
 * 基于 ResourceProcessor 实现对象的扩展
 *
 * 可以增加对象的rel(动作)与uri
 *
 * @author excalibur
 * @since 0.0.1
 */
@Controller
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class UserProcessor implements ResourceProcessor<Resource<User>> {

    @NonNull
    private final EntityLinks entityLinks;


    @Override
    public Resource<User> process(Resource<User> resource) {
        System.out.println("-----------------------");
       User user = resource.getContent();
        Role role =new Role();
        role.setId(2l);
       resource.add(entityLinks.linkForSingleResource(role)
               .withRel("tesst"));
        resource.add(entityLinks.linkToCollectionResource(Role.class)
                .withRel("tsst"));
        resource.add(entityLinks.linkFor(Role.class)
                .withRel("tsst2"));
        resource.add(entityLinks.linkFor(Role.class,role)
                .withRel("tsst3"));
        user.setPassword("");
        return resource;
    }
}
