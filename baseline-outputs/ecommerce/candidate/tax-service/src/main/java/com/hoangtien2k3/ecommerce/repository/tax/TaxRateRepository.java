package com.hoangtien2k3.ecommerce.repository.tax;
 import com.hoangtien2k3.ecommerce.model.tax.TaxRate;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface TaxRateRepository extends JpaRepository<TaxRate, Long>{


@Query(value = "SELECT rate FROM tax_rate tr WHERE tr.country_id = :countryId " + "AND (tr.state_or_province_id = :stateOrProvinceId OR  tr.state_or_province_id is null) " + "AND tr.tax_class_id = :taxClassId " + "AND (tr.zip_code = :zipCode OR  trim(tr.zip_code) = '' OR  tr.zip_code is null ) " + "FETCH FIRST 1 ROWS ONLY", nativeQuery = true)
public Double getTaxPercent(Long countryId,Long stateOrProvinceId,String zipCode,Long taxClassId)
;

@Query(value = """
    SELECT tr FROM TaxRate tr
    WHERE tr.countryId = :countryId
    AND (tr.stateOrProvinceId = :stateOrProvinceId OR  tr.stateOrProvinceId is null)
    AND (tr.zipCode = :zipCode OR  tr.zipCode is null )
    AND tr.taxClass.id in :taxClassIds
    """)
public List<TaxRate> getBatchTaxRates(Long countryId,Long stateOrProvinceId,String zipCode,Set<Long> taxClassIds)
;

}