package com.github.JBolivarLi.javarushtelegrambot.bot.bot;
import com.github.JBolivarLi.javarushtelegrambot.bot.command.CommandContainer;
import com.github.JBolivarLi.javarushtelegrambot.bot.service.SendBotMessageServiceImpl;
import com.github.JBolivarLi.javarushtelegrambot.bot.service.TelegramUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static com.github.JBolivarLi.javarushtelegrambot.bot.command.CommandName.NO;

@Component
public class JavarushTelegramBot extends TelegramLongPollingBot {
    public static String COMMAND_PREFIX = "/";
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
    private final CommandContainer commandContainer;


    @Autowired
    public JavarushTelegramBot(TelegramUserService telegramUserService) {
        this.commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this), telegramUserService);
    }
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            if (message.startsWith(COMMAND_PREFIX)){
                String commandIdentifier = message.split(" ")[0].toLowerCase();
                commandContainer.retrieveCommand(commandIdentifier).execute(update);
            } else {
                commandContainer.retrieveCommand(NO.getCommandName()).execute(update);
            }
        }
    }
}