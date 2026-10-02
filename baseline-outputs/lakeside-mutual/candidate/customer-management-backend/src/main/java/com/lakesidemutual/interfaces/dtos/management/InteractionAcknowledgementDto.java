package com.lakesidemutual.interfaces.dtos.management;
 import jakarta.validation.constraints.NotEmpty;
public class InteractionAcknowledgementDto {

@NotEmpty
 private  String lastAcknowledgedInteractionId;

public InteractionAcknowledgementDto() {
}public InteractionAcknowledgementDto(String lastAcknowledgedInteractionId) {
    this.lastAcknowledgedInteractionId = lastAcknowledgedInteractionId;
}
public void setLastAcknowledgedInteractionId(String lastAcknowledgedInteractionId){
    this.lastAcknowledgedInteractionId = lastAcknowledgedInteractionId;
}


public String getLastAcknowledgedInteractionId(){
    return lastAcknowledgedInteractionId;
}


}