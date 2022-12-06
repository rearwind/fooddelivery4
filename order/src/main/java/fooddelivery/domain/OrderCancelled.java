package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OrderCancelled extends AbstractEvent {

    private Long id;
    private Integer qty;
    private String customerId;
    private String address;
    private String status;
    private Long foodId;

    public OrderCancelled(Order aggregate){
        super(aggregate);
    }
    public OrderCancelled(){
        super();
    }
}
