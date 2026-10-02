package ltd.newbee.mall.api.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class MallUserMapperController {

 private MallUserMapper mallusermapper;


@GetMapping
("/selectByPrimaryKey")
public MallUser selectByPrimaryKey(@RequestParam(name = "userId") Long userId){
  return mallusermapper.selectByPrimaryKey(userId);
}


}