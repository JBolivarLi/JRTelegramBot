package com.github.JBolivarLi.javarushtelegrambot.bot.command;

import com.github.JBolivarLi.javarushtelegrambot.bot.service.SendBotMessageService;
import com.github.JBolivarLi.javarushtelegrambot.bot.service.TelegramUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StatCommand implements Command {

    private final TelegramUserService telegramUserService;
    private final SendBotMessageService sendBotMessageService;

    public final static String STAT_MESSAGE = "Javarush Telegram Bot использует %s человек.";

    @Autowired
    public StatCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        int activeUserCount = telegramUserService.retrieveAllActiveUsers().size();
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), String.format(STAT_MESSAGE, activeUserCount));
    }
}
