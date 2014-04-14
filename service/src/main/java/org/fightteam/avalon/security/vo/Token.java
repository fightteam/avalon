package org.fightteam.avalon.security.vo;

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
public class Token {
    private String token;

    public Token(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "{" +
                "\"token\":\"" + token + "\"" +
                "}";
    }
}
