package com.example.aimediabot.controller;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.aimediabot.service.ImageGenerationService;

@Component
public class BotController extends TelegramLongPollingBot {

    @Autowired
    private ImageGenerationService imageGenerationService; // Inject the service

    @Override
    public String getBotUsername() {
        return "AIMEDIA1_bot"; // Your bot's username
    }

    @Override
    public String getBotToken() {
        return "7816672754:AAHEQMxcpB7c0K1ttAw98JGkczYkXvaQHlw"; // Your bot's token
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();

            // Log the received message
            System.out.println("Received message: " + messageText + " from chat: " + chatId);

            // Handle the /start command
            if (messageText.equals("/start")) {
                sendResponse(chatId, "Welcome to AIMEDIA Bot! Please enter a prompt for image generation.");
            } else {
                // Call the service to generate an image based on the prompt
                String imageUrl = imageGenerationService.generateImagePrompt(messageText);
                if (imageUrl != null) {
                    sendResponse(chatId, "Here is your generated image: " + imageUrl);
                } else {
                    sendResponse(chatId, "Sorry, I couldn't generate an image. Please try again.");
                }
            }
        }
    }

    // Helper method to send response messages
    private void sendResponse(Long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId.toString());
        message.setText(text);
        
        try {
            execute(message); // Call the Telegram API to send the message
            System.out.println("Response sent: " + text);
        } catch (TelegramApiException e) {
            System.err.println("Error sending message: " + e.getMessage());
        }
    }
}
