package by.itclass.filters;

import by.itclass.model.entities.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

import static by.itclass.constants.JspConstants.*;

@WebFilter(value = {LOGIN_JSP, REGISTRATION_JSP})
public class RegisteredUserFilter implements Filter {

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var session = ((HttpServletRequest)servletRequest).getSession();
        var user = (User) session.getAttribute(USER_ATTR);
        if(Objects.nonNull(user)){
            var req = (HttpServletRequest) servletRequest;
            req.getRequestDispatcher(HOME_JSP).forward(servletRequest, servletResponse);
            return;
        }
      filterChain.doFilter(servletRequest, servletResponse);
    }


    /**
     * Check if a given log record should be published.
     *
     * @param record a LogRecord
     * @return true if the log record should be published.
     */
    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
}
