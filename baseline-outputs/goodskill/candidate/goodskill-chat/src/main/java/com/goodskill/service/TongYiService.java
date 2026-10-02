package com.goodskill.service;
 import com.goodskill.dto.ActorsFilmsDTO;
import com.goodskill.dto.CompletionDTO;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.ai.image.ImageResponse;
import java.util.List;
import java.util.Map;
public interface TongYiService {


public String completion(String message)
;

public List<Double> textEmbedding(String text)
;

public AssistantMessage genRole(String message,String name,String voice)
;

public ImageResponse genImg(String imgPrompt)
;

public AssistantMessage genPromptTemplates(String adjective,String topic)
;

public CompletionDTO stuffCompletion(String message,boolean stuffit)
;

public String genAudio(String text)
;

public Map<String,String> streamCompletion(String message)
;

public ActorsFilmsDTO genOutputParse(String actor)
;

public String audioTranscription(String audioUrls)
;

}