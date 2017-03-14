package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import dto.AuthUser;

/**
 * Created by Nikolay on 25.01.2017.
 */
@Controller
public class AuthorisationController extends BaseController {
    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String loginGET() {
        return "login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/loginfailed")
    public String loginFailedGET(Model model) {
        String loginFailed = "Неверный логин или пароль!";
        model.addAttribute("loginFailed", loginFailed);
        return "login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/logout")
    public String logoutGET() {
        return "login";
    }

    @RequestMapping(value = "/isuser", method = RequestMethod.GET)
    public String getPageForRole(Model model) {
        AuthUser authUser = userDAO.getAuthUser(getLogin());
        model.addAttribute("authUser", authUser);
        if (AuthUser.ROLE_ADMIN.equals(authUser.getRole())) {
            return "admin";
        }
        return "home";
    }
}
