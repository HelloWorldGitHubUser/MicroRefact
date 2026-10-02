package com.lakesidemutual.interfaces.dtos.policy.policy;
 import java.util.List;
import org.springframework.hateoas.RepresentationModel;
public class PaginatedPolicyResponseDto extends RepresentationModel{

 private  int limit;

 private  int offset;

 private  int size;

 private  List<PolicyDto> policies;

public PaginatedPolicyResponseDto(int limit, int offset, int size, List<PolicyDto> policies) {
    this.limit = limit;
    this.offset = offset;
    this.size = size;
    this.policies = policies;
}
public int getSize(){
    return size;
}


public List<PolicyDto> getPolicies(){
    return policies;
}


public int getLimit(){
    return limit;
}


public int getOffset(){
    return offset;
}


}