package command;

import com.github.JBolivarLi.javarushtelegrambot.bot.command.Command;
import com.github.JBolivarLi.javarushtelegrambot.bot.command.StatCommand;

import static com.github.JBolivarLi.javarushtelegrambot.bot.command.CommandName.STAT;
import static com.github.JBolivarLi.javarushtelegrambot.bot.command.StatCommand.STAT_MESSAGE;

public class StatCommandTest extends AbstractCommandTest{

    @Override
    String getCommandName() {
        return STAT.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return String.format(STAT_MESSAGE, 0);
    }

    @Override
    Command getCommand() {
        return new StatCommand(sendBotMessageService, telegramUserService);
    }
}
