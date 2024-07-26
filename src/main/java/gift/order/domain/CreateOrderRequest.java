package gift.order.domain;

public class CreateOrderRequest {
    private Long optionId;
    private Long quantity;
    private Long message;

    public Order toEntity() {
        return new Order(optionId, quantity, message);
    }
}
