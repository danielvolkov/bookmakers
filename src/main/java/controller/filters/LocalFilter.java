package controller.filters;

import controller.i18n.LocaleHolder;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import util.constants.Attributes;
import util.constants.UriHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

/**
 * Created by daniel on 1/30/17.
 */
public class LocalFilter implements Filter {
    /**
     * Logger for logging operations.
     */
    private static final Logger logger = Logger.getLogger(LocalFilter.class);

    /**
     * This holder has a current locale and array with supported locales.
     */
    protected LocaleHolder localeHolder;

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        localeHolder = new LocaleHolder(LocaleHolder.DEFAULT);
    }

    /**
     * In this method sets a locale. Get locale parameter, check if it is correct,
     * set locale.
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = ((HttpServletRequest) request);
        req.setCharacterEncoding(Attributes.UTF_8);
        HttpSession session = req.getSession();
        Locale locale = localeHolder.getCurrentLocale();
        if(req.getParameter(Attributes.LANG) != null) {
            //logger.info(LoggingMessagesHolder.INFO_SET_LOCALE);
            for (Locale loc : LocaleHolder.SUPPORTED) {
                if (loc.getLanguage().equals(req.getParameter(Attributes.LANG))) {
                    localeHolder.setCurrentLocale(loc);
                    locale = loc;
                    break;
                }
            }
        }
       // logger.info(LoggingMessagesHolder.INFO_SET_LOCALE);
        req.setAttribute(Attributes.LOCALE, locale);
        req.setAttribute(Attributes.URL_PARAM, getQueriesWithoutLang(req));
        response.setLocale(locale);
        session.setAttribute(Attributes.LOCALE, locale);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

    /**
     * This method parse string with get parameters for setting unique lang field
     * and construct correct queries string.
     *
     * @param request is request from client
     * @return queries string
     */
    private String getQueriesWithoutLang(HttpServletRequest request){
        String queries = UriHolder.QUESTION_SYMBOL;
        String queryString = request.getQueryString();
        if (!StringUtils.isEmpty(queryString)) {
            String[] params = queryString.split(UriHolder.AND_SYMBOL);
            for (String param: params) {
                String[] parseParam = param.split(UriHolder.EQUAL_SYMBOL);
                if ( !(parseParam.length < 2) ) {
                    if (!parseParam[0].equals(Attributes.LANG)) {
                        queries += param + UriHolder.AND_SYMBOL;
                    }
                }
            }
        }
        queries += UriHolder.LANG_GET;
        return queries;
    }
}