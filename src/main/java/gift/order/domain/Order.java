package gift.order.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long optionId;
    private Long quantity;
    private Long message;

    private final LocalDateTime orderDateTime = LocalDateTime.now();

    public Order(Long optionId, Long quantity, Long message) {
        this.optionId = optionId;
        this.quantity = quantity;
        this.message = message;
    }

    public Order() {

    }
}
