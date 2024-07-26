package gift.order.service;

import gift.order.domain.CreateOrderRequest;
import gift.order.domain.Order;
import gift.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(CreateOrderRequest request) {
        return orderRepository.save(request.toEntity());
    }
}
