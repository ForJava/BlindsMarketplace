package controllers;

import dto.*;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import utils.ImageService;
import utils.PasswordEncryptor;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Nikolay on 28.12.2016.
 */
@Controller
public class AdministratorController extends BaseController {

    private static final Logger LOGGER = Logger.getLogger(AdministratorController.class);

    @RequestMapping(value = "/admin/products", method = RequestMethod.GET)
    public String getAdminProducts(Model model) {
        List<Product> products=productDAO.getProducts();
        List<ProductSort> sorts=productDAO.getProductSort();
        model.addAttribute("productSorts", sorts);
        model.addAttribute("products", products);
        addAuthenticationUserToModel(model);
        return "adminProducts";
    }

    @RequestMapping(value = "/admin/add/product", method = RequestMethod.GET)
    public String getAddProducts(Model model) {
        List<ProductCategory> categories = productDAO.getProductCategories();
        List<ProductSort> sorts=productDAO.getProductSort();
        model.addAttribute("productSorts", sorts);
        model.addAttribute("productCategories", categories);
        addAuthenticationUserToModel(model);
        return "addProduct";
    }

    @RequestMapping(value = "/admin/add/product", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            LOGGER.error(bindingResult.getGlobalError());
        }
        if (product.getId() != null) {
            productDAO.updateProduct(product);
        } else {
            String path = product.SAVE_LOCATION + File.separator + product.getPhoto().getOriginalFilename();
            product.setPathPhoto(path);
            productDAO.addProduct(product);
            ImageService.imageSaveToFS(product.getPhoto(), path);
        }

        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/edit/product", method = RequestMethod.GET)
    public String getEditProduct(Model model, @RequestParam(value = "id") Integer id){
        Product product=productDAO.getProductById(id);
        List<ProductCategory> categories=productDAO.getProductCategories();
        List<ProductSort> sorts=productDAO.getProductSort();
        model.addAttribute("productSorts", sorts);
        model.addAttribute("product", product);
        model.addAttribute("categories", categories);
        addAuthenticationUserToModel(model);
        return "addProduct";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String getAdminPage(Model model) {
        addAuthenticationUserToModel(model);
        return "admin";
    }

    @RequestMapping(value = "/admin/partners", method = RequestMethod.GET)
    public String getPartnersPage(Model model) {
        List<User> users = userDAO.getUsers();
        model.addAttribute("users", users);
        addAuthenticationUserToModel(model);
        return "adminPartners";
    }

    @RequestMapping(value = "/admin/add/user", method = RequestMethod.GET)
    public String getAddUser(Model model) {
        List<Role> roles = userDAO.getRoles();
        model.addAttribute("roles", roles);
        addAuthenticationUserToModel(model);
        return "addUser";
    }

    @RequestMapping(value = "/admin/add/user", method = RequestMethod.POST)
    public String addUser(@ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            LOGGER.error(bindingResult.getGlobalError());
        }
        if (user.getId() != null) {
            String encryptedPassword = PasswordEncryptor.encryptPasswordMD5(user.getPassword());
            user.setPassword(encryptedPassword);
            userDAO.updateUser(user);
        } else {
            String encryptedPassword = PasswordEncryptor.encryptPasswordMD5(user.getPassword());
            user.setPassword(encryptedPassword);
            userDAO.addUser(user);
        }

        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/edit/user", method = RequestMethod.GET)
    public String editUser(Model model, @RequestParam(value = "id") Integer id) {
        User user = userDAO.getUserById(id);
        List<Role> roles = userDAO.getRoles();
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);
        addAuthenticationUserToModel(model);
        return "addUser";
    }

    @RequestMapping(value = "/admin/product/categories", method = RequestMethod.GET)
    public String getProductCategories(Model model) {
        List<ProductCategory> categories = productDAO.getProductCategories();
        model.addAttribute("productCategories", categories);
        addAuthenticationUserToModel(model);
        return "adminCategories";
    }

    @RequestMapping(value = "/admin/add/product/category", method = RequestMethod.GET)
    public String getAddCategory(Model model) {
        addAuthenticationUserToModel(model);
        return "addProductCategory";
    }

    @RequestMapping(value = "/admin/add/product/category", method = RequestMethod.POST)
    public String addProductCategory(
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "productCategory") String category,
            @RequestParam(value = "photoCategory") MultipartFile photoProductCategory
    ) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategory(category);
        String pathProductCategoryPhoto = ProductCategory.SAVE_LOCATION + File.separator + photoProductCategory.getOriginalFilename();
        ImageService.imageSaveToFS(photoProductCategory, pathProductCategoryPhoto);
        productCategory.setPathPhoto(pathProductCategoryPhoto);
        productDAO.addProductCategory(productCategory);
        return "redirect:/admin";
    }

}
