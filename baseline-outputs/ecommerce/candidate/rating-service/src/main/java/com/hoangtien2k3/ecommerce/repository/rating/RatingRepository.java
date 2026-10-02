package com.hoangtien2k3.ecommerce.repository.rating;
 import com.hoangtien2k3.ecommerce.model.rating.Rating;
import java.time.ZonedDateTime;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface RatingRepository extends JpaRepository<Rating, Long>{


@Query(value = "SELECT SUM(r.ratingStar), COUNT(r) FROM Rating r Where r.productId = :productId")
public List<Object[]> getTotalStarsAndTotalRatings(long productId)
;

public Page<Rating> findByProductId(Long id,Pageable pageable)
;

public boolean existsByCreatedByAndProductId(String createdBy,Long productId)
;

@Query(value = "SELECT r FROM Rating r " + "Where (LOWER(r.productName) LIKE %:productName%) " + "AND CONCAT(LOWER(r.firstName), ' ', LOWER(r.lastName)) LIKE %:customerName% " + "AND LOWER(r.content) LIKE %:message% " + "AND r.createdOn BETWEEN :createdFrom AND :createdTo")
public Page<Rating> getRatingListWithFilter(String productName,String customerName,String message,ZonedDateTime createdFrom,ZonedDateTime createdTo,Pageable pageable)
;

}