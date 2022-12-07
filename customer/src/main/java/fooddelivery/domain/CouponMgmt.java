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

    @PostPersist
    public void onPostPersist(){
    }
    @PostUpdate
    public void onPostUpdate(){


        CouponIssued couponIssued = new CouponIssued(this);
        couponIssued.publishAfterCommit();

    }

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

        /** Example 2:  finding and process
        
        repository().findById(delivered.get???()).ifPresent(couponMgmt->{
            
            couponMgmt // do something
            repository().save(couponMgmt);

            CouponIssued couponIssued = new CouponIssued(couponMgmt);
            couponIssued.publishAfterCommit();

         });
        */

        
    }


}
