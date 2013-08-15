package org.fightteam.avalon.core.util;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;

import javax.validation.MessageInterpolator;
import javax.validation.Validation;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: faith
 * Date: 13-8-12
 * Time: 下午1:27
 * To change this template use File | Settings | File Templates.
 */
public class SpringAwareMessageMessageInterpolator implements MessageInterpolator, MessageSourceAware {
    private MessageInterpolator defaultMessageInterpolator =
            Validation.byDefaultProvider().configure().getDefaultMessageInterpolator();

    private MessageSource messageSource;

    public void setMessageSource(final MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String interpolate(final String s, final Context context) {
        return interpolate(s, context, LocaleContextHolder.getLocale());
    }

    public String interpolate(final String s, final Context context, final Locale locale) {
        try {
            return this.messageSource.getMessage(s,
                    context.getConstraintDescriptor().getAttributes().values().toArray(
                            new Object[context.getConstraintDescriptor().getAttributes().size()]), locale);
        } catch (final NoSuchMessageException e) {
            return this.defaultMessageInterpolator.interpolate(s, context, locale);
        }
    }
}
