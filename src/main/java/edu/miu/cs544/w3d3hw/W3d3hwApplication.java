package edu.miu.cs544.w3d3hw;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.api.Advisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class W3d3hwApplication {

    public static void main(String[] args) {
        SpringApplication.run(W3d3hwApplication.class, args);
    }

    @Bean
    public ChatClient chatClient(ChatModel chatModel) {
        ChatMemory chatMemory = MessageWindowChatMemory.builder().build();
        Advisor memory = MessageChatMemoryAdvisor.builder(chatMemory).build();
        ChatClient.Builder builder = ChatClient.builder(chatModel);
        builder.defaultAdvisors(memory);
        return builder.build();
    }
}
