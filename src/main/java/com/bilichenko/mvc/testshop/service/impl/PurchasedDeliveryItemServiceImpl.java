package com.bilichenko.mvc.testshop.service.impl;

import com.bilichenko.mvc.testshop.dao.PurchasedDeliveryItemRepository;
import com.bilichenko.mvc.testshop.model.PurchasedDeliveryItem;
import com.bilichenko.mvc.testshop.service.PurchasedDeliveryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchasedDeliveryItemServiceImpl implements PurchasedDeliveryItemService {

    @Autowired
    private PurchasedDeliveryItemRepository pdiRepository;

    @Override
    public PurchasedDeliveryItem save(PurchasedDeliveryItem pdi) {
        return pdiRepository.save(pdi);
    }
}
