package com.github.JBolivarLi.javarushtelegrambot.bot.command;

import com.github.JBolivarLi.javarushtelegrambot.bot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.JBolivarLi.javarushtelegrambot.bot.command.CommandName.*;
import static com.github.JBolivarLi.javarushtelegrambot.bot.command.CommandName.STAT;
import static com.github.JBolivarLi.javarushtelegrambot.bot.command.CommandUtils.getChatId;

public class HelpCommand implements Command {

    private final SendBotMessageService sendBotMessageService;


    public static final String HELP_MESSAGE = String.format("✨Дотупные команды✨\n\n"

                    + "Начать\\закончить работу с ботом:\n"
                    + "%s - начать работу со мной\n"
                    + "%s - приостановить работу со мной\n\n"

                    + "Работа с подписками на группы:\n"
                    + "%s - подписаться на группу статей\n"
                    + "%s - отписаться от группы статей\n"
                    + "%s - получить список групп, на которые подписан\n\n"

                    + "%s - получить помощь в работе со мной\n",
            START.getCommandName(), STOP.getCommandName(), ADD_GROUP_SUB.getCommandName(),
            DELETE_GROUP_SUB.getCommandName(), LIST_GROUP_SUB.getCommandName(), HELP.getCommandName());


    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(getChatId(update), HELP_MESSAGE);
    }
}