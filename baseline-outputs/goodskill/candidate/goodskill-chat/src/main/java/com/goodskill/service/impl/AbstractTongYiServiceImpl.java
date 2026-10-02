package com.goodskill.service.impl;
 import com.goodskill.dto.ActorsFilmsDTO;
import com.goodskill.dto.CompletionDTO;
import com.goodskill.service.TongYiService;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.image.ImageResponse;
import java.util.List;
import java.util.Map;
public class AbstractTongYiServiceImpl implements TongYiService{

 private  String INFO_PREFIX;

 private  String INFO_SUFFIX;


@Override
public String completion(String message){
    throw new RuntimeException(INFO_PREFIX + Thread.currentThread().getStackTrace()[2].getMethodName());
}


@Override
public List<Double> textEmbedding(String text){
    throw new RuntimeException(INFO_PREFIX + Thread.currentThread().getStackTrace()[2].getMethodName() + INFO_SUFFIX);
}


@Override
public AssistantMessage genRole(String message,String name,String voice){
    throw new RuntimeException(INFO_PREFIX + Thread.currentThread().getStackTrace()[2].getMethodName() + INFO_SUFFIX);
}


@Override
public ImageResponse genImg(String imgPrompt){
    throw new RuntimeException(INFO_PREFIX + Thread.currentThread().getStackTrace()[2].getMethodName() + INFO_SUFFIX);
}


@Override
public AssistantMessage genPromptTemplates(String adjective,String topic){
    throw new RuntimeException(INFO_PREFIX + Thread.currentThread().getStackTrace()[2].getMethodName() + INFO_SUFFIX);
}


@Override
public CompletionDTO stuffCompletion(String message,boolean stuffit){
    throw new RuntimeException(INFO_PREFIX + Thread.currentThread().getStackTrace()[2].getMethodName() + INFO_SUFFIX);
}


@Override
public String genAudio(String text){
    throw new RuntimeException(INFO_PREFIX + Thread.currentThread().getStackTrace()[2].getMethodName() + INFO_SUFFIX);
}


@Override
public Map<String,String> streamCompletion(String message){
    throw new RuntimeException(INFO_PREFIX + Thread.currentThread().getStackTrace()[2].getMethodName() + INFO_SUFFIX);
}


@Override
public ActorsFilmsDTO genOutputParse(String actor){
    throw new RuntimeException(INFO_PREFIX + Thread.currentThread().getStackTrace()[2].getMethodName() + INFO_SUFFIX);
}


@Override
public String audioTranscription(String url){
    throw new RuntimeException(INFO_PREFIX + Thread.currentThread().getStackTrace()[2].getMethodName() + INFO_SUFFIX);
}


}