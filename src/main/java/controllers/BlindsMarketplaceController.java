package controllers;

import dto.Product;
import dto.ProductCategory;
import dto.ProductSort;
import dto.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import utils.PasswordEncryptor;
import utils.ImageService;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.IOException;
import java.util.List;

/**
 * Created by Nikolay on 27.12.2016.
 */
@Controller
public class BlindsMarketplaceController extends BaseController {
    private static final Logger LOGGER = Logger.getLogger(BlindsMarketplaceController.class);

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHomePage(Model model) {
        List<ProductSort> sorts=productDAO.getProductSort();
        model.addAttribute("sorts", sorts);
        addAuthenticationUserToModel(model);
        return "home";
    }

    @RequestMapping(value = "/product/by/sort/{id}", method = RequestMethod.GET)
    public String getProductPageBySort(Model model, @PathVariable Integer id) throws IOException{
        Integer readyMade=1;
        if(id.equals(readyMade)){
            List<Product> products = productDAO.getProductsBySort(id);
            model.addAttribute("products", products);
            addAuthenticationUserToModel(model);
            return "readyMade";
        }else{
            List<ProductCategory> categories = productDAO.getProductCategories();
            model.addAttribute("categories", categories);
            addAuthenticationUserToModel(model);
            return "madeBySize";
        }
    }

    @RequestMapping(value = "/getProductImage/{id}")
    @ResponseBody
    public byte[] getProductImage(@PathVariable Integer id) throws IOException {
        String pathPhoto = productDAO.getPathProductPhoto(id);
        return ImageService.readImage(pathPhoto);
    }

    @RequestMapping(value = "/getCategoryImage/{id}")
    @ResponseBody
    public byte[] getCategoryImage(@PathVariable Integer id) throws IOException {
        String pathPhoto = productDAO.getPathCategoryPhoto(id);
        return ImageService.readImage(pathPhoto);
    }

    @RequestMapping(value = "/getSortImage/{id}")
    @ResponseBody
    public byte[] getSortImage(@PathVariable Integer id) throws IOException {
        String pathPhoto = productDAO.getPathSortPhoto(id);
        return ImageService.readImage(pathPhoto);
    }


    //TODO DB that make orderForm
    @RequestMapping(value = "/order/form/{id}", method = RequestMethod.GET)
    public String getOrderForm(@PathVariable Integer id) {

        return "orderForm";
    }


    @RequestMapping(value = "registration", method = RequestMethod.GET)
    public String getRegistrationPage() {
        return "registration";
    }

    @RequestMapping(value = "registration/user", method = RequestMethod.POST)
    public String registrationUser(
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "mail") String login,
            @RequestParam(value = "pass") String password) {
        User user = new User();
        user.setId(id);
        user.setLogin(login);
        String encryptorPassword = PasswordEncryptor.encryptPasswordMD5(password);
        user.setPassword(encryptorPassword);
        userDAO.addUser(user);
        return "redirect:/home";
    }
}
