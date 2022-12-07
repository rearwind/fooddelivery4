package fooddelivery.domain;

import fooddelivery.domain.CouponIssued;
import fooddelivery.CustomerApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="CouponMgmt_table")
@Data

public class CouponMgmt  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String customerId;
    
    
    
    
    
    private Integer orderCount;

    @PostUpdate
    public void onPostUpdate() {}


    public static CouponMgmtRepository repository(){
        CouponMgmtRepository couponMgmtRepository = CustomerApplication.applicationContext.getBean(CouponMgmtRepository.class);
        return couponMgmtRepository;
    }




    public static void issueCoupon(Delivered delivered){

        /** Example 1:  new item 
        CouponMgmt couponMgmt = new CouponMgmt();
        repository().save(couponMgmt);

        CouponIssued couponIssued = new CouponIssued(couponMgmt);
        couponIssued.publishAfterCommit();
        */

        /** Example 2:  finding and process */
        
        repository().findByCustomerId(delivered.getCustomerId()).ifPresent(couponMgmt->{    // 가입고객(customerId) 찾기
            
            couponMgmt.setOrderCount(Integer.valueOf(couponMgmt.getOrderCount())+1) // 고객의 완료된 주문횟수 증가

            if (Integer.valueOf(couponMgmt.getOrderCount()) == 0) {                 // 3번째 주문마다 쿠폰발행 ("쿠폰발행됨" 이벤트 Publish)
                CouponIssued couponIssued = new CouponIssued(this);
                couponIssued.publishAfterCommit();

                couponMgmt.setOrderCount(Integer.valueOf(0));                       // 쿠폰발행 후 주문횟수 0으로 리셋
            }

            repository().save(couponMgmt);

         });
        

        
    }


}
