package org.fightteam.avalon.processor;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.fightteam.avalon.core.entity.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

/**
 * 基于 ResourceProcessor 实现对象的扩展
 * User: excalibur
 * Date: 13-8-21
 * Time: 下午5:37
 * 可以增加对象的动作与uri
 */
@Component
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class UserProcessor implements ResourceProcessor<Resource<User>> {

    @NonNull
    private final EntityLinks entityLinks;
    @Override
    public Resource<User> process(Resource<User> resource) {
        User user = resource.getContent();
        resource.add(entityLinks.linkForSingleResource(user).withRel("tesst"));
        return resource;
    }
}
