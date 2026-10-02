package com.youlai.mall.listener;
 import com.youlai.mall.service.system.SysMenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import java.util.Arrays;
@Component
@Slf4j
@RequiredArgsConstructor
public class CanalListener {

 private  SysMenuService menuService;


public void handleDataChange(){
}


}