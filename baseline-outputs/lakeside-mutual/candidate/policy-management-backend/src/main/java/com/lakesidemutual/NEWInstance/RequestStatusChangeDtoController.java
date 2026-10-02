package com.lakesidemutual.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class RequestStatusChangeDtoController {

 private RequestStatusChangeDto requeststatuschangedto;

 private RequestStatusChangeDto requeststatuschangedto;


@PutMapping
("/setStatus")
public void setStatus(@RequestParam(name = "status") String status){
requeststatuschangedto.setStatus(status);
}


}