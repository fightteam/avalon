package org.fightteam.avalon.security.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@Getter
@Setter
public class Message {
    private int status;
    private String message;

    @Override
    public String toString() {
        return "{" +
                "\"status\":" + status +
                ", \"message\":\"" + message + "\"" +
                "}";
    }
}
