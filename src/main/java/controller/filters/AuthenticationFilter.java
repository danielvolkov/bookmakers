package controller.filters;


import controller.commands.authorization.PageNotFoundCommand;
import controller.security.Encryptor;
import model.entity.User;
import org.apache.log4j.Logger;
import util.constants.Attributes;
import util.constants.Pages;
import util.constants.UriHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by daniel on 1/28/17.
 */
public class AuthenticationFilter implements Filter {

    private static final Logger logger = Logger.getLogger(AuthenticationFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        request.setCharacterEncoding(Attributes.UTF_8);
        User user = (User) request.getSession().getAttribute(Attributes.USER);
        String uri = request.getRequestURI();
        if ( (user != null) && !uri.startsWith(UriHolder.LOGIN) ){
            chain.doFilter(req, resp);
        } else if ((user == null) && (uri.startsWith(UriHolder.LOGIN)||
                uri.startsWith(UriHolder.SIGNUP)||
                uri.equals(UriHolder.INDEX))){
            chain.doFilter(req, resp);
        } else {
            request.getRequestDispatcher(Pages.PAGE_NOT_FOUND).forward(req,resp);
        }

    }

    @Override
    public void destroy() {

    }
}
