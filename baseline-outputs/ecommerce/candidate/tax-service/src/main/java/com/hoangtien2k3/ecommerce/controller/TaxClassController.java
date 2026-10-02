package com.hoangtien2k3.ecommerce.controller;
 import com.hoangtien2k3.ecommerce.constants.ApiConstant;
import com.hoangtien2k3.ecommerce.constants.PageableConstant;
import com.hoangtien2k3.ecommerce.model.tax.TaxClass;
import com.hoangtien2k3.ecommerce.service.TaxClassService;
import com.hoangtien2k3.ecommerce.dto.ErrorVm;
import com.hoangtien2k3.ecommerce.dto.TaxClassListGetVm;
import com.hoangtien2k3.ecommerce.dto.TaxClassPostVm;
import com.hoangtien2k3.ecommerce.dto.TaxClassVm;
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
@RequestMapping(ApiConstant.TAX_CLASS_URL)
@PreAuthorize("hasAuthority('ADMIN')")
public class TaxClassController {

 private  TaxClassService taxClassService;

public TaxClassController(TaxClassService taxClassService) {
    this.taxClassService = taxClassService;
}
@GetMapping
public ResponseEntity<List<TaxClassVm>> listTaxClasses(){
    return ResponseEntity.ok(taxClassService.findAllTaxClasses());
}


@GetMapping("/paging")
public ResponseEntity<TaxClassListGetVm> getPageableTaxClasses(int pageNo,int pageSize){
    return ResponseEntity.ok(taxClassService.getPageableTaxClasses(pageNo, pageSize));
}


@PostMapping
@ApiResponses(value = { @ApiResponse(responseCode = ApiConstant.CODE_201, description = ApiConstant.CREATED, content = @Content(schema = @Schema(implementation = TaxClassVm.class))), @ApiResponse(responseCode = ApiConstant.CODE_400, description = ApiConstant.BAD_REQUEST, content = @Content(schema = @Schema(implementation = ErrorVm.class))) })
public ResponseEntity<TaxClassVm> createTaxClass(TaxClassPostVm taxClassPostVm,UriComponentsBuilder uriComponentsBuilder){
    final TaxClass taxClass = taxClassService.create(taxClassPostVm);
    return ResponseEntity.created(uriComponentsBuilder.replacePath("/tax/backoffice/tax-classes/{id}").buildAndExpand(taxClass.getId()).toUri()).body(TaxClassVm.fromModel(taxClass));
}


@GetMapping("/{id}")
@ApiResponses(value = { @ApiResponse(responseCode = ApiConstant.CODE_200, description = ApiConstant.OK, content = @Content(schema = @Schema(implementation = TaxClassVm.class))), @ApiResponse(responseCode = ApiConstant.CODE_404, description = ApiConstant.NOT_FOUND, content = @Content(schema = @Schema(implementation = ErrorVm.class))) })
public ResponseEntity<TaxClassVm> getTaxClass(Long id){
    return ResponseEntity.ok(taxClassService.findById(id));
}


@DeleteMapping("/{id}")
@ApiResponses(value = { @ApiResponse(responseCode = ApiConstant.CODE_204, description = ApiConstant.NO_CONTENT, content = @Content()), @ApiResponse(responseCode = ApiConstant.CODE_404, description = ApiConstant.NOT_FOUND, content = @Content(schema = @Schema(implementation = ErrorVm.class))), @ApiResponse(responseCode = ApiConstant.CODE_400, description = ApiConstant.BAD_REQUEST, content = @Content(schema = @Schema(implementation = ErrorVm.class))) })
public ResponseEntity<Void> deleteTaxClass(Long id){
    taxClassService.delete(id);
    return ResponseEntity.noContent().build();
}


@PutMapping("/{id}")
@ApiResponses(value = { @ApiResponse(responseCode = ApiConstant.CODE_204, description = ApiConstant.NO_CONTENT, content = @Content()), @ApiResponse(responseCode = ApiConstant.CODE_404, description = ApiConstant.NOT_FOUND, content = @Content(schema = @Schema(implementation = ErrorVm.class))), @ApiResponse(responseCode = ApiConstant.CODE_400, description = ApiConstant.BAD_REQUEST, content = @Content(schema = @Schema(implementation = ErrorVm.class))) })
public ResponseEntity<Void> updateTaxClass(Long id,TaxClassPostVm taxClassPostVm){
    taxClassService.update(taxClassPostVm, id);
    return ResponseEntity.noContent().build();
}


}