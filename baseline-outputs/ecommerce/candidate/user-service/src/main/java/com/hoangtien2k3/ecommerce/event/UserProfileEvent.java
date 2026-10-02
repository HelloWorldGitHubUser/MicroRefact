package com.hoangtien2k3.ecommerce.event;
 import com.hoangtien2k3.ecommerce.dto.EmailDetails;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import com.hoangtien2k3.ecommerce.Interface.EmailDetails;
@Getter
public class UserProfileEvent extends ApplicationEvent{

 private  EmailDetails emailDetails;

public UserProfileEvent(Object source, EmailDetails emailDetails) {
    super(source);
    this.emailDetails = emailDetails;
}
}