package org.fightteam.avalon.security.service;

import org.fightteam.avalon.security.data.models.Resource;

import java.util.List;
import java.util.Map;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public interface ResourceService {
    Resource add(Resource resource);

    Resource update(Resource resource);

    void delete(Long id);

    Resource findById(Long id);

    Resource findByTitle(String title);

    Map<String, String> findAllURL();
}
