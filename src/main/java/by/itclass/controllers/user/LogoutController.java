package by.itclass.controllers.user;

import by.itclass.controllers.abstraction.AbstractController;
import by.itclass.controllers.abstraction.UserAbstractController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static by.itclass.constants.ApplicationConstants.LOGOUT_CONTROLLER;
import static by.itclass.constants.JspConstants.LOGIN_JSP;

@WebServlet(value = LOGOUT_CONTROLLER)
public class LogoutController extends UserAbstractController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var session = req.getSession();
        session.invalidate();
        resp.sendRedirect(LOGIN_JSP);
    }
}