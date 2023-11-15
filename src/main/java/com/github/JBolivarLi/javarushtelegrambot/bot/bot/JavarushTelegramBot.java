package com.github.JBolivarLi.javarushtelegrambot.bot.bot;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class JavarushTelegramBot extends TelegramLongPollingBot {
    @Value("${bot.username}")
    private String username;

    @Value("${bot.token}")
    private String token;

    public String getBotUsername() {
        return  username;
    }

    public String getBotToken() {
        return token;
    }

    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            String chatId = update.getMessage().getChatId().toString();

            SendMessage sm = new SendMessage();
            sm.setChatId(chatId);
            sm.setText(message + "\n" + "fromBolivarBotWithLove");

            try {
                execute(sm);
            } catch (TelegramApiException e) {
                //todo add logging to the project.
                e.printStackTrace();
            }
        }

    }
}
