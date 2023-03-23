package com.example.product_wedsite.controller;

import com.example.product_wedsite.model.Product;
import com.example.product_wedsite.services.IProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    IProductServices services;

    @GetMapping("/producthome")
    public String showMapProduct(Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
        Sort sort = Sort.by("date");
        model.addAttribute("pageProduct", services.findAllWithPage(PageRequest.of(page, 1, sort)));
        return "home";
    }

    @GetMapping("delete")
    public String delete(@RequestParam(value = "codeproduct") String codeproduct, RedirectAttributes redirectAttributes) {
        Product product = services.findByCode(codeproduct);
        services.delete(product);
        String mess;
        redirectAttributes.addFlashAttribute("msg", mess = "delete success");
        return "redirect:/producthome";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        Product product = new Product("0", "0", "0", "00/00/0000");
        model.addAttribute("product", product);
        return "create";
    }

    @PostMapping("search")
    public String search(@RequestParam(value = "codeSearch") String codeSearch, Model model) {
        Product product = services.findByCode(codeSearch);
        model.addAttribute("productDto", product);
        return "search";
    }

    @GetMapping("edit")
    public String edit(@RequestParam(value = "codeproduct") String codeproduct, Model model) {
        Product product = services.findByCode(codeproduct);
        model.addAttribute("product", product);
        return "edit";
    }

    @PostMapping("/doedit")
    public String doEdit(@Valid Product product, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        String result = "";
        if (bindingResult.hasErrors()) {
            result = "edit";
        } else {
            services.save(product);
            String mess;
            redirectAttributes.addFlashAttribute("msg", mess = "edit success");
            result = "redirect:/producthome";
        }
        return result;
    }

    @PostMapping("/docreate")
    public String doCreate(@Valid Product productDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        String result = "";
        if (bindingResult.hasErrors()) {
            result = "create";
        } else {
            services.save(productDto);
            String mess;
            redirectAttributes.addFlashAttribute("msg", mess = "Create success");
            result = "redirect:/producthome";
        }
        return result;
    }

    @GetMapping("/detail/{codeProduct}")
    public String detail(@PathVariable String codeProduct, Model model) {
        Product product = services.findByCode(codeProduct);
        model.addAttribute("productdto", product);
        return "detail";
    }
}
