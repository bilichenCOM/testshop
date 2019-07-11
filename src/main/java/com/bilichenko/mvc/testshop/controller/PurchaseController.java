package com.bilichenko.mvc.testshop.controller;

import com.bilichenko.mvc.testshop.controller.payloads.DeliveryInfoPayload;
import com.bilichenko.mvc.testshop.model.Cart;
import com.bilichenko.mvc.testshop.model.PurchasedDeliveryItem;
import com.bilichenko.mvc.testshop.model.User;
import com.bilichenko.mvc.testshop.service.CartService;
import com.bilichenko.mvc.testshop.service.PurchasedDeliveryItemService;
import com.bilichenko.mvc.testshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.ArrayList;

@Controller
public class PurchaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;

    @Autowired
    private PurchasedDeliveryItemService pdiService;

    private User getUserOfPrincipal(Principal principal) {
        return userService.getByEmail(principal.getName()).get();
    }

    private Cart getCartOfUser(User user) {
        return cartService.getById(user.getCart().getId()).get();
    }

    @RequestMapping(value = "/purchase", method = RequestMethod.GET)
    public ModelAndView purchase(Principal principal, ModelAndView mav) {
        mav.addObject("dip", new DeliveryInfoPayload());
        mav.addObject("user", getUserOfPrincipal(principal));
        mav.setViewName("delivery");
        return mav;
    }

    @RequestMapping(value = "/purchase", method = RequestMethod.POST)
    public ModelAndView purchase(@ModelAttribute DeliveryInfoPayload dip,
                                 Principal principal, ModelAndView mav,
                                 RedirectAttributes redirectAttributes) {
        User user = getUserOfPrincipal(principal);
        Cart cart = getCartOfUser(user);

        PurchasedDeliveryItem pdi = composeOrder(user, cart, dip);
        pdi = pdiService.save(pdi);

        cart.setProducts(new ArrayList<>());
        cartService.update(cart);

        redirectAttributes.addFlashAttribute("purchaseMessage",
                String.format("success! to confirm your order (id %s) please check your inbox %s",
                        pdi.getId(), user.getEmail()));
        mav.setViewName("redirect:/cart");
        return mav;
    }

    private PurchasedDeliveryItem composeOrder(User user, Cart cart, DeliveryInfoPayload dip) {
        return new PurchasedDeliveryItem.PurchasedDeliveryItemBuiler()
                .withUser(user)
                .withProducts(cart.getProducts())
                .withCountry(dip.getCountry())
                .withCity(dip.getCity())
                .withStreet(dip.getStreet())
                .withFirstName(dip.getFirstName())
                .withLastName(dip.getLastName())
                .withZip(dip.getZip())
                .build();
    }
}
