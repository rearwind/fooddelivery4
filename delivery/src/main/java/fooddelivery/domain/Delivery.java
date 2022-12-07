package fooddelivery.domain;

import fooddelivery.DeliveryApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Delivery_table")
@Data

public class Delivery  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Long orderId;
    
    
    
    
    
    private String address;
    
    
    
    
    
    private String customerId;
    
    
    
    
    
    private String status;

    @PostPersist
    public void onPostPersist(){
    }

    public static DeliveryRepository repository(){
        DeliveryRepository deliveryRepository = DeliveryApplication.applicationContext.getBean(DeliveryRepository.class);
        return deliveryRepository;
    }



    public void pick(){
        setStatus("배달시작됨");

        Picked picked = new Picked(this);
        picked.publishAfterCommit();

    }
    public void confirmDelivered(){
        setStatus("배달완료됨");

        Delivered delivered = new Delivered(this);
        delivered.publishAfterCommit();

    }

    public static void copyOrderInfo(OrderPlaced orderPlaced){

        /** Example 1:  new item */
        Delivery delivery = new Delivery();

        delivery.setOrderId(orderPlaced.getId());
        delivery.setAddress(orderPlaced.getAddress());
        delivery.setCustomerId(orderPlaced.getCustomerId());
        delivery.setStatus(orderPlaced.getStatus());

        repository().save(delivery);

        

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);


         });
        */

        
    }
    public static void updateStatus(CookFinished cookFinished){

        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        */

        /** Example 2:  finding and process */
        
        repository().findByOrderId(cookFinished.getOrderId()).ifPresent(delivery->{
            
            delivery.setStatus("요리완료됨"); // "요리완료됨"으로 상태 변경 -> 배송건 조회 가능
            repository().save(delivery);


         });
        

        
    }


}
