package com.goodskill.controller;
 import com.goodskill.ai.UserSupportAssistant;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
@RequestMapping("/api/assistant")
@RestController
@ConditionalOnBean(ChatModel.class)
public class AssistantController {

 private  UserSupportAssistant agent;

public AssistantController(UserSupportAssistant agent) {
    this.agent = agent;
}
@RequestMapping(path = "/chat", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
public Flux<String> chat(String chatId,String userMessage){
    return agent.chat(chatId, userMessage);
}


}