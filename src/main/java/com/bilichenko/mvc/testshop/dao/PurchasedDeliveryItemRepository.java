package com.bilichenko.mvc.testshop.dao;

import com.bilichenko.mvc.testshop.model.PurchasedDeliveryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchasedDeliveryItemRepository extends JpaRepository<PurchasedDeliveryItem, Long> {
}
