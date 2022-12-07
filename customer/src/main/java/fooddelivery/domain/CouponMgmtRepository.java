package fooddelivery.domain;

import fooddelivery.domain.*;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="couponMgmts", path="couponMgmts")
public interface CouponMgmtRepository extends PagingAndSortingRepository<CouponMgmt, Long>{

    Optional<CouponMgmt> findByCustomerId(String customerId);

}
