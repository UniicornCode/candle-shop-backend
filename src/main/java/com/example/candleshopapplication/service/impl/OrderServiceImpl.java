package com.example.candleshopapplication.service.impl;

import com.example.candleshopapplication.model.Candle;
import com.example.candleshopapplication.model.Order;
import com.example.candleshopapplication.model.ShoppingCart;
import com.example.candleshopapplication.model.User;
import com.example.candleshopapplication.model.enumeration.Role;
import com.example.candleshopapplication.repository.CandleRepository;
import com.example.candleshopapplication.repository.OrderRepository;
import com.example.candleshopapplication.repository.ShoppingCartRepository;
import com.example.candleshopapplication.repository.UserRepository;
import com.example.candleshopapplication.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ShoppingCartRepository shoppingCartRepository;

    @Override
    public List<Order> listAll() {
        UserDetails userDetails =
                (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userDetails.getAuthorities().contains(Role.ROLE_ADMIN))
            return orderRepository.findAll();
        else {
            List<Order> list = orderRepository.findAll();
            List<Order> orders = new ArrayList<>();
            for (Order o: list) {
                if (o.getUser().getUsername().equals(userDetails.getUsername()))
                    orders.add(o);
            }
            return orders;
        }
    }

    @Override
    public Optional<Order> create(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        ShoppingCart shoppingCart = shoppingCartRepository.getShoppingCartByUser(user).get();
        List<Candle> candleList = shoppingCart.getCandles();
        shoppingCart.setCandles(new ArrayList<>());
        shoppingCartRepository.save(shoppingCart);
        Order order = new Order(user, candleList);
        Order createdOrder = orderRepository.save(order);
        return Optional.of(createdOrder);
    }

}
