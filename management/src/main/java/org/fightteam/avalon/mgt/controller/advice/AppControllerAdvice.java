package org.fightteam.avalon.mgt.controller.advice;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@ControllerAdvice
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class AppControllerAdvice {
}
