package com.github.JBolivarLi.javarushtelegrambot.bot.command;

import com.github.JBolivarLi.javarushtelegrambot.bot.service.SendBotMessageService;
import com.github.JBolivarLi.javarushtelegrambot.bot.service.SendBotMessageServiceImpl;

import java.util.Map;

import static com.github.JBolivarLi.javarushtelegrambot.bot.command.CommandName.*;

public class CommandContainer {
    private final Map<String, Command> commandMap;
    private final Command unknownCommand;

    public CommandContainer(SendBotMessageService sendBotMessageService) {
        commandMap = Map.ofEntries(Map.entry(START.getCommandName(), new StartCommand(sendBotMessageService)),
                Map.entry(STOP.getCommandName(), new StopCommand(sendBotMessageService)),
                Map.entry(HELP.getCommandName(), new HelpCommand(sendBotMessageService)),
                Map.entry(NO.getCommandName(), new NoCommand(sendBotMessageService)));

        unknownCommand = new UnknownCommand(sendBotMessageService);
    }

    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }
}
