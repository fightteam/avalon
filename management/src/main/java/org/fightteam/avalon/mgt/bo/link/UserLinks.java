package org.fightteam.avalon.mgt.bo.link;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.Link;

/**
 * @author excalibur
 * @since 0.0.1
 */
@Getter
@Setter
public class UserLinks {
    private Link self;
    private Link permissions;
    private Link roles;
}
