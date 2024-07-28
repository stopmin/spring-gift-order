package gift.order.controller;

import gift.order.domain.CreateOrderRequest;
import gift.order.domain.Order;
import gift.order.domain.OrderCreateResponse;
import gift.order.service.OrderService;
import gift.util.CommonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/orders")
    public ResponseEntity<?> createOrder(@RequestBody CreateOrderRequest createOrderRequest, @RequestHeader String accessToken) {
        OrderCreateResponse order = orderService.createOrder(createOrderRequest, accessToken);
        return ResponseEntity.ok().body(new CommonResponse<>(
                order,
                "주문 생성 성공",
                true
        ));
    }
}
