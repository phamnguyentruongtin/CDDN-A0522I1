package com.example.shopping_cart.Controller;

import com.example.shopping_cart.model.Client;
import com.example.shopping_cart.model.Product;
import com.example.shopping_cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("/")
    public String homePage(Model model, HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            Arrays.stream(cookies);

        }
        Cookie cookie = new Cookie("productcookie", "productcookie");
        response.addCookie(cookie);
        model.addAttribute("listProduct",iProductService.getAllProducts());
        return "homepage";
    }

    @GetMapping("detail")
    public String detail(Model model,Long idproduct){
       Product product = iProductService.findByIdProduct(idproduct);
       if (product == null) {
           return "404";
       }
       model.addAttribute("product",product);
       return "detail";
    }
    @GetMapping("buyproduct")
    public String buyProduct(Model model,Long idproduct){
        Product product = iProductService.findByIdProduct(idproduct);
        if (product == null) {
            return "404";
        }
        model.addAttribute("product",product);
        return "addtocard";
    }

    @PostMapping("dobuy")
    public String doByProduct(Product product, RedirectAttributes redirectAttributes){
        iProductService.addToCart(product);
        redirectAttributes.addFlashAttribute("sms","add to cart success");
        return "redirect:cart";
    }
    @GetMapping("cart")
    public String showCart(Model model){
      List<Product> carts = iProductService.getAllCart();
        model.addAttribute("carts",carts);
        return "cart";
    }
    @ExceptionHandler(value = Exception.class)
    public String catchALlException() {
        return "404";
    }
    }
