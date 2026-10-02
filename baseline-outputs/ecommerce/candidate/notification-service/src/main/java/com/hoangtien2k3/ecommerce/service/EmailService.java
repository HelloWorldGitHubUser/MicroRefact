package com.hoangtien2k3.ecommerce.service;
 import com.hoangtien2k3.ecommerce.dto.EmailDetails;
import org.springframework.web.multipart.MultipartFile;
public interface EmailService {


public String sendMail(MultipartFile[] file,String to,String[] cc,String subject,String body)
;

public String sendSimpleMail(EmailDetails details)
;

public String sendMailWithAttachment(EmailDetails details)
;

}