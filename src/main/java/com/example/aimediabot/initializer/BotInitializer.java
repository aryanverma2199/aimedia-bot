package com.example.aimediabot.initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import com.example.aimediabot.controller.BotController;

@Component
public class BotInitializer implements ApplicationRunner {

    @Autowired
    private BotController botController;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        try {
            botsApi.registerBot(botController);
            System.out.println("Bot registered successfully.");
        } catch (TelegramApiException e) {
            System.err.println("Error registering bot: " + e.getMessage());
        }
    }
}
