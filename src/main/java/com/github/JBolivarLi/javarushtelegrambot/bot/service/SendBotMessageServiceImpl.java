package com.github.JBolivarLi.javarushtelegrambot.bot.service;

import com.github.JBolivarLi.javarushtelegrambot.bot.bot.JavarushTelegramBot;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

import static org.springframework.util.CollectionUtils.isEmpty;

@Service
public class SendBotMessageServiceImpl implements SendBotMessageService{
    private final JavarushTelegramBot javarushBot;

    @Autowired
    public SendBotMessageServiceImpl(JavarushTelegramBot javarushBot) {
        this.javarushBot = javarushBot;
    }



    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        try {
            javarushBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            //todo add logging to the project.
            e.printStackTrace();
        }
    }

    @Override
    public void sendMessage(String chatId, List<String> messages) {
         {
            if (isEmpty(messages)) return;

            messages.forEach(m -> sendMessage(chatId, m));
        }
    }
}
