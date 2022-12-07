package fooddelivery.domain;

import fooddelivery.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="couponMgmts", path="couponMgmts")
public interface CouponMgmtRepository extends PagingAndSortingRepository<CouponMgmt, Long>{

}
