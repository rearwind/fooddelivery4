package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class PayCancelled extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String status;
}


