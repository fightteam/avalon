package org.fightteam.avalon.rest.web;

import org.springframework.data.rest.webmvc.RepositoryLinksResource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Controller;

/**
 * api对外主页控制
 *
 * 主页对外的rel可以在该类控制
 *
 * @author excalibur
 * @since 0.0.1
 */
@Controller
public class EngineController implements ResourceProcessor<RepositoryLinksResource> {

    @Override
    public RepositoryLinksResource process(RepositoryLinksResource resource) {
        return resource;
    }
}
