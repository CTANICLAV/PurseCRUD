package ru.stasdev.domain;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class NavigationButtons extends SimpleTagSupport {

    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.print("<p>\n" +
                "        <a class=\"btn btn-primary btn-xs\" href=\"/PurseCRUD-1.0-SNAPSHOT\" role=\"button\">All Purse</a>\n" +
                "        <a class=\"btn btn-primary btn-xs\" href=\"/PurseCRUD-1.0-SNAPSHOT/all/currency\" role=\"button\">All Currency</a>\n" +
                "        <a class=\"btn btn-primary btn-xs\" href=\"/PurseCRUD-1.0-SNAPSHOT/all/user\" role=\"button\">All User</a>\n" +
                "    </p>");
    }
}
