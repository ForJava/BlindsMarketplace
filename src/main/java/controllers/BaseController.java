package controllers;

import dao.ProductDAO;
import dao.UserDAO;
import dto.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

/**
 * Created by Nikolay on 28.12.2016.
 */
@Controller
public class BaseController {
    @Autowired
    protected UserDAO userDAO;
    @Autowired
    protected ProductDAO productDAO;

    protected String getLogin() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    protected Boolean isAuthentication() {
        return !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken);
    }

    protected void addAuthenticationUserToModel(Model model) {
        AuthUser authUser;
        if (isAuthentication()) {
            authUser = userDAO.getAuthUser(getLogin());
        }
        else{
            authUser = new AuthUser();
            authUser.setRole("");
        }
        model.addAttribute("authUser", authUser);
    }

}
