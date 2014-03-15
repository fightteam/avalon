package org.fightteam.avalon.mgt.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.Link;

import java.util.List;

/**
 * @author excalibur
 * @since 0.0.1
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public abstract class BasicRestEntity {
    @JsonProperty(value = "_links")
    private List<Link> links;
}
