package controller.filters;

import controller.i18n.LocaleHolder;
import org.apache.log4j.Logger;
import util.constants.Attributes;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

/**
 * Created by daniel on 1/30/17.
 */
public class LocalFilter implements Filter {

    private static final Logger logger = Logger.getLogger(LocalFilter.class);

    protected LocaleHolder localeHolder;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        localeHolder = new LocaleHolder(LocaleHolder.DEFAULT);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = ((HttpServletRequest) request);
        req.setCharacterEncoding(Attributes.UTF_8);
        HttpSession session = req.getSession();
        Locale locale = localeHolder.getCurrentLocale();
    }

    @Override
    public void destroy() {

    }
}
