package com.hoangtien2k3.ecommerce.controller;
 import com.hoangtien2k3.ecommerce.constants.ApiConstant;
import com.hoangtien2k3.ecommerce.constants.PageableConstant;
import com.hoangtien2k3.ecommerce.model.tax.TaxRate;
import com.hoangtien2k3.ecommerce.service.TaxRateService;
import com.hoangtien2k3.ecommerce.dto.ErrorVm;
import com.hoangtien2k3.ecommerce.dto.TaxRateListGetVm;
import com.hoangtien2k3.ecommerce.dto.TaxRatePostVm;
import com.hoangtien2k3.ecommerce.dto.TaxRateVm;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import jakarta.validation.Valid;
@RestController
@RequestMapping(ApiConstant.TAX_RATE_URL)
@PreAuthorize("hasAuthority('ADMIN')")
public class TaxRateController {

 private  TaxRateService taxRateService;

public TaxRateController(TaxRateService taxRateService) {
    this.taxRateService = taxRateService;
}
@GetMapping("/{id}")
@ApiResponses(value = { @ApiResponse(responseCode = ApiConstant.CODE_200, description = ApiConstant.OK, content = @Content(schema = @Schema(implementation = TaxRateVm.class))), @ApiResponse(responseCode = ApiConstant.CODE_404, description = ApiConstant.NOT_FOUND, content = @Content(schema = @Schema(implementation = ErrorVm.class))) })
public ResponseEntity<TaxRateVm> getTaxRate(Long id){
    return ResponseEntity.ok(taxRateService.findById(id));
}


@PutMapping("/{id}")
@ApiResponses(value = { @ApiResponse(responseCode = ApiConstant.CODE_204, description = ApiConstant.NO_CONTENT, content = @Content()), @ApiResponse(responseCode = ApiConstant.CODE_404, description = ApiConstant.NOT_FOUND, content = @Content(schema = @Schema(implementation = ErrorVm.class))), @ApiResponse(responseCode = ApiConstant.CODE_400, description = ApiConstant.BAD_REQUEST, content = @Content(schema = @Schema(implementation = ErrorVm.class))) })
public ResponseEntity<Void> updateTaxRate(Long id,TaxRatePostVm taxRatePostVm){
    taxRateService.updateTaxRate(taxRatePostVm, id);
    return ResponseEntity.noContent().build();
}


@DeleteMapping("/{id}")
@ApiResponses(value = { @ApiResponse(responseCode = ApiConstant.CODE_204, description = ApiConstant.NO_CONTENT, content = @Content()), @ApiResponse(responseCode = ApiConstant.CODE_404, description = ApiConstant.NOT_FOUND, content = @Content(schema = @Schema(implementation = ErrorVm.class))), @ApiResponse(responseCode = ApiConstant.CODE_400, description = ApiConstant.BAD_REQUEST, content = @Content(schema = @Schema(implementation = ErrorVm.class))) })
public ResponseEntity<Void> deleteTaxRate(Long id){
    taxRateService.delete(id);
    return ResponseEntity.noContent().build();
}


@GetMapping("/location-based-batch")
public ResponseEntity<List<TaxRateVm>> getBatchTaxPercentsByAddress(List<Long> taxClassIds,Long countryId,Long stateOrProvinceId,String zipCode){
    return ResponseEntity.ok(taxRateService.getBulkTaxRate(taxClassIds, countryId, stateOrProvinceId, zipCode));
}


@GetMapping("/tax-percent")
public ResponseEntity<Double> getTaxPercentByAddress(Long taxClassId,Long countryId,Long stateOrProvinceId,String zipCode){
    return ResponseEntity.ok(taxRateService.getTaxPercent(taxClassId, countryId, stateOrProvinceId, zipCode));
}


@PostMapping
@ApiResponses(value = { @ApiResponse(responseCode = ApiConstant.CODE_201, description = ApiConstant.CREATED, content = @Content(schema = @Schema(implementation = TaxRateVm.class))), @ApiResponse(responseCode = ApiConstant.CODE_400, description = ApiConstant.BAD_REQUEST, content = @Content(schema = @Schema(implementation = ErrorVm.class))) })
public ResponseEntity<TaxRateVm> createTaxRate(TaxRatePostVm taxRatePostVm,UriComponentsBuilder uriComponentsBuilder){
    final TaxRate taxRate = taxRateService.createTaxRate(taxRatePostVm);
    return ResponseEntity.created(uriComponentsBuilder.replacePath("/tax/backoffice/tax-rates/{id}").buildAndExpand(taxRate.getId()).toUri()).body(TaxRateVm.fromModel(taxRate));
}


@GetMapping("/paging")
public ResponseEntity<TaxRateListGetVm> getPageableTaxRates(int pageNo,int pageSize){
    return ResponseEntity.ok(taxRateService.getPageableTaxRates(pageNo, pageSize));
}


}