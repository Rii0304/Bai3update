package bai3.com.bai3.controller;

import bai3.com.bai3.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    public String addToCart(@ModelAttribute("productId") Long productId) {

        cartService.addToCart(productId);

        return "redirect:/products";
    }

    @GetMapping
    public String showCart(Model model) {

        model.addAttribute("cart", cartService.getCart());

        return "Cart";
    }

    @PostMapping("check-out")
    public String checkOut() {

        cartService.createOrder();
        return "Checkout";
    }
}
