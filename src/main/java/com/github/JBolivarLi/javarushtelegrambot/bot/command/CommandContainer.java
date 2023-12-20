package com.github.JBolivarLi.javarushtelegrambot.bot.command;

import com.github.JBolivarLi.javarushtelegrambot.bot.javarushclient.JavaRushGroupClient;
import com.github.JBolivarLi.javarushtelegrambot.bot.service.GroupSubService;
import com.github.JBolivarLi.javarushtelegrambot.bot.service.SendBotMessageService;
import com.github.JBolivarLi.javarushtelegrambot.bot.service.SendBotMessageServiceImpl;
import com.github.JBolivarLi.javarushtelegrambot.bot.service.TelegramUserService;

import java.util.Map;


import static com.github.JBolivarLi.javarushtelegrambot.bot.command.CommandName.*;

public class CommandContainer {
    private final Map<String, Command> commandMap;
    private final Command unknownCommand;


    public CommandContainer(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService, JavaRushGroupClient javaRushGroupClient, GroupSubService groupSubService) {
        commandMap =
                Map.ofEntries(Map.entry(START.getCommandName(), new StartCommand(sendBotMessageService, telegramUserService)),
                        Map.entry(STOP.getCommandName(), new StopCommand(sendBotMessageService, telegramUserService)),
                        Map.entry(HELP.getCommandName(), new HelpCommand(sendBotMessageService)),
                        Map.entry(NO.getCommandName(), new NoCommand(sendBotMessageService)),
                        Map.entry(STAT.getCommandName(), new StatCommand(sendBotMessageService, telegramUserService)),
                        Map.entry(ADD_GROUP_SUB.getCommandName(), new AddGroupSubCommand(sendBotMessageService, javaRushGroupClient, groupSubService)),
                        Map.entry(LIST_GROUP_SUB.getCommandName(), new ListGroupSubCommand(sendBotMessageService, telegramUserService)),
                        Map.entry(DELETE_GROUP_SUB.getCommandName(), new DeleteGroupSubCommand(sendBotMessageService, groupSubService, telegramUserService)));


                        unknownCommand = new UnknownCommand(sendBotMessageService);
    }

    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }
}
