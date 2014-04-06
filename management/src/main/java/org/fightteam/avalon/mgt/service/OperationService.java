package org.fightteam.avalon.mgt.service;

import org.fightteam.avalon.mgt.service.bo.OperationBO;

/**
 * @author excalibur
 * @since 0.0.1
 */
public interface OperationService {
    void create(OperationBO operationBO);
    OperationBO update(OperationBO operationBO);
    OperationBO findByName(String name);
    OperationBO findByTitle(String title);

}
