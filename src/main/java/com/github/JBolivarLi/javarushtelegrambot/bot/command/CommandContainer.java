package com.github.JBolivarLi.javarushtelegrambot.bot.command;

import com.github.JBolivarLi.javarushtelegrambot.bot.command.annotation.AdminCommand;
import com.github.JBolivarLi.javarushtelegrambot.bot.javarushclient.JavaRushGroupClient;
import com.github.JBolivarLi.javarushtelegrambot.bot.service.*;

import java.util.List;
import java.util.Map;


import static com.github.JBolivarLi.javarushtelegrambot.bot.command.CommandName.*;

public class CommandContainer {
    private final Map<String, Command> commandMap;
    private final Command unknownCommand;
    private final List<String> admins;



    public CommandContainer(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService,
                            JavaRushGroupClient javaRushGroupClient, GroupSubService groupSubService, List<String> admins, StatisticsService statisticsService) {
        this.admins = admins;
        commandMap =
                Map.ofEntries(Map.entry(START.getCommandName(), new StartCommand(sendBotMessageService, telegramUserService)),
                        Map.entry(STOP.getCommandName(), new StopCommand(sendBotMessageService, telegramUserService)),
                        Map.entry(HELP.getCommandName(), new HelpCommand(sendBotMessageService)),
                        Map.entry(NO.getCommandName(), new NoCommand(sendBotMessageService)),
                        Map.entry(STAT.getCommandName(), new StatCommand(sendBotMessageService, statisticsService)),
                        Map.entry(ADD_GROUP_SUB.getCommandName(), new AddGroupSubCommand(sendBotMessageService, javaRushGroupClient, groupSubService)),
                        Map.entry(LIST_GROUP_SUB.getCommandName(), new ListGroupSubCommand(sendBotMessageService, telegramUserService)),
                        Map.entry(DELETE_GROUP_SUB.getCommandName(), new DeleteGroupSubCommand(sendBotMessageService, groupSubService, telegramUserService)),
                        Map.entry(ADMIN_HELP.getCommandName(), new AdminHelpCommand(sendBotMessageService)));


        unknownCommand = new UnknownCommand(sendBotMessageService);
    }


    public Command findCommand(String commandIdentifier, String username) {
        Command orDefault = commandMap.getOrDefault(commandIdentifier, unknownCommand);

        if (isAdminCommand(orDefault)) {
            if (admins.contains(username)) {
                return orDefault;
            } else {
                return unknownCommand;
            }
        }
        return orDefault;
    }

    private boolean isAdminCommand(Command command) {
        AdminCommand adminCommandAnnotation = command.getClass().getAnnotation(AdminCommand.class);
        return adminCommandAnnotation != null;
    }

}
