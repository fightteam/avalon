package org.fightteam.avalon.web.controller.advice;

import org.fightteam.avalon.security.exception.UnauthenticatedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@ControllerAdvice
public class ResponseControllerAdvice {

    @ExceptionHandler(UnauthenticatedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String unauthorized(){
        System.out.println("============555============");
        return "aaaaaa";
    }
}
