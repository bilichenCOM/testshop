package com.bilichenko.mvc.testshop.controller;

import com.bilichenko.mvc.testshop.controller.payloads.DeliveryInfoPayload;
import com.bilichenko.mvc.testshop.model.Cart;
import com.bilichenko.mvc.testshop.model.PurchasedDeliveryItem;
import com.bilichenko.mvc.testshop.model.User;
import com.bilichenko.mvc.testshop.service.CartService;
import com.bilichenko.mvc.testshop.service.MailService;
import com.bilichenko.mvc.testshop.service.PurchasedDeliveryItemService;
import com.bilichenko.mvc.testshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class PurchaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private PurchasedDeliveryItemService pdiService;

    @Autowired
    private MailService mailService;

    @RequestMapping(value = "/purchase", method = RequestMethod.GET)
    public ModelAndView purchase(ModelAndView mav) {
        mav.addObject("dip", new DeliveryInfoPayload());
        mav.setViewName("delivery");
        return mav;
    }

    @RequestMapping(value = "/purchase", method = RequestMethod.POST)
    public String purchase(@Valid @ModelAttribute("dip") DeliveryInfoPayload dip, BindingResult bindingResult,
                           @ModelAttribute Cart cart,
                           @ModelAttribute User user,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) { return "delivery"; }

        PurchasedDeliveryItem pdi = composeOrder(user, cart, dip);
        pdi = pdiService.save(pdi);

        user.setCart(new Cart());
        userService.update(user);

        mailService.sendMessage(user.getEmail(), "Purchase confirmation",
                String.format("Your purchase with id %s is confirmed.", pdi.getId()));
        redirectAttributes.addFlashAttribute("purchaseMessage",
                String.format("success! to confirm your order (id %s) please check your inbox %s",
                        pdi.getId(), user.getEmail()));
        return "redirect:/cart";
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
