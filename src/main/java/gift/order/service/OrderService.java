package gift.order.service;

import gift.order.domain.CreateOrderRequest;
import gift.order.domain.Order;
import gift.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final AllimService allimService;

    public OrderService(OrderRepository orderRepository, AllimService allimService) {
        this.orderRepository = orderRepository;
        this.allimService = allimService;
    }

    public Order createOrder(CreateOrderRequest request, String accessToken) {
        Order order = orderRepository.save(request.toEntity());
        allimService.sendAllim(accessToken, order.toString());
        return order;
    }
}
