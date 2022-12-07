package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CouponIssued extends AbstractEvent {

    private Long id;
    private String customerId;
    private Integer orderCount;

    public CouponIssued(CouponMgmt aggregate){
        super(aggregate);
    }
    public CouponIssued(){
        super();
    }
}
