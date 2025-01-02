package com.main.urban_vibe.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.main.urban_vibe.dtos.CartDto;
import com.main.urban_vibe.dtos.FeedbackDto;
import com.main.urban_vibe.dtos.OrderDto;
import com.main.urban_vibe.dtos.PaymentDto;
import com.main.urban_vibe.dtos.ProductDto;
import com.main.urban_vibe.dtos.UserDto;
import com.main.urban_vibe.entities.Cart;
import com.main.urban_vibe.entities.Feedback;
import com.main.urban_vibe.entities.Order;
import com.main.urban_vibe.entities.Payment;
import com.main.urban_vibe.entities.Product;
import com.main.urban_vibe.entities.User;

@Component
public class MapperUtils {

    private final ModelMapper modelMapper;

    public MapperUtils(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    // Product
    public ProductDto convertToProductDto(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }

    public Product convertToProductEntity(ProductDto productDto) {
        return modelMapper.map(productDto, Product.class);
    }

    public List<ProductDto> convertToProductDtoList(List<Product> products) {
        return products.stream()
                .map(this::convertToProductDto)
                .collect(Collectors.toList());
    }

    // Cart
    public CartDto convertToCartDto(Cart cart) {
        return modelMapper.map(cart, CartDto.class);
    }

    public Cart convertToCartEntity(CartDto cartDto) {
        return modelMapper.map(cartDto, Cart.class);
    }
    // User
    public UserDto convertToUserDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    public User convertToUserEntity(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

    // Order
    public OrderDto convertToOrderDto(Order order) {
        return modelMapper.map(order, OrderDto.class);
    }

    public Order convertToOrderEntity(OrderDto orderDto) {
        return modelMapper.map(orderDto, Order.class);
    }

    // Payment
    public PaymentDto convertToPaymentDto(Payment payment) {
        return modelMapper.map(payment, PaymentDto.class);
    }

    public Payment convertToPaymentEntity(PaymentDto paymentDto) {
        return modelMapper.map(paymentDto, Payment.class);
    }

    // Feedback
    public FeedbackDto convertToFeedbackDto(Feedback feedback) {
        return modelMapper.map(feedback, FeedbackDto.class);
    }

    public Feedback convertToFeedbackEntity(FeedbackDto feedbackDto) {
        return modelMapper.map(feedbackDto, Feedback.class);
    }

    // Add more conversion methods for other entities and DTOs as needed
}