package ltd.newbee.mall.api.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class NewBeeAdminUserTokenMapperController {

 private NewBeeAdminUserTokenMapper newbeeadminusertokenmapper;


@GetMapping
("/selectByToken")
public AdminUserToken selectByToken(@RequestParam(name = "token") String token){
  return newbeeadminusertokenmapper.selectByToken(token);
}


}