package ltd.newbee.mall.api.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class NewBeeMallUserTokenMapperController {

 private NewBeeMallUserTokenMapper newbeemallusertokenmapper;


@GetMapping
("/selectByToken")
public MallUserToken selectByToken(@RequestParam(name = "token") String token){
  return newbeemallusertokenmapper.selectByToken(token);
}


}