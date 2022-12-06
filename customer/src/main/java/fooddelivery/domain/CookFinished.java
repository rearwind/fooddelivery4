package fooddelivery.domain;

import fooddelivery.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class CookFinished extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Long foodId;
    private Integer qty;
    private String address;
    private String customerId;
    private String status;
}
