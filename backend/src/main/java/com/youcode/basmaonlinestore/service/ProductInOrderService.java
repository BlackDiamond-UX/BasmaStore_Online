package com.youcode.basmaonlinestore.service;

import com.youcode.basmaonlinestore.entity.ProductInOrder;
import com.youcode.basmaonlinestore.entity.User;

/**
 * Created By Zhu Lin on 1/3/2019.
 */
public interface ProductInOrderService {
    void update(String itemId, Integer quantity, User user);
    ProductInOrder findOne(String itemId, User user);
}
