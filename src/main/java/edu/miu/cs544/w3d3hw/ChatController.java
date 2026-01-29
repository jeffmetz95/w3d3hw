package edu.miu.cs544.w3d3hw;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatClient chatClient;

    @GetMapping()
    public String getResponse(String prompt) {
        ChatResponse response = chatClient
                .prompt(prompt)
                .call().chatResponse();

        return response.getResult().getOutput().getText();
    }

    @GetMapping("/test")
    public String test(){
        return "good";
    }
}
