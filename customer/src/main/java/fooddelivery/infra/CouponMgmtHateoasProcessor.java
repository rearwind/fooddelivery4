package fooddelivery.infra;
import fooddelivery.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class CouponMgmtHateoasProcessor implements RepresentationModelProcessor<EntityModel<CouponMgmt>>  {

    @Override
    public EntityModel<CouponMgmt> process(EntityModel<CouponMgmt> model) {

        
        return model;
    }
    
}
