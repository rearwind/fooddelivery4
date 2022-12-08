package fooddelivery.external;

import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {


    /**
     * Fallback
     */
    @Override
    public void pay(Payment payment) {

        System.out.println("\n\n##### 결제시스템이 과중된 상태입니다. 나중에 다시 주문해주세요.\n\n");
        
        throw new RuntimeException("\n\n##### 결제시스템이 과중된 상태입니다. 나중에 다시 주문해주세요.\n\n");

    }

    public Payment getPayment(Long id) {

        System.out.println("\n\n##### 결제시스템이 과중된 상태입니다. 나중에 다시 주문해주세요.\n\n");
        
        Payment payment = new Payment();
        return payment;
    }
}

