package org.fightteam.avalon.mgt.service.impl;

import org.fightteam.avalon.mgt.rest.common.RestRouters;
import org.fightteam.avalon.mgt.service.OperationService;
import org.fightteam.avalon.mgt.service.bo.OperationBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.PagedResources;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author excalibur
 * @since 0.0.1
 */
@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    private RestRouters restRouters;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void create(OperationBO operationBO) {
        //restTemplate.postForEntity()
    }

    @Override
    public OperationBO update(OperationBO operationBO) {
        return null;
    }

    @Override
    public OperationBO findByName(String name) {
        //PagedResources
        //restTemplate.getInterceptors()
        return null;
    }

    @Override
    public OperationBO findByTitle(String title) {
        return null;
    }
}
