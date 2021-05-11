package com.youcode.basmaonlinestore.service;

import com.youcode.basmaonlinestore.entity.ProductInOrder;
import com.youcode.basmaonlinestore.entity.User;
import com.youcode.basmaonlinestore.entity.Cart;

import java.util.Collection;

/**
 * Created By Zhu Lin on 3/10/2018.
 */
public interface CartService {
    Cart getCart(User user);

    void mergeLocalCart(Collection<ProductInOrder> productInOrders, User user);

    void delete(String itemId, User user);

    void checkout(User user);
}
