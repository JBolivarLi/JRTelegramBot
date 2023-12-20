package com.github.JBolivarLi.javarushtelegrambot.bot.command;

import com.github.JBolivarLi.javarushtelegrambot.bot.repository.entity.TelegramUser;
import com.github.JBolivarLi.javarushtelegrambot.bot.service.SendBotMessageService;
import com.github.JBolivarLi.javarushtelegrambot.bot.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;
import com.github.JBolivarLi.javarushtelegrambot.bot.repository.entity.GroupSub;
import java.util.stream.Collectors;
import javax.ws.rs.NotFoundException;

import static com.github.JBolivarLi.javarushtelegrambot.bot.command.CommandUtils.getChatId;

/**
 * {@link Command} for getting list of {@link GroupSub}.
 */
public class ListGroupSubCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public ListGroupSubCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        //todo add exception handling
        TelegramUser telegramUser = telegramUserService.findByChatId(getChatId(update))
                .orElseThrow(NotFoundException::new);

        String message = "Я нашел все подписки на группы: \n\n";
        String collectedGroups = telegramUser.getGroupSubs().stream()
                .map(it -> "Группа: " + it.getTitle() + " , ID = " + it.getId() + " \n")
                .collect(Collectors.joining());

        sendBotMessageService.sendMessage(telegramUser.getChatId(), message + collectedGroups);
    }
}