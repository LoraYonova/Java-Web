package com.example.shopping.web;

import com.example.shopping.model.entity.enums.CategoryEnum;
import com.example.shopping.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String index(HttpSession httpSession, Model model) {

        if (httpSession.getAttribute("user") == null) {
            return "index";
        }
        model.addAttribute("totalSum", productService.getTotalSum());
        model.addAttribute("drinks", productService.findAllProductsByCategoryEnum(CategoryEnum.DRINK));
        model.addAttribute("food", productService.findAllProductsByCategoryEnum(CategoryEnum.FOOD));
        model.addAttribute("household", productService.findAllProductsByCategoryEnum(CategoryEnum.HOUSEHOLD));
        model.addAttribute("other", productService.findAllProductsByCategoryEnum(CategoryEnum.OTHER));

        return "home";
    }
}
