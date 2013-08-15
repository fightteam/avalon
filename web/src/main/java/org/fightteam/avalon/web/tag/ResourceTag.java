package org.fightteam.avalon.web.tag;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: faith
 * Date: 13-8-13
 * Time: 下午6:54
 * To change this template use File | Settings | File Templates.
 */
public class ResourceTag extends SimpleTagSupport {

    private String url;


    @Override
    public void doTag() throws JspException, IOException {
        JspContext ctx = getJspContext();
        JspWriter out = ctx.getOut();

    }
}
